package com.mercury.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value = "/updateInterestRate", method = RequestMethod.GET)
	public String updateInterestRatePage() {
		return "admin/updateInterestRate";
	}
	
	@RequestMapping(value = "/showInterestRate", method = RequestMethod.GET)
	public String showInterestRateTablePage() {
		return "admin/showInterestRate";
	}
	
	@RequestMapping(value = "/forgetPassword", method = RequestMethod.GET)
	public String showForgetPasswordPage() {
		return "account/forgetPassword";
	}
	@RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
	public ModelAndView showResetPasswordPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("account/resetPassword");
		mav.addObject("username", request.getParameter("username"));
		return mav;
	}
}
