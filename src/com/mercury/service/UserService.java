package com.mercury.service;

import com.mercury.bean.User;
import com.mercury.dao.UserDao;

public class UserService {
	private UserDao ud;

	

	public UserDao getUd() {
		return ud;
	}
	public void setUd(UserDao ud) {
		this.ud = ud;
	}
	public User checkUser(String username){
		User user = ud.findByUserName(username);
		return user;
	}
	public void saveUser(User user){
		ud.save(user);
	}
	
}
