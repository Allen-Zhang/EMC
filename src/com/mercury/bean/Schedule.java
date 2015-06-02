package com.mercury.bean;

import java.util.List;

public class Schedule {
	private List<Result> results;
	private double purchase;  
	private double downpayment;
	private int termInYears;
	private double interestRate;  // data in database
	private double savedInterest;
	
	public List<Result> getResults() {
		return results;
	}
	public void setResults(List<Result> results) {
		this.results = results;
	}
	public double getPurchase() {
		return purchase;
	}
	public void setPurchase(double purchase) {
		this.purchase = purchase;
	}
	public double getDownpayment() {
		return downpayment;
	}
	public void setDownpayment(double downpayment) {
		this.downpayment = downpayment;
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
	public double getSavedInterest() {
		return savedInterest;
	}
	public void setSavedInterest(double savedInterest) {
		this.savedInterest = savedInterest;
	}
	
}
