package com.masai.controller;

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
import com.masai.model.CustomerStatus;
import com.masai.model.Problem;
import com.masai.model.ProblemStatus;
import com.masai.service.OperatorService;

@RestController
@RequestMapping("/OperatorController")
public class OperatorController {

	@Autowired
	private OperatorService service;

	@PutMapping("/customer/{customerId}")
	public ResponseEntity<String> createProblem(@PathVariable("customerId") Integer customerId,
			@RequestBody Problem problem) throws ProblemException, CustomerException {

		String result = service.createProblem(customerId, problem);
		return new ResponseEntity<String>(result, HttpStatus.CREATED);

	}

	@PostMapping("/problem")
	public ResponseEntity<String> UpdateCustomerProblem(@RequestBody Problem problem) throws ProblemException {

		String result = service.UpdateCustomerProblem(problem);
		return new ResponseEntity<String>(result, HttpStatus.CREATED);
	}

	@PutMapping("/problem/{id}/{status}")
	public ResponseEntity<String> closeCustomerProblem(@PathVariable("id") Integer problemId,
			@PathVariable("status") ProblemStatus problemStatus) throws ProblemException {

		String result = service.closeCustomerProblem(problemId, problemStatus);
		return new ResponseEntity<String>(result, HttpStatus.CREATED);

	}

	@GetMapping("customer/{id}")
	public ResponseEntity<Customer> findCustomerById(@PathVariable("id") Integer customerId) throws CustomerException {

		Customer customer = service.findCustomerById(customerId);

		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	@PutMapping("/customer/{id}/{status}")
	public ResponseEntity<String> customerLock(@PathVariable("id") Integer customerId,
			@PathVariable("status") CustomerStatus customerStatus) throws CustomerException {

		String result = service.customerLock(customerId, customerStatus);
		return new ResponseEntity<String>(result, HttpStatus.OK);

	}

}
