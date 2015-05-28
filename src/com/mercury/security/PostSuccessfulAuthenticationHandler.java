package com.mercury.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.mercury.service.JavaMailService;

public class PostSuccessfulAuthenticationHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	
	@Autowired
	@Qualifier("javaMailService")
	private JavaMailService javaMailService;
	
    public JavaMailService getMailApp() {
		return javaMailService;
	}
	public void setMailApp(JavaMailService mailApp) {
		this.javaMailService = mailApp;
	}

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {
		System.out.println("Execute PostSuccessfulAuthenticationHandler");
//        mailApp.sendMail("Peter", "This is a welcome email");  // send an email after success login
//		this.setDefaultTargetUrl(defaultTargetUrl);  // redirect url base on authority after success login
		super.onAuthenticationSuccess(request, response, authentication);
   }

}