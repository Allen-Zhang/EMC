package com.mercury.util;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mercury.bean.Result;

public class MortgageCalculator {

	public static double calculateTotalInterest(double purchase, int termInYears,
			double monthlyRate, double downPayment, int extraPayment, int extraMonth){
		double loanAmount = purchase * (1 - downPayment / 100);
		double monthlyPayment = calculateMonthlyPayment(purchase, termInYears, monthlyRate, 
				downPayment, extraPayment, extraMonth);
		double totalInterest = monthlyPayment * 12 * termInYears - loanAmount;
		return totalInterest;
	}
	
	public static double calculateMonthlyPayment(double purchase, int termInYears, 
			double monthlyRate, double downPayment, int extraPayment, int extraMonth) {
		monthlyRate /= 100.0;
		downPayment /= 100.0;
		int termInMonths = 12 * termInYears;
		double loanAmount = purchase * (1 - downPayment);
		
		double temp1 = Math.pow((1 + monthlyRate), termInMonths);
		double temp2 = Math.pow((1 + monthlyRate), (termInMonths - extraMonth));
		double monthlyPayment = loanAmount * monthlyRate * temp1 / (temp1 - 1) 
				- extraPayment * (temp1 - temp2) / (temp1 - 1);
		return monthlyPayment;
	}

//	public static void getResults(double purchase, int termInYears, double monthlyRate, 
//			double monthlyPayment, double downPayment, double extraPayment, double extraMonth) {
//		// Format the currency
//		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
//		monthlyRate /= 100.0;
//		int termInMonths = termInYears * 12;
//
//		// Loop through the term of the loan tracking the balance
//		double loanAmount = purchase * (1 - downPayment / 100);
//		double balance = loanAmount;
//		int countMonth = 0;
//		for (int i = 0; i < termInMonths; i++) {
//			countMonth++;
//			// Add interest to the balance
//			balance += (balance * monthlyRate);
//			// Subtract the monthly payment
//			balance -= monthlyPayment;
//			if (countMonth <= extraMonth) {
//				balance = balance - extraPayment;
//			}
//			// Display running balance
//			System.out.println("Balance after payment " + (i + 1) + ":" + currencyFormat.format(balance));
//		}
//	}
	
	public static List<Result> getResults(double purchase, int termInYears, double monthlyRate, 
			double monthlyPayment, double downPayment, double extraPayment, double extraMonth) {
		monthlyRate /= 100.0;
		int termInMonths = termInYears * 12;

		// Loop through the term of the loan tracking the balance
		double loanAmount = purchase * (1 - downPayment / 100);
		double balance = loanAmount;
		int countMonth = 0;
		
		// Add results into a list
		List<Result> resultList = new ArrayList<Result>();
		for (int i = 0; i < termInMonths; i++) {
			Result result = new Result();
			countMonth++;
			// Add interest to the balance
			balance += (balance * monthlyRate);
			// Subtract the monthly payment
			balance -= monthlyPayment;
			if (countMonth <= extraMonth) {
				balance = balance - extraPayment;
			}
			result.setMonth(i + 1);
			result.setExtraPayment(extraPayment);
			result.setInterestRate(monthlyRate * 12);
			result.setMonthlyPayment(monthlyPayment);
			result.setRemainingPrincipal(balance);
			resultList.add(result);
			System.out.println("Result --> " + result);
		}
		
		return resultList;
	}
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter purchase: ");
		double purchase = scanner.nextDouble();
		System.out.print("Please enter termInYears: ");
		int termInYears = scanner.nextInt();
		System.out.print("Please enter interest rate: ");
		double interestRate = scanner.nextDouble();
		System.out.print("Please enter downPayment: ");
		int downPayment = scanner.nextInt();
		System.out.print("Please enter extraPayment: ");
		int extraPayment = scanner.nextInt();
		System.out.print("Please enter extraMonth: ");
		int extraMonth = scanner.nextInt();

		double monthlyRate = interestRate / 12;
		
		double monthlyPayment = calculateMonthlyPayment(
	            purchase, termInYears, monthlyRate, downPayment,extraPayment, extraMonth);
		double totalInterest = calculateTotalInterest(purchase, termInYears, monthlyRate, downPayment, extraPayment, extraMonth);
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		double loanAmount = purchase*(1 - downPayment/100d);	
		System.out.println("Loan Amount: "+"$"+ loanAmount);
		System.out.println("interest Rate: " + interestRate);
		System.out.println("Total Interest: " +
		         currencyFormat.format(totalInterest));
		System.out.println("Monthly Payment: "+
		         currencyFormat.format(monthlyPayment));
		getResults(purchase, termInYears, monthlyRate, monthlyPayment, downPayment, extraPayment, extraMonth);
	} 
}
