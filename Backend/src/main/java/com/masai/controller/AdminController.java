package com.masai.controller;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CallException;
import com.masai.exception.DepartmentException;
import com.masai.exception.OperatorException;
import com.masai.exception.ProblemException;
import com.masai.model.Admin;
import com.masai.model.Department;
import com.masai.model.Operator;
import com.masai.model.OperatorStatus;
import com.masai.service.AdminService;

@RestController
@RequestMapping("/adminController")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/department")
	public ResponseEntity<String> createDepartment(@RequestBody Department department) throws DepartmentException {

		String result = adminService.createDepartment(department);

		return new ResponseEntity<String>(result, HttpStatus.CREATED);
	}

	@DeleteMapping("/department/{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable("id") Integer departmentId)
			throws DepartmentException {

		String result = adminService.deleteDepartment(departmentId);

		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

	@PutMapping("/department")
	public ResponseEntity<String> updateDepartment(@RequestBody Department department) throws DepartmentException {

		String result = adminService.updateDepartment(department);

		return new ResponseEntity<String>(result, HttpStatus.ACCEPTED);
	}

	@GetMapping("/department/{id}")
	public ResponseEntity<Department> findDepartmentById(@PathVariable("id") Integer departmentId)
			throws DepartmentException {

		Department department2 = adminService.findDepartmentById(departmentId);

		return new ResponseEntity<Department>(department2, HttpStatus.ACCEPTED);

	}

	@GetMapping("/department")
	public ResponseEntity<List<Department>> findAllDepartment() throws DepartmentException {

		List<Department> departments = adminService.findAllDepartment();

		return new ResponseEntity<List<Department>>(departments, HttpStatus.ACCEPTED);

	}

	@PostMapping("/operator/{id}")
	public ResponseEntity<String> createOperator(@PathVariable("id") Integer departmentID,
			@RequestBody Operator operator) throws OperatorException {

		String result = adminService.createOperator(departmentID, operator);

		return new ResponseEntity<String>(result, HttpStatus.CREATED);
	}

	@DeleteMapping("/operator/{id}")
	public ResponseEntity<String> deleteOperator(@PathVariable("id") Integer operatorId) throws OperatorException {

		String result = adminService.deleteOperator(operatorId);

		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

	@PutMapping("/operator")
	public ResponseEntity<String> updateOperator(@RequestBody Operator operator) throws OperatorException {

		String result = adminService.updateOperator(operator);

		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

	@GetMapping("/operator")
	public ResponseEntity<List<Operator>> findAllOperator() throws OperatorException {

		List<Operator> operators = adminService.findAllOperator();

		return new ResponseEntity<List<Operator>>(operators, HttpStatus.ACCEPTED);

	}

	@GetMapping("/operator/{id}")
	public ResponseEntity<Operator> findOperator(@PathVariable("id") Integer operatorId) throws OperatorException {

		Operator operator = adminService.findOperator(operatorId);

		return new ResponseEntity<Operator>(operator, HttpStatus.ACCEPTED);
	}

	@PostMapping("/admin/{callId}/{operatorId}")
	public ResponseEntity<String> assign_Problem_To_Operator(@PathVariable("callId") Integer callId,
			@PathVariable("operatorId") Integer operatorId) throws CallException, OperatorException {

		String result = adminService.assign_Problem_To_Operator(callId, operatorId);

		return new ResponseEntity<String>(result, HttpStatus.OK);

	}

	@PostMapping("/admin")
	public ResponseEntity<String> createAdmin(@RequestBody Admin admin) throws DepartmentException {

		String result = adminService.createAdmin(admin);

		return new ResponseEntity<String>(result, HttpStatus.OK);

	}
	
	@GetMapping("/singalAdmin/{key}")
	public ResponseEntity<Admin> getSingalVendor(@PathVariable("key") String key) throws LoginException{
		
		Admin admin = adminService.getSingalVendor(key);
		return new ResponseEntity<Admin>(admin, HttpStatus.ACCEPTED);
		
	}

}
