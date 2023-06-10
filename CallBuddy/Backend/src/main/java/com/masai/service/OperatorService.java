package com.masai.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.masai.exception.CustomerException;
import com.masai.exception.ProblemException;
import com.masai.model.Customer;
import com.masai.model.CustomerStatus;
import com.masai.model.Problem;
import com.masai.model.ProblemStatus;

public interface OperatorService {

	public String CraeteCustomer(Customer customer) throws CustomerException ;
	
	public String createProblem(Integer customerId, Problem problem) throws ProblemException ,CustomerException;	
	
	public String UpdateCustomerProblem(Problem problem)throws ProblemException;
	
	public String closeCustomerProblem(Integer problemId,ProblemStatus problemStatus)throws ProblemException;

	public Customer findCustomerById(Integer customerId) throws CustomerException;
	
	public List<Customer> findCustomerByName(String name)throws CustomerException;
	
	public Customer findCustomerByEmail(String email)throws CustomerException ;
	
	public String customerLock(Integer customerId,CustomerStatus customerStatus)throws CustomerException;
	
	
	
}
