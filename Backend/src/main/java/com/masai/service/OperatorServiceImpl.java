package com.masai.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.exception.ProblemException;
import com.masai.model.Calling;
import com.masai.model.Customer;
import com.masai.model.CustomerStatus;
import com.masai.model.Problem;
import com.masai.model.ProblemStatus;
import com.masai.repository.AdminDao;
import com.masai.repository.CallDao;
import com.masai.repository.CustomerDao;
import com.masai.repository.DepartmentDao;
import com.masai.repository.OperatorDao;
import com.masai.repository.ProblemDao;

@Service
public class OperatorServiceImpl implements OperatorService {

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

//
//	@Override
//	public String addCustomerProblem(Integer callId, Problem problem) throws ProblemException, CustomerException {
//		
//  return null;
//	}
//	
	@Override
	public String createProblem(Integer customerId, Problem problem) throws ProblemException, CustomerException {
		String result = "Problem Is Not Created Due TO Some Error";

		Optional<Customer> opt = customerDao.findById(customerId);
		if (opt.isPresent()) {

			Customer exitingcustomer = opt.get();
			Calling calling = new Calling();
			calling.setCustomer(exitingcustomer);
			calling.setDate(LocalDate.now());
			calling.setProblem(problem);
			calling.setStartTime(LocalTime.now());

			exitingcustomer.getCalls().add(calling);
			problem.setCall(calling);

			callDao.save(calling);
			problemDao.save(problem);
			result = "Problem Is Created Successfully...";
		}

		else {

			CustomerException customerException = new CustomerException("Customer Is Not Present By Given Id");
			throw customerException;

		}

		return result;

	}

	@Override
	public String UpdateCustomerProblem(Problem problem) throws ProblemException {
		Optional<Problem> opt = problemDao.findById(problem.getProblemId());

		String result = "Customer Problem Update Process Failed";
		if (opt.isPresent()) {

			Problem problem2 = opt.get();
			problem2.setProblemTitle(problem.getProblemTitle());
			problem2.setProblemType(problem.getProblemType());
			problem2.setProblemDescription(problem.getProblemDescription());

			Problem problem3 = problemDao.save(problem2);

			if (problem3 != null) {

				result = "Customer Problem Update Successfully";

			}
		} else {

			ProblemException exception = new ProblemException("Problem Is Not Found By Given Id");
			throw exception;

		}

		return result;
	}

	@Override
	public String closeCustomerProblem(Integer problemId, ProblemStatus problemStatus) throws ProblemException {
		String result = "Problem Status Is Not Change Due To Some Error";

		Optional<Problem> opt = problemDao.findById(problemId);
		if (opt.isPresent()) {

			Problem problem = opt.get();
			problem.setProblemStatus(problemStatus);

			problemDao.save(problem);
			result = "Problem Status Is Change Successfully...";

		} else {
			ProblemException exception = new ProblemException("Problem Is Not Present By Given ID");
			throw exception;
		}
		return result;
	}

	@Override
	public Customer findCustomerById(Integer customerId) throws CustomerException {

		Optional<Customer> opt = customerDao.findById(customerId);
		Customer customer = null;

		if (opt.isPresent()) {
			customer = opt.get();

		} else {

			CustomerException customerException = new CustomerException("Customer Is Not Present By Given Id");

			throw customerException;
		}

		return customer;
	}

	@Override
	public String customerLock(Integer customerId, CustomerStatus customerStatus) throws CustomerException {
		String result = "Customer Status Update Failed";

		Optional<Customer> opt = customerDao.findById(customerId);

		if (opt.isPresent()) {

			Customer customer = opt.get();
			customer.setCustomerStatus("CANLOGIN");
			customerDao.save(customer);
			result = "Customer Status Update Successfully";

		} else {

			CustomerException customerException = new CustomerException("Customer Is Not Present By Given Id");
			throw customerException;

		}

		return result;
	}

}
