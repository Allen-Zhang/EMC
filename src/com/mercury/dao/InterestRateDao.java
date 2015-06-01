package com.mercury.dao;

import com.mercury.bean.InterestRate;

public interface InterestRateDao {
	public InterestRate findByState(String state);
	public void updateInterestRate(String state, String loanType, double newInterestRate);
}
