package com.mercury.bean;

public class InterestRate {
	private int state_id;
	private String state;
	private double fix_30;
	private double fix_20;
	private double fix_15;
	
	public int getState_id() {
		return state_id;
	}
	public void setState_id(int state_id) {
		this.state_id = state_id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public double getFix_30() {
		return fix_30;
	}
	public void setFix_30(double fix_30) {
		this.fix_30 = fix_30;
	}
	public double getFix_20() {
		return fix_20;
	}
	public void setFix_20(double fix_20) {
		this.fix_20 = fix_20;
	}
	public double getFix_15() {
		return fix_15;
	}
	public void setFix_15(double fix_15) {
		this.fix_15 = fix_15;
	}
}
