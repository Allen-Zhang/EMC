package com.mercury.service;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class EmailValidateService {
	public boolean validateEmail(String email){
		boolean isValid = false;
		try{
			//create InternetAddress object and validate the email address
			InternetAddress internetAddress = new InternetAddress(email);
			internetAddress.validate();
			isValid = true;
		} catch(AddressException e){
			e.printStackTrace();
		}
		return isValid;
	}
	public void printStatus(String email, boolean valid){
		System.out.println(email + " is " + (valid ? "a" : "not a")+
				" valid email address");
	}
	public static void main(String[] args){
		EmailValidateService example = new EmailValidateService();
		String email = "sijiyangyi24xxx@gmail.comssssss";
		boolean isValid = example.validateEmail(email);
		example.printStatus(email, isValid);
	}
}
