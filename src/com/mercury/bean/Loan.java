package com.mercury.bean;

/**
 * @param purchase total amount of loan
 * @param termInYears term of loan in years
 * @param interestRate loan interest rate, 5.6% = 5.6
 * @param downPayment down payment of loan, 5.6% = 5.6
 * @param monthlyPayment monthly payment of loan
 */
public class Loan {
	private double purchase; 
	private int termInYears;
	private double interestRate; 
	private double downPayment;
//	private double monthlyPayment;
	
	public double getPurchase() {
		return purchase;
	}
	public void setPurchase(double purchase) {
		this.purchase = purchase;
	}
	public int getTermInYears() {
		return termInYears;
	}
	public void setTermInYears(int termInYears) {
		this.termInYears = termInYears;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public double getDownPayment() {
		return downPayment;
	}
	public void setDownPayment(double downPayment) {
		this.downPayment = downPayment;
	}
//	public double getMonthlyPayment() {
//		return monthlyPayment;
//	}
//	public void setMonthlyPayment(double monthlyPayment) {
//		this.monthlyPayment = monthlyPayment;
//	}
}
