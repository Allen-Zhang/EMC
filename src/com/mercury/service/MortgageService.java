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

	public double getFixedRate(String state, int termInYears) {
		InterestRate rate = rd.findByState(state);
		if (rate != null) {
			switch (termInYears) {
			case 30:
				return rate.getFix_30();
			case 20:
				return rate.getFix_20();
			case 15:
				return rate.getFix_15();
			}
		}
		return -1;  // error;
	}
}
