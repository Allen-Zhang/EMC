package com.mercury.util;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
	/**
	    * Calculates the monthly payment for a specified loan
	    * 
	    * @param purchase total amount of loan
	    * @param termInYears term of loan in years
	    * @param interestRate loan interest rate, 5.6% = 5.6
	    * @return monthly payment
	    */
	public static double calculateMonthlyPayment(double purchase, int termInYears,
			double interestRate, double downPayment){
		// Convert interest rate to decimal
		// eg. 6.5%=0.065
		interestRate /= 100.0;
		downPayment /= 100;
		//purchase minus downPayment amount
		double loanAmount =(1 - downPayment)*purchase;
		// Monthly interest rate 
        // is the yearly rate divided by 12
		double monthlyRate = interestRate /12.0;
		// The length of the term in months 
        // is the number of years times 12
		int termInMonths = termInYears * 12;
		// Calculate the monthly payment
        // Typically this formula is provided so 
        // we won't go into the details
         
        // The Math.pow() method is used 
        // to calculate values raised to a power
		double monthlyPayment = (loanAmount * monthlyRate) / 
				(1 - Math.pow(1 + monthlyRate, -termInMonths));
		return monthlyPayment;
	}
	/*public static double calculateFloatMonthlyPayment(double purchase, int termInYears, 
			double insterestRate, double downPayment){

		return monthlyPayment;
	}*/
	/**
	    * Calculates the total interest for a specified loan
	    * 
	    * @param purchase total amount of loan
	    * @param termInYears term of loan in years
	    * @param interestRate loan interest rate, 5.6% = 5.6
	    * @return totalInterest
	    */
	public static double calculateTotalInterest(double purchase, int termInYears,
			double interestRate, double downPayment){
		double loanAmount = purchase*(1 - downPayment/100);
		double monthlyPayment =calculateMonthlyPayment(purchase, termInYears,
				interestRate, downPayment);
		double totalInterest = monthlyPayment * 12 * termInYears - loanAmount;
		return totalInterest;
	}
	  /**
	    * Display monthly balance for the term of a loan
	    * 
	    * @param purchase total amount of loan
	    * @param termInYears term of loan in years
	    * @param interestRate loan interest rate, 5.6% = 5.6
	    * @param monthlyPayment monthly payment
	    */
	public static void displayMonthlyBalance(double purchase, int termInYears,
			double interestRate, double monthlyPayment, double downPayment){
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		interestRate /= 100.0;
		double monthlyRate = interestRate / 12.0;
		int termInMonths = termInYears * 12;
		// Loop through the term of the loan tracking the balance
		double loanAmount = purchase*(1 - downPayment/100);
		double balance = loanAmount;
		for(int i = 0; i <termInMonths; i++){
			//Add interest to the balance
			balance += (balance * monthlyRate);
			// Subtract the monthly payment
			balance -= monthlyPayment;
			//Display running balance
			System.out.println("Balance after payment " + (i + 1) + ":" +
			currencyFormat.format(balance));
		}
	}
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		// Prompt user for details of loan
		System.out.print("Please enter purchase: ");
		double purchase = scanner.nextDouble();
		System.out.print("Please enter loan term(in years): ");
		int termInYears = scanner.nextInt();
		System.out.print("Please enter interest rate: ");
		double interestRate = scanner.nextDouble();
		System.out.print("Please enter downPayment: ");
		int downPayment = scanner.nextInt();
		// Calculate the monthly payment
		double monthlyPayment = calculateMonthlyPayment(
	            purchase, termInYears, interestRate, downPayment);
		// Calculate total interest
		double totalInterest = calculateTotalInterest(purchase, termInYears, interestRate, downPayment);
		 // NumberFormat is useful for formatting numbers
	      // In our case we'll use it for 
	      // formatting currency and percentage values
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
/*		      NumberFormat interestFormat = 
		         NumberFormat.getPercentInstance();*/
		 
		      // Display details of the loan
		double loanAmount = purchase*(1 - downPayment/100d);	
		System.out.println("Loan Amount: "+"$"+ loanAmount);
		System.out.println("Loan Term: "+  termInYears+" years");
		      /*System.out.println("Interest Rate: "+
		         interestFormat.format(interestRate));*/
		System.out.println("interest Rate: " + interestRate);
		System.out.println("Total Interest: " +
		         currencyFormat.format(totalInterest));
		System.out.println("Monthly Payment: "+
		         currencyFormat.format(monthlyPayment));
		 
		      // Now display the monthly balance for
		      // the term of the loan
		       
		displayMonthlyBalance(purchase, termInYears, interestRate, monthlyPayment, downPayment);
	} 
}
