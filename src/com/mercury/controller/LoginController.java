package com.mercury.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	
	@RequestMapping(value="/security/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "/security/login";
	}
	
	@RequestMapping(value="/main", method = RequestMethod.GET)
	public ModelAndView mainPage() {	
		ModelAndView mav = new ModelAndView();
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.setViewName("hello");
		mav.addObject("title", "Hello, " + user.getUsername() + " welcome to Customized Spring Security");
		return mav;
	}
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String homePage() {
		return "/home";
	}
}
