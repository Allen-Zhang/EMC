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
import com.mercury.util.MortgageCalculator;

@Controller
@SessionAttributes
public class MortgageController {
	@Autowired
	@Qualifier("mortgageService")
	private MortgageService ms;
	
	// RESTful web service
	@RequestMapping(value="/result", method=RequestMethod.POST)	
	@ResponseBody
	public double calculateMonthlyPayment(@RequestBody Loan loan) {
		double interestRate = ms.getInterestRate(loan.getState(), loan.getLoanType());
		if (interestRate != -1) {
			return MortgageCalculator.calculateMonthlyPayment(
				loan.getPurchase(), loan.getTermInYears(), interestRate, loan.getDownPayment(), 0, 0);
		} else {
			return -1;  // error
		}
	}
}
