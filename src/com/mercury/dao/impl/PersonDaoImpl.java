package com.mercury.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mercury.bean.Person;
import com.mercury.bean.User;
import com.mercury.bean.UserRole;
import com.mercury.dao.PersonDao;

public class PersonDaoImpl implements PersonDao {
	private HibernateTemplate template;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		template = new HibernateTemplate(sessionFactory);
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public Person findPersonByEmail(String email) {
//		String hql = "from User where username = ?";
//		List<User> users = template.find(hql, email);
//		if (users.size() > 0) {
//			User user = users.get(0);
//			Iterator<UserRole> it = user.getUserRoles().iterator();
//			return new Person(user.getUsername(), user.getPassword(), it.next().getAuthority());
//		} else {
//			return null;
//		}
//	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Person findPersonByEmail(String email) {
		String hql = "from User where username = ?";
		List<User> users = template.find(hql, email);
		if (users.size() > 0) {
			User user = users.get(0);
			Set<String> set = new HashSet<String>();
			for (UserRole role : user.getUserRoles()) {
				set.add(role.getAuthority());
			}
			return new Person(user.getUsername(), user.getPassword(), set);
		} else {
			return null;
		}
	}
}
