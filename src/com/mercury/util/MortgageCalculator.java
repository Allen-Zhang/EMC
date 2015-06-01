package com.mercury.util;

import java.util.ArrayList;
import java.util.List;

import com.mercury.bean.Result;

public class MortgageCalculator {
	
	public static double calculateMonthlyPayment(double purchase, int termInYears, 
			double interestRate, double downPayment, double extraPayment, int extraMonth) {
		int termInMonths = 12 * termInYears;
		double monthlyRate = interestRate / 12 / 100;
		double loanAmount = purchase * (1 - downPayment / 100);
		double temp1 = Math.pow((1 + monthlyRate), termInMonths);
		double temp2 = Math.pow((1 + monthlyRate), (termInMonths - extraMonth));
		double monthlyPayment = loanAmount * monthlyRate * temp1 / (temp1 - 1) 
				- extraPayment * (temp1 - temp2) / (temp1 - 1);
		return monthlyPayment;
	}

	public static double calculateTotalInterest(double purchase, int termInYears, 
			double interestRate, double downPayment, int extraPayment, int extraMonth) {
		double loanAmount = purchase * (1 - downPayment / 100);
		double monthlyPayment = calculateMonthlyPayment(purchase, termInYears,
				interestRate, downPayment, extraPayment, extraMonth);
		double totalInterest = monthlyPayment * 12 * termInYears - loanAmount;
		return totalInterest;
	}
	
	public static List<Result> getScheduleInFixedRate(double purchase, int termInYears, 
			double interestRate, double downPayment, double extraPayment, int extraMonth) {
		List<Result> resultList = new ArrayList<Result>();
		double loanAmount = purchase * (1 - downPayment / 100);
		double balance = loanAmount;
		int countMonth = 0;

		double monthlyPayment = calculateMonthlyPayment(purchase, termInYears, 
				interestRate, downPayment, extraPayment, extraMonth);
		double monthlyRate = interestRate / 12 / 100;
		int termInMonths = termInYears * 12;

		// Loop through the term of the loan tracking the balance
		for (int i = 0; i < termInMonths; i++) {
			Result result = new Result();
			countMonth++;
			// Add interest to the balance
			balance += (balance * monthlyRate);
			// Subtract the monthly payment
			balance -= monthlyPayment;
			if (countMonth <= extraMonth) {
				balance -= extraPayment;
				result.setExtraPayment(extraPayment);  // set extraPayment
			}
			result.setMonth(i + 1);  // set month
//			result.setInterestRate(monthlyRate * 12);  // set interest rate
			result.setInterestRate(interestRate); 
			result.setMonthlyPayment(monthlyPayment);  // set monthly payment
			result.setRemainingPrincipal(Math.round(balance * 100.0) / 100.0);  // set remaining principal, round up to 2 decimal places
			resultList.add(result);
		}
		return resultList;
	}

//	public static List<Result> getScheduleInAdjustableRate(double purchase, int totalTermInYears, 
//			double fixedRate, int fixedTermInYears, double downPayment, double extraPayment, 
//			int extraMonth) {
//		List<Result> resultList = new ArrayList<Result>();
//		double loanAmount = purchase * (1 - downPayment / 100);
//		double balance = loanAmount;
//		int countMonth = 0;
//		
//		/* ---------- For fixed rate part ---------- */
//		double monthlyPaymentInFixedRate = calculateMonthlyPayment(purchase, fixedTermInYears, 
//				fixedRate, downPayment, extraPayment, extraMonth);
//		double fixedMonthlyRate = fixedRate / 12 / 100;
//
//		// Loop through the term in months of the loan tracking the balance
//		for (int i = 0; i < fixedTermInYears * 12; i++) {
//			Result result = new Result();
//			countMonth++;
//			// Add interest to the balance
//			balance += (balance * fixedMonthlyRate);
//			// Subtract the monthly payment
//			balance -= monthlyPaymentInFixedRate;
//			if (countMonth <= extraMonth) {
//				balance -= extraPayment;
//				result.setExtraPayment(extraPayment);  // set extraPayment
//			}
//			result.setMonth(i + 1);  // set month
//			result.setInterestRate(fixedRate);  // set interest rate
//			result.setMonthlyPayment(monthlyPaymentInFixedRate);  // set monthly payment
//			result.setRemainingPrincipal(Math.round(balance * 100.0) / 100.0);  // set remaining principal, round up to 2 decimal places
//			resultList.add(result);
//		}
//		
//		/* ---------- For adjustable rate part ---------- */
//		
//		System.out.println("fixed rate: " + fixedMonthlyRate);
//		// Loop through the term in months of the loan tracking the balance
//		for (int i = fixedTermInYears * 12; i < totalTermInYears * 12; i++) {
//			double adjMonthlyRate = getAdjustableRate(fixedMonthlyRate);
//			System.out.println("adj rate: " + adjMonthlyRate);
//			double monthlyPaymentInAdjRate = 0;
//			// 1
////			if (countMonth <= extraMonth) {
////				/** May be an error here! */
////				monthlyPaymentInAdjRate = calculateMonthlyPayment(purchase, 1 / 12, 
////						fixedRate, downPayment, extraPayment, 1);
////			} else {
////				monthlyPaymentInAdjRate = calculateMonthlyPayment(purchase, 1 / 12, 
////						fixedRate, downPayment, 0, 0);
////			}
//			// 2
//			int adjTermInYears = totalTermInYears - fixedTermInYears;
//			if (countMonth <= extraMonth) {
//				/** May be an error here! */
//				monthlyPaymentInAdjRate = calculateMonthlyPayment(purchase, adjTermInYears, 
//						adjMonthlyRate, downPayment, extraPayment, extraMonth);
//			} else {
//				monthlyPaymentInAdjRate = calculateMonthlyPayment(purchase, adjTermInYears, 
//						adjMonthlyRate, downPayment, 0, 0);
//			}
//			Result result = new Result();
//			countMonth++;
//			// Add interest to the balance
//			balance += (balance * adjMonthlyRate);
//			// Subtract the monthly payment
//			balance -= monthlyPaymentInAdjRate;
//			if (countMonth <= extraMonth) {
//				balance -= extraPayment;
//				result.setExtraPayment(extraPayment);  // set extraPayment
//			}
//			result.setMonth(i + 1);  // set month
//			result.setInterestRate(adjMonthlyRate);  // set interest rate
//			result.setMonthlyPayment(monthlyPaymentInAdjRate);  // set monthly payment
//			result.setRemainingPrincipal(Math.round(balance * 100.0) / 100.0);  // set remaining principal, round up to 2 decimal places
//			resultList.add(result);
//		}
//		return resultList;
//	}
	
	/*
	 * Floats between 0% and 3% of the fixed rate
	 */
	private static double getAdjustableRate(double fixedMonthlyRate) {
		return  (Math.random() * 3 / 100) * fixedMonthlyRate + fixedMonthlyRate;
	}
	
}
