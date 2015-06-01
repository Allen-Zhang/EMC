package com.mercury.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mercury.bean.User;
import com.mercury.service.JavaMailService;
import com.mercury.service.UserService;

@Controller
@SessionAttributes
public class UserController {
	@Autowired
	@Qualifier("userService")
	private UserService us;

	@Autowired
	@Qualifier("javaMailService")
	private JavaMailService jms;

	private org.springframework.security.core.userdetails.User getLoginUser() {
		return (org.springframework.security.core.userdetails.User) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
	}
	
	/*
	 * User Login
	 */
	@RequestMapping(value ="/welcome", method = RequestMethod.GET)
	public ModelAndView login() {	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		mav.addObject("success", "Welcome back " + getLoginUser().getUsername() + "!");
		return mav;
	}
	
	/* 
	 * Register account
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("user") User user) {
		ModelAndView mav = new ModelAndView();
		// username is existed
		if (us.checkUser(user.getUsername()) != null) {
			mav.setViewName("account/signup");  // go back to signup page
			mav.addObject("error", "Sorry, username is already existed.");
			return mav;
		} else {
			String encryptedPassword = us.getShaPassword(user.getPassword());
			System.out.println("pwd: "+encryptedPassword);
			user.setPassword(encryptedPassword);
			us.saveUser(user);
			// send email to user to activate the account 
			String from = "sijiyangyi24@gmail.com";
			String to = user.getEmail();
			String subject = "Dear: " + user.getUsername();
			String msg = "Please click the following link to activate your account"
					+ "\n"
					+ "http://localhost:8080/EMC/activate.html?id="
					+ user.getUsername();
			jms.sendMail(from, to, subject, msg);
			mav.setViewName("home");
			mav.addObject("success_long", "Congratulation! Your account is registered successfully.<br/>Please check your email (" + to + ") to activate your account.");
			return mav;
		}
	}
	
	/*
	 *  Activate account
	 */
	@RequestMapping(value = "/activate", method = RequestMethod.GET)
	public String activateAccount(@RequestParam("id") String id) {
		us.activateUser(id);
		return "/account/activate";
	}

	/*
	 *  Update Password
	 */
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public ModelAndView updatePassword(
			@RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword) {
		ModelAndView mav = new ModelAndView();
		User user = us.checkUser(getLoginUser().getUsername());
		// old password is wrong
		if (!oldPassword.equals(user.getPassword())) {
			mav.setViewName("account/updatePassword"); // go back to updatePassword page
			mav.addObject("error", "Sorry, your old password is wrong.");
		} else {
			us.updatePassword(getLoginUser().getUsername(), newPassword);
			mav.setViewName("home"); // go to home page
			mav.addObject("success", "Your password is updated successfully.");
		}
		return mav;
	}

	/*
	 *  Update Email
	 */
	@RequestMapping(value = "/changeEmail", method = RequestMethod.POST)
	public ModelAndView updateEmail(@RequestParam("newEmail") String newEmail) {
		ModelAndView mav = new ModelAndView();
		us.updateEmail(getLoginUser().getUsername(), newEmail);
		mav.setViewName("home"); // go to home page
		mav.addObject("success", "Your email is updated successfully.");
		return mav;
	}
	
	/* 
	 * Forget Password
	 */
	@RequestMapping(value = "/sendEmailToForgetPassword", method = RequestMethod.POST)
	public ModelAndView sendEmailToForgetPassword(@RequestParam("username") String username,
			@RequestParam("email") String email) {
		ModelAndView mav = new ModelAndView();
		User user = us.checkUser(username);
		// username is existed
		if (user!= null) {
			// send email to user to reset password 
			String from = "sijiyangyi24@gmail.com";
			//send to the email address that user entered,not the email of the user in the DB
			String to = email;
			String subject = "Dear: " + user.getUsername();
			String msg = "Please click the following link to reset your password:"
					+ "\n" + "http://localhost:8080/EMC/resetPassword.html?username="
					+user.getUsername();
			jms.sendMail(from, to, subject, msg);
			mav.setViewName("home");
			mav.addObject("success_long", "Please check your email (" + to + ") to reset your password.");
			return mav;
		} else {
			mav.setViewName("account/forgetPassword");  // go back to signup page
			mav.addObject("error", "Sorry, username is not existed.");
			return mav;
		}
	}
	
	/*
	 *  Reset password
	 */
	@RequestMapping(value = "/resetedPassword", method = RequestMethod.POST)
	public ModelAndView resetPassword(
			@RequestParam("newPassword") String newPassword,
			@RequestParam("username") String username) {
		us.updatePassword(username, newPassword);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		mav.addObject("success", "Password is reset successfully.");
		return mav;
	}
}
