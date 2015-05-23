package com.mercury.bean;

import java.util.HashSet;
import java.util.Set;

public class Person {
	private String username;
	private String password;
	
	private Set<String> authorities;
	public Person() {
		authorities = new HashSet<String>();
	}
	public Person(String username, String password, Set<String> authorities) {
		this();
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}
	public Set<String> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Set<String> authorities) {
		this.authorities = authorities;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
//	private String authority;
//	public Person() {}
//	public Person(String username, String password, String authority) {
//		this.username = username;
//		this.password = password;
//		this.authority = authority;
//	}
//	public String getAuthority() {
//		return authority;
//	}
//	public void setAuthority(String authority) {
//		this.authority = authority;
//	}
	
}
