package com.mercury.dao;

import java.util.List;

import com.mercury.bean.InterestRate;

public interface InterestRateDao {
	public InterestRate findByState(String state);
	public void updateInterestRate(String state, String loanType, double newInterestRate);
	public List<InterestRate> queryAll();
}
