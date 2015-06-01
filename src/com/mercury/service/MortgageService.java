package com.mercury.service;

import com.mercury.bean.InterestRate;
import com.mercury.dao.InterestRateDao;

public class MortgageService {
	private InterestRateDao rd;

	public InterestRateDao getRd() {
		return rd;
	}
	public void setRd(InterestRateDao rd) {
		this.rd = rd;
	}

	/*
	 * loanType: 15_fix, 20_fix, 30_fix, 30_arm_5, 30_arm_7, 30_arm_10
	 */
	public double getInterestRate(String state, String loanType) {
		InterestRate rate = rd.findByState(state);
		if (rate != null) {
			// Using if else since switch not support String type in Java 6
			if (loanType.equals("15_fix"))
				return rate.getFix_15();
			else if (loanType.equals("20_fix"))
				return rate.getFix_20();
			else if (loanType.equals("30_fix"))
				return rate.getFix_30();
			else if (loanType.equals("30_arm_5"))
				return rate.getArm_5();
			else if (loanType.equals("30_arm_7"))
				return rate.getArm_7();
			else if (loanType.equals("30_arm_10"))
				return rate.getArm_10();
		}
		return -1;  // error;
	}
	
	public void updateInterestRate(String state, String loanType, double newInterestRate) {
		rd.updateInterestRate(state, loanType, newInterestRate);
	}
}
