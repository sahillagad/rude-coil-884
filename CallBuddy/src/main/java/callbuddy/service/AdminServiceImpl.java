package callbuddy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import callbuddy.exception.DepartmentException;
import callbuddy.exception.OperatorException;
import callbuddy.model.Department;
import callbuddy.model.Operator;
import callbuddy.repository.AdminDao;
import callbuddy.repository.DepartmentDao;
import callbuddy.repository.OperatorDao;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private OperatorDao operatorDao;
	
	@Autowired
	private DepartmentDao deptDao;

	@Override
	public Department addDepartment(Department dept) throws DepartmentException {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	@Override
	public Department removeDepartment(Integer deptId) throws DepartmentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department updateDepartment(Department dept) throws DepartmentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department findDepartmentById(Integer deptId) throws DepartmentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Operator addOperator(Operator op) throws OperatorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Operator removeOperator(Integer opId) throws OperatorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Operator updateOperator(Operator op) throws OperatorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Operator findOperatorById(Integer opId) throws OperatorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Operator> findAllOperator() throws OperatorException {
		// TODO Auto-generated method stub
		return null;
	}

}
