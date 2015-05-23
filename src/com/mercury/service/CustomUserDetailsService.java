package com.mercury.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.bean.UserRole;
import com.mercury.dao.UserDao;

@Service
@Transactional(readOnly=true)
public class CustomUserDetailsService implements UserDetailsService{
//	private PersonDao pd;
//		
//	public PersonDao getPd() {
//		return pd;
//	}
//	public void setPd(PersonDao pd) {
//		this.pd = pd;
//	}
//	
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		UserDetails user = null;  
//		try {
//			Person person = pd.findPersonByEmail(email);	
//			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//			for (String authority : person.getAuthorities()) {
//				authorities.add(new SimpleGrantedAuthority(authority));
//			}
//			user = new User(
//						person.getUsername(),
//						person.getPassword(),
//						true,
//						true,
//						true,
//						true,
//						authorities 
//					);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new UsernameNotFoundException("Error in retrieving user");
//		}
//		return user;
//	}
	
	private UserDao ud;

	public UserDao getUd() {
		return ud;
	}
	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.mercury.bean.User user = ud.findByUserName(username);
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (UserRole role : user.getUserRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		}
		UserDetails userDetails = new User(
				user.getUsername(),
				user.getPassword(),
				true,
				true,
				true,
				true,
				authorities 
		);
		return userDetails;
	}
	
}
