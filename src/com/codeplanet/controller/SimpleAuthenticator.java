package com.codeplanet.controller;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SimpleAuthenticator extends Authenticator {
		String username=null;
		String password=null;
			
	public SimpleAuthenticator(String username, String password) {
		this.username=username;
		this.password=password;
	}
	
	public PasswordAuthentication getPasswordAuthentication() {
	return new PasswordAuthentication(username,password);
	}
}
