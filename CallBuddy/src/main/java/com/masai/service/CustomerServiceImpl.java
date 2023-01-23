package com.masai.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.exception.ProblemException;
import com.masai.model.Calling;
import com.masai.model.Customer;
import com.masai.model.Problem;
import com.masai.model.ProblemStatus;
import com.masai.repository.AdminDao;
import com.masai.repository.CallDao;
import com.masai.repository.CustomerDao;
import com.masai.repository.DepartmentDao;
import com.masai.repository.OperatorDao;
import com.masai.repository.ProblemDao;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private DepartmentDao departmentDao;
	
	@Autowired
	private OperatorDao operatorDao;
	
	@Autowired
	private ProblemDao problemDao;
	
	@Autowired
	private CallDao callDao;
	
	@Autowired
	private AdminDao adminDao;
	
	
	@Autowired
	private CustomerDao customerDao;
	
	
	
	@Override
	public String createCustomer(Customer customer) throws CustomerException {

		String result="Customer Is Not Created..";
		
		 Customer customer2=customerDao.save(customer);
	       
		 if(customer2!=null) {

			 result="Customer Is Crated Successfully";
		 }
		
		 else {
				CustomerException customerException=new CustomerException("Customer Is Not Craeted");
				throw customerException;
		 
		 }
		 
		return result;
		
	}

	@Override
	public Problem viewProblem(Integer problemId) throws ProblemException {
		Problem problem=null;
		
		Optional<Problem> opt=problemDao.findById(problemId);
		
		if(opt.isPresent()) {
			problem=opt.get();		  
		}
		else {
			ProblemException exception=new ProblemException("Problem Is Not Present By Given Id");
			throw exception;
		}
		 
	return problem;
	}

	@Override
	public String reopenProblem(Integer problemId, ProblemStatus ProblemStatus) throws ProblemException {
	 String result="Problem / Issue Is Not  ReOpen";
	 
	   Optional<Problem> Opt= problemDao.findById(problemId);
		
	   if(Opt.isPresent()) {
		   
		   Problem problem2=Opt.get();
		   
		  if(problem2.getProblemStatus()==ProblemStatus.UNSOLVED) {
			 
			  result="Your Problem/Issue Is UnSolved It Is Open For Solved";
			   
		   }
		  else {
			
			  problem2.setProblemStatus(ProblemStatus);
			  result="Problem Is Successfully Re-Open";	  
			  
		  }
		  
		
		   problemDao.save(problem2); 
		
		 
	   }
	   else {
		   
		   ProblemException exception=new ProblemException("Problem Is Not Found By Given id");
		   throw exception;   
	   }
	   
	    return result;
	}

	@Override
	public String updateCustomer(Customer customer) throws CustomerException {
		 String result="Customer Is Not Update";
		
		 Optional<Customer> opt=customerDao.findById(customer.getCustomerId());
		  
		 if(opt.isPresent()) {
			 
			 Customer customer2=opt.get();
		     customer2.setName(customer.getName());
		     customer2.setUserName(customer.getUserName());
		     customer2.setEmail(customer.getEmail());
		     customer2.setPassword(customer.getPassword());
		     customer2.setMobile(customer.getMobile());
			 
		     
		     customerDao.save(customer2);
		      
			 result="Customer Is Update Successfully...";	 
			 
	
		 }
		 else {
			 
			 CustomerException customerException=new CustomerException("Customer Is Not Found By Given Id");
			 throw customerException;
			 
		 }
		
		return result;
	}

	@Override
	public List<Problem> viewAllProblem() throws ProblemException {
		
		List<Problem> problems=problemDao.findAll();
		
		if(problems==null) {
			
 			ProblemException exception=new ProblemException("Problem Database Is Empty");
            throw exception;			
			
		}
		
		
		
		return problems;
	}

	@Override
	public String changeCustomerPassword(String customerUserName, String oldPassword, String newPassword) throws CustomerException {
		
		String result="Customer Password Change Process Failed....";
		Customer customer=customerDao.findByUserNameAndPassword(customerUserName, newPassword);

		if(customer!=null) {
			customer.setPassword(newPassword);
			customerDao.save(customer);
		    result="Customer Password Is Update Successfully..";	
		}
		else {
			CustomerException customerException=new CustomerException("Customer Is Not Found By Given Id");
			throw customerException;
		}
		return result;
	}

	
	
	@Override
	public String createProblem(Integer customerId, Problem problem) throws ProblemException ,CustomerException {
	String result="Problem Is Not Created Due TO Some Error";
	
	Optional<Customer> opt=customerDao.findById(customerId);
	if(opt.isPresent()) {
		
		
		Customer exitingcustomer=opt.get();
		Calling calling=new Calling();
		calling.setCustomer(exitingcustomer);
		calling.setDate(LocalDate.now());
		calling.setProblem(problem);
		calling.setStartTime(LocalTime.now());
	   
	    exitingcustomer.getCalls().add(calling);
		problem.setCall(calling);
	    problem.setProblemStatus(ProblemStatus.UNSOLVED);
	     
	    customerDao.save(exitingcustomer); 
        result="Problem Is Created Successfully...";
	}
	
	else {
		
		
		CustomerException customerException=new CustomerException("Customer Is Not Present By Given Id");
		throw customerException;
		
	}
	

     return result;	
	
	}

	@Override
	public Problem updateProblem(Problem problem) throws ProblemException {
	
		Optional<Problem> opt=problemDao.findById(problem.getProblemId());
		
        Problem problem3=null;
		 if(opt.isPresent()) {
			 
			 Problem problem2=opt.get();
			 problem2.setProblemTitle(problem.getProblemTitle());
			 problem2.setProblemType(problem.getProblemType());
			 problem2.setProblemDescription(problem.getProblemDescription());
			 
			 
			 problem3= problemDao.save(problem2);
			 
		 }
		 else {
			 
			 ProblemException exception=new ProblemException("Problem Is Not Found By Given Id");
			 throw exception;
			 
		 }
		
		
		
		return problem3;
	}
	
	

}
