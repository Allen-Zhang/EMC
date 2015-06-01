package com.mercury.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mercury.bean.InterestRate;
import com.mercury.bean.Loan;
import com.mercury.service.MortgageService;
import com.mercury.util.StateFormater;

@Controller
@SessionAttributes
public class AdminController {
	@Autowired
	@Qualifier("mortgageService")
	private MortgageService ms;
	
	// RESTful web service for get current interest rate
	@RequestMapping(value="/getOldInterestRate", method=RequestMethod.POST)	
	@ResponseBody
	public double getCurrentInterestRate(@RequestBody Loan loan) {
		double currInterestRate = ms.getInterestRate(loan.getState(), loan.getLoanType());
		return currInterestRate;
	}
	
	// Update specific interest rate
	@RequestMapping(value = "/changeInterestRate", method = RequestMethod.POST)
	public ModelAndView updateInterestRate( 
			@RequestParam("state") String state,
			@RequestParam("loanType") String loanType, 
			@RequestParam("newInterestRate") double newInterestRate) {
		ms.updateInterestRate(StateFormater.getInstance().abbreviate(state), loanType, newInterestRate);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/updateInterestRate");
		mav.addObject("success", "Update interest rate successfully.");
		return mav;
	}
	
	// RESTful web service for get all interest rates
	@RequestMapping(value = "/allRatesTypes", method = RequestMethod.GET)
	@ResponseBody
	public List<InterestRate> getAllRatesTypes() {
	    List<InterestRate> interestRateTypes = ms.getTypes();
	    return interestRateTypes;
	}
}


