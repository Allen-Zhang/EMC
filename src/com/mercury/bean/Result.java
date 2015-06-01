package com.mercury.bean;

/**
 * Mortgage calculation result 
 */
public class Result {
	private int month;
	private double monthlyPayment;
	private double extraPayment;
	private double interestRate;  // interest rate in year
	private double remainingPrincipal;
	
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public double getMonthlyPayment() {
		return monthlyPayment;
	}
	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}
	public double getExtraPayment() {
		return extraPayment;
	}
	public void setExtraPayment(double extraPayment) {
		this.extraPayment = extraPayment;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public double getRemainingPrincipal() {
		return remainingPrincipal;
	}
	public void setRemainingPrincipal(double remainingPrincipal) {
		this.remainingPrincipal = remainingPrincipal;
	}
	
	@Override
	public String toString() {
		return "month: " + month + ", monthlyPayment: " + monthlyPayment 
				+ ", extraPayment: " + extraPayment + ", interestRate: " 
				+ interestRate + ", remainingPrincipal: " + remainingPrincipal;
	}
}
