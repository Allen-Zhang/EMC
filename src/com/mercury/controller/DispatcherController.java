package com.mercury.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DispatcherController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homePage() {
		return "home";
	}

	@RequestMapping(value = "/calculator", method = RequestMethod.GET)
	public String calculatorPage() {
		return "calculator/calculator";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String accountPage() {
		return "account/signup";
	}
	
	@RequestMapping(value = "/updatePassword", method = RequestMethod.GET)
	public String updatePasswordPage() {
		return "account/updatePassword";
	}

	@RequestMapping(value = "/updateEmail", method = RequestMethod.GET)
	public String updateEmailPage() {
		return "account/updateEmail";
	}

}
