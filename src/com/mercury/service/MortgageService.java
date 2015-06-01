package com.mercury.service;

import java.util.ArrayList;
import java.util.List;

import com.mercury.bean.InterestRate;
import com.mercury.bean.Loan;
import com.mercury.bean.Result;
import com.mercury.dao.InterestRateDao;
import com.mercury.util.MortgageCalculator;

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
	
	/*
	 * Mortgage calculation for fixed rate
	 */
	public List<Result> getPaymentScheduleInFixedRate(Loan loan) {
		double interestRate = getInterestRate(loan.getState(), loan.getLoanType());
		if (interestRate != -1) {
			List<Result> results = MortgageCalculator.getScheduleInFixedRate(
					loan.getPurchase(), loan.getTermInYears(), interestRate, 
					loan.getDownPayment(), loan.getExtraPayment(), loan.getExtraMonth()
			);
			return results;
		} else {
			return null;  // error
		}
	}
	
	/*
	 * Mortgage calculation for adjustable rate
	 */
//	public List<Result> getPaymentScheduleInAdjustableRate(Loan loan, int years) {
//		double fixedRate = getInterestRate(loan.getState(), loan.getLoanType());
//		
//		System.out.println("Service - total term: " + loan.getTermInYears());
//		System.out.println("Service - years: " + years);
//		System.out.println("Service - fixed rate: " + fixedRate);
//		
//		if (fixedRate != -1) {
//			List<Result> results = MortgageCalculator.getScheduleInAdjustableRate(
//					loan.getPurchase(), loan.getTermInYears(), fixedRate, years,
//					loan.getDownPayment(), loan.getExtraPayment(), loan.getExtraMonth()
//			);
//			return results;
//		} else {
//			return null;  // error
//		}
//	}
	
}
