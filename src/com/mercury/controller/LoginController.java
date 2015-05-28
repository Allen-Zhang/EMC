package com.mercury.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.mercury.service.JavaMailService;

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
		mav.setViewName("hello");
		mav.addObject("title", "Hello, welcome to Customized Spring Security");
		/*String sender = "sijiyangyi24@gmail.com";
		String receiver = "diaoyakun@gmail.com";*/
		String dear = "new user";
		String content = "Please click the following link to activate your account";
		System.out.println("begin sending");
		jms.sendMail(dear, content);
		System.out.println("done sending");
		return mav;
	}
}
