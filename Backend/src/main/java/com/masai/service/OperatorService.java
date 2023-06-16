package com.masai.service;

import com.masai.exception.CustomerException;
import com.masai.exception.ProblemException;
import com.masai.model.Customer;
import com.masai.model.CustomerStatus;
import com.masai.model.Problem;
import com.masai.model.ProblemStatus;

public interface OperatorService {

	public String createProblem(Integer customerId, Problem problem) throws ProblemException, CustomerException;

	public String UpdateCustomerProblem(Problem problem) throws ProblemException;

	public String closeCustomerProblem(Integer problemId, ProblemStatus problemStatus) throws ProblemException;

	public Customer findCustomerById(Integer customerId) throws CustomerException;

	public String customerLock(Integer customerId, CustomerStatus customerStatus) throws CustomerException;

}
