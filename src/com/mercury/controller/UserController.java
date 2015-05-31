package com.mercury.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mercury.bean.User;
import com.mercury.service.JavaMailService;
import com.mercury.service.UserService;

;

@Controller
@SessionAttributes
public class UserController {
	@Autowired
	@Qualifier("userService")
	private UserService us;

	@Autowired
	@Qualifier("javaMailService")
	private JavaMailService jms;

	private org.springframework.security.core.userdetails.User getUserDetails() {
		return (org.springframework.security.core.userdetails.User) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
	}
	
	@RequestMapping(value = "/account/signup", method = RequestMethod.GET)
	public String accountPage() {
		return "/account/signup";
	}

	@RequestMapping(value = "/account/register", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView processUser(@ModelAttribute("user") User user) {
		ModelAndView mav = new ModelAndView();
		// Duplicates
		if (us.checkUser(user.getUsername()) != null) {
			mav.setViewName("signup");
			mav.addObject("message", "Hello, the username is existed");
			return mav;
			// Success
		} else {
			us.saveUser(user);
			// send email here....
			String from = "sijiyangyi24@gmail.com";
			String to = user.getEmail();
			String subject = "Dear: " + user.getUsername();
			String msg = "Please click the following link to activate your account"
					+ "\n"
					+ "http://localhost:8080/EMC/account/activate.html?id="
					+ user.getUsername();
			jms.sendMail(from, to, subject, msg);
			mav.setViewName("home");
			mav.addObject("message", "Hello, the username is OK");
			return mav;
		}
	}

	// updatePassWord
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public ModelAndView updatePassword(
			@RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword) {
		ModelAndView mav = new ModelAndView();
		User user = us.checkUser(getUserDetails().getUsername());
		// old password is wrong
		if (!oldPassword.equals(user.getPassword())) {
			mav.setViewName("account/updatePassword"); // go back to updatePassword page
			mav.addObject("message", "Sorry, your old password is wrong!");
		// old password is correct
		} else {
			us.updatePassword(getUserDetails().getUsername(), newPassword);
			mav.setViewName("home"); // go to home page
			mav.addObject("message", "Your password is updated succeed!");
		}
		return mav;

	}

	// updateEmail
	@RequestMapping(value = "/changeEmail", method = RequestMethod.POST)
	public ModelAndView updateEmail(@RequestParam("newEmail") String newEmail) {
		ModelAndView mav = new ModelAndView();
		us.updateEmail(getUserDetails().getUsername(), newEmail);
		mav.setViewName("home"); // go to home page
		mav.addObject("message", "Your email is updated succeed!");
		return mav;
	}

	// activate user account
	@RequestMapping(value = "/account/activate", method = RequestMethod.GET)
	public String activateUserAccountPage(@RequestParam("id") String id) {
		System.out.println(id);
		us.activateUser(id);
		return "/account/activate";
	}

}
