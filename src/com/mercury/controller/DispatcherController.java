package com.mercury.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DispatcherController {

	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String homePage() {
		return "/layout/home";
	}
	
	@RequestMapping(value="/calculator")
	public String calculatorPage() {
		return "../calculator/calculator";
	}
	
//	@RequestMapping(value="/calculator")
//	public String calculatorPage() {
//		return "layout/calculator";
//	}
}
