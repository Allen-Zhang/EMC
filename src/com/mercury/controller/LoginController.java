package com.mercury.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.mercury.service.JavaMailService;
import com.mercury.service.EmailValidateService;

@Controller
public class LoginController {
	@Autowired
	@Qualifier("javaMailService")
	private JavaMailService jms;
	
	@RequestMapping(value="/security/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "/security/login";
	}
	
	@RequestMapping(value="/main", method = RequestMethod.GET)
	public ModelAndView mainPage() {	
		ModelAndView mav = new ModelAndView();
		
		String from = "sijiyangyi24@gmail.com";
		String to = "iloveliverpoolgo@gmail.com";
		String subject = "Thanks for registeration!";
		String msg = "Dear new user:Please click the following link to activate your account";
		EmailValidateService evs = new EmailValidateService();
		if (evs.validateEmail(to)) {
			jms.sendMail(from, to, subject, msg);
			mav.setViewName("hello");
			mav.addObject("title", "Hello, welcome to Customized Spring Security");
		}else{
		mav.setViewName("login");
		mav.addObject("message", "Fail");
		}

		return mav;
	}
}
