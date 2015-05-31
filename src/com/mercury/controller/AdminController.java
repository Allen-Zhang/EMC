package com.mercury.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mercury.bean.Loan;
import com.mercury.service.MortgageService;

@Controller
@SessionAttributes
public class AdminController {
	@Autowired
	@Qualifier("mortgageService")
	private MortgageService ms;
	// RESTful web service
	@RequestMapping(value="/result", method=RequestMethod.POST)	
	@ResponseBody
	public double updatedInterestRate(@RequestBody Loan loan) {
		double interestRate = ms.getInterestRate(loan.getState(), loan.getLoanType());
		return interestRate;
	}
}

