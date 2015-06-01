package com.mercury.service;

import com.mercury.bean.User;
import com.mercury.dao.UserDao;
import org.apache.commons.codec.digest.DigestUtils;

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
	public void updatePassword(String username, String newPwd) {
		User user = ud.findByUserName(username);
		user.setPassword(newPwd);
		ud.update(user);
	}
	public void updateEmail(String username, String email) {
		User user = ud.findByUserName(username);
		user.setEmail(email);
		ud.update(user);
	}
	public void activateUser(String username){
		User user = ud.findByUserName(username);
		user.setEnabled(true);
		ud.update(user);
	}
	public String getShaPassword(String password){
		return DigestUtils.shaHex(password);
	}
}
