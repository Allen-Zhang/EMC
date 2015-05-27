package com.mercury.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mercury.util.MortgageCalculator;

@Controller
@SessionAttributes
public class MortgageController {

//	@Autowired
//	@Qualifier("mortgageCalculator")
//	MortgageCalculator calculator;
//	
//	public MortgageCalculator getCalculator() {
//		return calculator;
//	}
//	public void setCalculator(MortgageCalculator calculator) {
//		this.calculator = calculator;
//	}

	@RequestMapping(value="/calculator")
	public String calculatorPage() {
		return "calculator";
	}
	
	@RequestMapping(value="/result")
	public ModelAndView calculateMonthlyPayment(HttpServletRequest request) {
		double purchase = Double.valueOf(request.getParameter("purchase")); 
		int termInYears = Integer.valueOf(request.getParameter("termInYears")); 
		double interestRate = Double.valueOf(request.getParameter("interestRate"));  
		double downPayment = Double.valueOf(request.getParameter("downPayment"));  
		double monthlyPayment = MortgageCalculator
				.calculateMonthlyPayment(purchase, termInYears, interestRate, downPayment);
		
//		double monthlyPayment = MortgageCalculator.calculateMonthlyPayment(300000, 30, 5, 100000); // for testing
		ModelAndView mav = new ModelAndView();
		mav.setViewName("result");
		mav.addObject("monthlyPayment", monthlyPayment);
		return mav;
	}
	
}
