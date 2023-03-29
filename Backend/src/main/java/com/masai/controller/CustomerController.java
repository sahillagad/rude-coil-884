package com.masai.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.exception.ProblemException;
import com.masai.model.Customer;
import com.masai.model.Problem;
import com.masai.model.ProblemStatus;
import com.masai.service.CustomerService;

@RestController
@RequestMapping("/customerController")
public class CustomerController {

	@Autowired
	private CustomerService service;

	@PostMapping("/Customer")
	public ResponseEntity<String> createCustomer(@RequestBody Customer customer) throws CustomerException {

		String result = service.createCustomer(customer);

		return new ResponseEntity<String>(result, HttpStatus.CREATED);
	}

	@GetMapping("/problem/{id}")
	public ResponseEntity<Problem> viewProblem(@PathVariable("id") Integer problemId) throws ProblemException {

		Problem problem = service.viewProblem(problemId);
		return new ResponseEntity<Problem>(problem, HttpStatus.CREATED);
	}

	@PutMapping("/problem/{id}/{status}")
	public ResponseEntity<String> reopenProblem(@PathVariable("id") Integer problemId,
			@PathVariable("status") ProblemStatus ProblemStatus) throws ProblemException {

		String result = service.reopenProblem(problemId, ProblemStatus);
		return new ResponseEntity<String>(result, HttpStatus.OK);

	}

	@PutMapping("/Customer")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer customer) throws CustomerException {

		String result = service.updateCustomer(customer);
		return new ResponseEntity<String>(result, HttpStatus.ACCEPTED);

	}

	@GetMapping("/problems")
	public ResponseEntity<List<Problem>> viewAllProblem() throws ProblemException {

		List<Problem> problems = new ArrayList<>();

		return new ResponseEntity<List<Problem>>(problems, HttpStatus.OK);

	}

	@PutMapping("/customer/{userName}/{oldPassword}/{newPassword}")
	public ResponseEntity<String> changeCustomerPassword(@PathVariable("userName") String customerUserName,
			@PathVariable("oldPassword") String oldPassword, @PathVariable("newPassword") String newPassword)
			throws CustomerException {

		String result = service.changeCustomerPassword(customerUserName, oldPassword, newPassword);

		return new ResponseEntity<String>(result, HttpStatus.OK);

	}

	@PostMapping("/customer/{id}")
	public ResponseEntity<String> createProblem(@PathVariable("id") Integer customerId, @RequestBody Problem problem)
			throws ProblemException, CustomerException {

		String result = service.createProblem(customerId, problem);
		return new ResponseEntity<String>(result, HttpStatus.CREATED);

	}

	@PutMapping("/problem")
	public ResponseEntity<Problem> updateProblem(@RequestBody Problem problem) throws ProblemException {

		Problem problem2 = service.updateProblem(problem);
		return new ResponseEntity<Problem>(problem, HttpStatus.CREATED);

	}

}
