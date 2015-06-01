package com.mercury.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mercury.bean.InterestRate;
import com.mercury.dao.InterestRateDao;

public class InterestRateDaoImpl implements InterestRateDao {
	private HibernateTemplate template;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		template = new HibernateTemplate(sessionFactory);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public InterestRate findByState(String state) {
		String hql = "from InterestRate where state = ?";
		List<InterestRate> rates = template.find(hql, state);
		if (rates.size() > 0) {
			return rates.get(0);
		} else {
			return null;
		}
	}
	
	public void updateInterestRate(String state, String loanType, double newInterestRate) {
		InterestRate row = findByState(state);
		// Using if else since switch not support String type in Java 6
		if (loanType.equals("15_fix"))
			row.setFix_15(newInterestRate);
		else if (loanType.equals("20_fix"))
			row.setFix_20(newInterestRate);
		else if (loanType.equals("30_fix"))
			row.setFix_30(newInterestRate);
		else if (loanType.equals("30_arm_5"))
			row.setArm_5(newInterestRate);
		else if (loanType.equals("30_arm_7"))
			row.setArm_7(newInterestRate);
		else if (loanType.equals("30_arm_10"))
			row.setArm_10(newInterestRate);
		template.update(row);
	}

}
