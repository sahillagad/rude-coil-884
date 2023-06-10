package com.masai.service;

import java.util.List;

import com.masai.exception.CustomerException;
import com.masai.exception.ProblemException;
import com.masai.model.Customer;
import com.masai.model.Problem;
import com.masai.model.ProblemStatus;

public interface CustomerService {

	
	public String createCustomer(Customer  customer) throws CustomerException;
	
	
    public Problem viewProblem(Integer problemId)throws ProblemException;
    
    public String reopenProblem(Integer problemId,ProblemStatus ProblemStatus) throws ProblemException;
    
    
    
    public String updateCustomer(Customer  customer)throws CustomerException;
    
	public List<Problem> viewAllProblem() throws ProblemException;
	
	public String changeCustomerPassword(String customerUserName,String oldPassword,String  newPassword)throws CustomerException;
	
	
	public String createProblem(Integer customerId,Problem problem)throws ProblemException ,CustomerException;
	
	public Problem updateProblem(Problem problem)throws ProblemException;
 
	

	
	
}
