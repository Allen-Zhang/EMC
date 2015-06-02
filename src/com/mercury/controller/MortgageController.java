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
import com.mercury.bean.Schedule;
import com.mercury.service.EnhancedMortgageCalculator;

@Controller
@SessionAttributes
public class MortgageController {
	@Autowired
	@Qualifier("enhancedMortgageCalculator")
	private EnhancedMortgageCalculator mc;
	
	// RESTful web service
	@RequestMapping(value="/result", method=RequestMethod.POST)	
	@ResponseBody
	public Schedule getPaymentSchedule(@RequestBody Loan loan) {
		// For cacheable testing
		System.out.println("Start calculating...");  
		
		double purchase = loan.getPurchase();
		double downPayment = loan.getDownPayment();  // 6.6%
		double principal = purchase * (1 - downPayment / 100);
		String state = loan.getState();
		String loanType = loan.getLoanType();
		double extraPayment = loan.getExtraPayment();
		int extraMonth = loan.getExtraMonth();
		
		double[] monthlyRates = mc.getMonthlyRates(state, loanType);
		List<Result> results = mc.enhancedMortgageCalculate(principal, loanType, monthlyRates, extraPayment, extraMonth);
		double savedInterest = 0.0;
		if (extraPayment != 0 && extraMonth != 0) {
			savedInterest = mc.getOriginalTotalPayment(principal, loanType, monthlyRates) - mc.getCurrentTotalPayment(results);
			savedInterest = mc.truncate(savedInterest);
		}
		// For cacheable testing
		System.out.println("Finish calculating.");  
		
		return new Schedule(results, purchase, downPayment, results.size() / 12, monthlyRates, savedInterest);
	}
}
