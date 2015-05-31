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
import com.mercury.service.UserService;;

@Controller
@SessionAttributes
public class UserController {
	@Autowired
	@Qualifier("userService")
	private UserService us;
	
	@Autowired
	@Qualifier("javaMailService")
	private JavaMailService jms;
	
	@RequestMapping(value="/account/signup", method = RequestMethod.GET)
	public String accountPage(){
		return "/account/signup";
	}
	
	@RequestMapping(value = "/account/register", method = RequestMethod.POST)	
	@ResponseBody
	public ModelAndView processUser(@ModelAttribute("user") User user)   {
		ModelAndView mav = new ModelAndView();
		// Duplicates
		if(us.checkUser(user.getUsername())!= null){
			mav.setViewName("signup");
			mav.addObject("message", "Hello, the username is existed");
			return mav;
		// Success
		}else{
			us.saveUser(user);
			// send email here....
			String from = "sijiyangyi24@gmail.com";
			String to = user.getEmail();
			String subject = "Dear: " + user.getUsername();
			String msg = "Please click the following link to activate your account" +"\n" + 
			"http://localhost:8080/EMC/account/activate.html?id="+user.getUsername();
			jms.sendMail(from, to, subject, msg);
			mav.setViewName("home");
			mav.addObject("message", "Hello, the username is OK");
			return mav;
		}
	}

	//updatePassWord
	@RequestMapping(value="/account/update", method = RequestMethod.GET)
	public String updatePasswordPage(){
		return "/account/update";
	}
	@RequestMapping(value = "/account/update", method = RequestMethod.POST)	
	@ResponseBody
	public ModelAndView updatePassword(@RequestParam("originalPassword") String password,
			@RequestParam("updatePassword") String updatePassword) {
		ModelAndView mav = new ModelAndView();
		org.springframework.security.core.userdetails.User userDetails 
			= (org.springframework.security.core.userdetails.User)
				SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = us.checkUser(userDetails.getUsername());
		if(!password.equals(user.getPassword())) {
			System.out.println("error");
			mav.setViewName("update");
			mav.addObject("message", "Your input password is not the same as original password");
			return mav;
		}else{
			System.out.println("OK");
			us.updatePassword(userDetails.getUsername(), updatePassword);
			mav.setViewName("home");
			mav.addObject("message", "Hello, the user's password is updated");
		}
		return mav;
		
	}
	//updateEmail
	@RequestMapping(value="/account/updateEmail", method = RequestMethod.GET)
	public String updateEmailPage(){
		return "/account/updateEmail";
	}
	@RequestMapping(value = "/account/updateEmail", method = RequestMethod.POST)	
	@ResponseBody
	public ModelAndView updateEmail(@RequestParam("updateEmail") String updateEmail) {
		ModelAndView mav = new ModelAndView();
		org.springframework.security.core.userdetails.User userDetails 
			= (org.springframework.security.core.userdetails.User)
				SecurityContextHolder.getContext().getAuthentication().getPrincipal();		
		us.updateEmail(userDetails.getUsername(), updateEmail);
		mav.setViewName("home");
		mav.addObject("message", "Hello, the user's email is updated");
		return mav;
	}

	//activate user account
	@RequestMapping(value="/account/activate", method = RequestMethod.GET)
	public String activateUserAccountPage(@RequestParam("id") String id){
		System.out.println(id);
		us.activateUser(id);
		return "/account/activate";
	}

}

