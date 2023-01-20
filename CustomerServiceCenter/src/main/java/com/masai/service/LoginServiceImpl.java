package com.masai.service;

import java.time.LocalDateTime;

import javax.security.auth.login.LoginException;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.model.Admin;
import com.masai.model.CurrentSession;
import com.masai.model.Customer;
import com.masai.model.Login;
import com.masai.model.Operator;
import com.masai.repository.AdminDao;
import com.masai.repository.CustomerDao;
import com.masai.repository.OperatorDao;
import com.masai.repository.SessionDao;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	CustomerDao customerRepo;

	@Autowired
	OperatorDao operatorRepo;
	
	@Autowired
	AdminDao adminRepo;
	
	@Autowired
	SessionDao sessionRepo;
	
	@Override
	public String loginUser(Login credential) throws LoginException {
		// TODO Auto-generated method stub
		
		CurrentSession currentUserSession;
		if(credential.getUser_Type().equals("CUSTOMER")){
			
			
			
			Customer existingCustomer= customerRepo.findByUserName(credential.getUserName());
			if(existingCustomer==null)
				throw new LoginException("Please Enter a valid CREDENTIALS");
			
		java.util.Optional<CurrentSession>	validCustomerSessionOpt =  sessionRepo.findById(existingCustomer.getCustomerId());
		
			if(validCustomerSessionOpt.isPresent()) {
			
			throw new LoginException("User already Logged In with this Email");
			
		}
	
		if(existingCustomer.getPassword().equals(credential.getPassword())) {;
			
		String key= RandomString.make(6);
			
			
			
			 currentUserSession = new CurrentSession(existingCustomer.getCustomerId(),key,LocalDateTime.now(),credential.getUser_Type());
			
			sessionRepo.save(currentUserSession);
		

			return key;
		}else
			throw new LoginException("Passowrd incorrect");
		}
		
		if(credential.getUser_Type().equals("ADMIN")){
			
			
			
			Admin existingAdmin= adminRepo.findByUserName(credential.getUserName());
			if(existingAdmin==null)
				throw new LoginException("Please Enter a valid CREDENTIALS");
			
		java.util.Optional<CurrentSession>	validAdminSessionOpt =  sessionRepo.findById(existingAdmin.getAdminId());
		
			if(validAdminSessionOpt.isPresent()) {
			
			throw new LoginException("User already Logged In with this Email");
			
		}
	
		if(existingAdmin.getPassword().equals(credential.getPassword())) {;
			
		String key= RandomString.make(6);
			
			
			
			 currentUserSession = new CurrentSession(existingAdmin.getAdminId(),key,LocalDateTime.now(),credential.getUser_Type());
			
			sessionRepo.save(currentUserSession);
		

			return key;
		}else
			throw new LoginException("Passowrd incorrect");
		}
		
		if(credential.getUser_Type().equals("OPERATOR")){
			
			
			
			Operator existingOperator= operatorRepo.findByUserName(credential.getUserName());
			if(existingOperator==null)
				throw new LoginException("Please Enter a valid CREDENTIALS");
			
		java.util.Optional<CurrentSession>	validOperatorSessionOpt =  sessionRepo.findById(existingOperator.getOperatorId());
		
			if(validOperatorSessionOpt.isPresent()) {
			
			throw new LoginException("User already Logged In with this Email");
			
		}
	
		if(existingOperator.getPassword().equals(credential.getPassword())) {;
			
		String key= RandomString.make(6);
			
			
			
			 currentUserSession = new CurrentSession(existingOperator.getOperatorId(),key,LocalDateTime.now(),credential.getUser_Type());
			
			sessionRepo.save(currentUserSession);
		

			return key;
		}else
			throw new LoginException("Passowrd incorrect");
		}

		
		else
			throw new LoginException("Please Enter a valid User Type ADMIN/CUSTOMER/OPERATOR");
	}

	@Override
	public String logoutUser(String key) throws  LoginException {
		CurrentSession validUserSession = sessionRepo.findByUuid(key);
		
		if(validUserSession == null) {
			throw new LoginException("NOT A VALID KEY");
			
		}
		
		sessionRepo.delete(validUserSession);
		return "User Loged Out SusessFully";
	}







}
