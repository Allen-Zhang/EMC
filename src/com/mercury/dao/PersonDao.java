package com.mercury.dao;

import com.mercury.bean.Person;

public interface PersonDao {
	public Person findPersonByEmail(String email);
}
