package com.masai.service;

import java.util.List;

import javax.security.auth.login.LoginException;

import com.masai.exception.CallException;
import com.masai.exception.DepartmentException;
import com.masai.exception.OperatorException;
import com.masai.model.Admin;
import com.masai.model.Department;
import com.masai.model.Operator;

public interface AdminService {

	public String createAdmin(Admin admin) throws DepartmentException;

	public String createDepartment(Department department) throws DepartmentException;

	public String deleteDepartment(Integer departmentId) throws DepartmentException;

	public String updateDepartment(Department department) throws DepartmentException;

	public Department findDepartmentById(Integer departmentId) throws DepartmentException;

	public List<Department> findAllDepartment() throws DepartmentException;

	public String createOperator(Integer departmentID, Operator operator) throws OperatorException;

	public String deleteOperator(Integer operatorId) throws OperatorException;

	public String updateOperator(Operator operator) throws OperatorException;

	public List<Operator> findAllOperator() throws OperatorException;

	public Operator findOperator(Integer operatorId) throws OperatorException;

	public String assign_Problem_To_Operator(Integer callId, Integer operatorId)
			throws CallException, OperatorException;

	public Admin getSingalVendor(String key) throws LoginException;

}
