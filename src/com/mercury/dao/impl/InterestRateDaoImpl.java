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

	@SuppressWarnings("unchecked")
	@Override
	public List<InterestRate> queryAll() {
		String hql = "from InterestRate";
		return template.find(hql);
	}

}
