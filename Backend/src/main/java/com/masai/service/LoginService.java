package com.masai.service;

import javax.security.auth.login.LoginException;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.model.Login;
import com.masai.model.LoginResponse;
import com.masai.model.Operator;

public interface LoginService {

	
	public LoginResponse loginUser(Login credential) throws LoginException;
	
	public String logoutUser(String key) throws LoginException;
		
	
}
