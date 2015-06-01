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

@Controller
@SessionAttributes
public class MortgageController {
	@Autowired
	@Qualifier("mortgageService")
	private MortgageService ms;
	
	// RESTful web service
	@RequestMapping(value="/result", method=RequestMethod.POST)	
	@ResponseBody
	public List<Result> getPaymentSchedule(@RequestBody Loan loan) {
		String loanType = loan.getLoanType();
		// Fixed rate
		if (loanType.indexOf("fix") >= 0) {
			return ms.getPaymentScheduleInFixedRate(loan);
		}
		// Adjustable rate
		else {
			String[] items = loanType.split("_");
			int years = Integer.valueOf(items[2]);
//			return ms.getPaymentScheduleInAdjustableRate(loan, years);
			return null;
		}
	}
}
