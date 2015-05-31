package com.mercury.service;

import com.mercury.bean.InterestRate;
import com.mercury.dao.InterestRateDao;

public class AdminService {

	private InterestRateDao rd;

	public InterestRateDao getRd() {
		return rd;
	}
	public void setRd(InterestRateDao rd) {
		this.rd = rd;
	}

	public double getFixedRate(String state, int interestType) {
		InterestRate rate = rd.findByState(state);
		if (rate != null) {
			switch (interestType) {
			case 30:
				return rate.getFix_30();
			case 20:
				return rate.getFix_20();
			case 15:
				return rate.getFix_15();
			case 5:
				return rate.getArm_5();
			case 7:
				return rate.getArm_7();
			case 10:
				return rate.getArm_10();
			}	
		}
		return -1;  // error;
	}

}