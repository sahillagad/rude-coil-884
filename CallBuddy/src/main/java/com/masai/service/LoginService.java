package com.masai.service;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.model.Login;
import com.masai.model.Operator;

public interface LoginService {

	
	public String loginUser(Login credential) throws CustomerException;
	
	public String logoutUser(String key) throws CustomerException;
	
	
	public Operator loginAdmin(Login credential) throws CustomerException;
	
	public String logoutAdmin(String key) throws CustomerException;
	
	
}
