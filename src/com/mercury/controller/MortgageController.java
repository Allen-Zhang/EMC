package com.mercury.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mercury.bean.Loan;
import com.mercury.bean.Result;
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
	public List<Result> calculateMonthlyPayment(@RequestBody Loan loan) {
		double monthlyRate = ms.getInterestRate(loan.getState(), loan.getLoanType()) / 12;
		if (monthlyRate != -1) {
			double monthlyPayment = 
					MortgageCalculator.calculateMonthlyPayment(loan.getPurchase(), 
							loan.getTermInYears(), monthlyRate, loan.getDownPayment(), 0, 0);
			List<Result> results = MortgageCalculator.getResults(loan.getPurchase(), 
					loan.getTermInYears(), monthlyRate, monthlyPayment, loan.getDownPayment(), 0, 0);
			return results;
		} else {
			return null;  // error
		}
	}
}
