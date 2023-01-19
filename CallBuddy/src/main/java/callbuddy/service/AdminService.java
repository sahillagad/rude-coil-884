package callbuddy.service;

import java.util.List;

import callbuddy.exception.DepartmentException;
import callbuddy.exception.OperatorException;
import callbuddy.model.Department;
import callbuddy.model.Operator;

public interface AdminService {
	
	
	public Department addDepartment(Department dept) throws DepartmentException;
	
	public Department removeDepartment(Integer deptId) throws DepartmentException;
	
	public Department updateDepartment(Department dept) throws DepartmentException;
	
	public Department findDepartmentById(Integer deptId) throws DepartmentException;
	
	public Operator addOperator(Operator op) throws OperatorException;
	
	public Operator removeOperator(Integer opId) throws OperatorException;
	
	public Operator updateOperator(Operator op) throws OperatorException;
	
	public Operator findOperatorById( Integer opId) throws OperatorException;
	
	public List<Operator> findAllOperator() throws OperatorException;
	
	

}
