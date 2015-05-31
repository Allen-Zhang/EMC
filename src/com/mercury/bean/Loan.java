package com.mercury.bean;

/**
 * @param purchase total amount of loan
 * @param termInYears term of loan in years
 * @param state state of loan
 * @param downPayment down payment of loan, 5.6% = 5.6
 * @param loanType type of loan (15_fix, 20_fix, 30_fix, 30_arm_5, 30_arm_7, 30_arm_10)
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Loan {
	private double purchase; 
	private int termInYears;
	private String state;
	private double downPayment;
	private String loanType;
	
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public double getDownPayment() {
		return downPayment;
	}
	public void setDownPayment(double downPayment) {
		this.downPayment = downPayment;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
}
