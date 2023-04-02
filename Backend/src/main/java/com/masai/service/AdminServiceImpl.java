package com.masai.service;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CallException;
import com.masai.exception.DepartmentException;
import com.masai.exception.OperatorException;
import com.masai.model.Admin;
import com.masai.model.Calling;
import com.masai.model.CurrentSession;
import com.masai.model.Department;
import com.masai.model.Operator;
import com.masai.repository.AdminDao;
import com.masai.repository.CallDao;
import com.masai.repository.DepartmentDao;
import com.masai.repository.OperatorDao;
import com.masai.repository.ProblemDao;
import com.masai.repository.SessionDao;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private DepartmentDao departmentDao;

	@Autowired
	private OperatorDao operatorDao;

	@Autowired
	private CallDao callDao;

	@Autowired
	private AdminDao adminDao;

	@Autowired
	private SessionDao sessionDao;

	@Override
	public String createDepartment(Department department) throws DepartmentException {
		String result = "Department NOt Added";

		Department department2 = departmentDao.save(department);

		if (department2 != null) {

			result = "Department Added Successfully";

		} else {

			DepartmentException departmentException = new DepartmentException(result);

			throw departmentException;
		}

		return result;
	}

	@Override
	public String deleteDepartment(Integer departmentId) throws DepartmentException {
		String result = "Department Is Not Deleted";

		Optional<Department> opt = departmentDao.findById(departmentId);

		if (opt.isPresent()) {

			departmentDao.delete(opt.get());
			result = "Department Is Delete Successfully...";

		} else {

			DepartmentException departmentException = new DepartmentException("Department Not Found Out Given Id");
			throw departmentException;
		}

		return result;
	}

	@Override
	public String updateDepartment(Department department) throws DepartmentException {

		String result = "Department Is Not update";

		Optional<Department> opt = departmentDao.findById(department.getDepartmentId());

		if (opt.isPresent()) {

			Department extingDepartment = opt.get();

			extingDepartment.setDepartmentName(department.getDepartmentName());
			extingDepartment.setDepartmentCity(department.getDepartmentCity());
			extingDepartment.setDepartmentState(department.getDepartmentState());
			extingDepartment.setPincode(department.getPincode());

			departmentDao.save(extingDepartment);
			result = "Department Is update Successfully...";

		} else {

			DepartmentException departmentException = new DepartmentException("Department Not Found Out Given Id");
			throw departmentException;
		}

		return result;

	}

	@Override
	public Department findDepartmentById(Integer departmentId) throws DepartmentException {

		Department department = null;

		Optional<Department> opt = departmentDao.findById(departmentId);

		if (opt.isPresent()) {

			department = opt.get();

		} else {

			DepartmentException departmentException = new DepartmentException("Department Not Found Out Given Id");
			throw departmentException;
		}

		return department;

	}

	@Override
	public List<Department> findAllDepartment() throws DepartmentException {

		List<Department> departments = null;

		departments = departmentDao.findAll();

		if (departments == null) {
			DepartmentException departmentException = new DepartmentException("Department DataBase Is Empty");
			throw departmentException;
		}
		return departments;

	}

	@Override
	public String createOperator(Integer departmentID, Operator operator) throws OperatorException {

		String result = "Operator Is Not created";
		Optional<Department> dept = departmentDao.findById(departmentID);

		if (dept.isPresent()) {

			Department d = dept.get();
			d.getOperators().add(operator);

			operatorDao.save(operator);

			result = "Operator created successfuly";

		} else {

			throw new OperatorException("Department id invalid");
		}

		return result;
	}

	@Override
	public String deleteOperator(Integer operatorId) throws OperatorException {

		Optional<Operator> op = operatorDao.findById(operatorId);

		if (op.isPresent()) {

			Operator operator = op.get();
			operatorDao.delete(operator);
			return "operator deleted successfuly";

		} else {
			throw new OperatorException("invalid operator Id");
		}

	}

	@Override
	public String updateOperator(Operator operator) throws OperatorException {

		String result = "Operator Not Update Due To Some Error";

		Optional<Operator> op = operatorDao.findById(operator.getOperatorId());

		if (op.isPresent()) {

			Operator existingOp = op.get();
			existingOp.setOperatorName(operator.getOperatorName());
			existingOp.setUserName(operator.getUserName());
			existingOp.setEmail(operator.getEmail());
			existingOp.setPassword(operator.getPassword());
			existingOp.setMobile(operator.getMobile());
			existingOp.setCity(operator.getCity());

			result = "Operator Update Successfully...";

		} else {

			OperatorException exception = new OperatorException("Department Not Found Out Given Id");
			throw exception;
		}

		return result;

	}

	@Override
	public List<Operator> findAllOperator() throws OperatorException {

		List<Operator> operatorslist = operatorDao.findAll();

		if (operatorslist.isEmpty()) {

			throw new OperatorException("operator DataBase Is Empty ");

		} else {

			return operatorslist;

		}

	}

	@Override
	public Operator findOperator(Integer operatorId) throws OperatorException {
		Optional<Operator> op = operatorDao.findById(operatorId);

		if (op.isPresent()) {

			Operator operator = op.get();
			return operator;

		} else {

			throw new OperatorException("Operator Not Found Out Given Id");

		}
	}

	@Override
	public String assign_Problem_To_Operator(Integer callId, Integer operatorId)
			throws CallException, OperatorException {
		String result = "Call Not Assign To The Operator";

		Optional<Calling> calling = callDao.findById(callId);
		Optional<Operator> operator = operatorDao.findById(operatorId);

		if (calling != null && operator != null) {

			Calling exitingCalling = calling.get();
			Operator exitingOperator = operator.get();

			exitingCalling.setOperator(exitingOperator);
			exitingOperator.getCalls().add(exitingCalling);

			result = "Call Id : " + exitingCalling.getCallId() + " is Assign To The Operator Id : "
					+ exitingOperator.getOperatorId();
		} else if (calling == null) {

			CallException callException = new CallException("Call Not Found Out Given Id");

			throw callException;
		} else if (operator == null) {

			OperatorException exception = new OperatorException("Operator Not Found Out Given Id");
			throw exception;
		}

		return result;
	}

	@Override
	public String createAdmin(Admin admin) throws DepartmentException {
	
		String res = " admin not register ";

		Admin ad = adminDao.save(admin);

		if (ad != null) {
			res = " admin register successfuly";
//		  List<Department> list = ad.getDepartment();
//		  
//		  for( Department d : list) {
//			  departmentDao.save(d);
//		  }

		} else {
			throw new DepartmentException("admin id invalid ");
		}

		return res;
	}

	@Override
	public Admin getSingalVendor(String key) throws LoginException {
		CurrentSession session = sessionDao.findByUuid(key);

		if (session == null) {
			throw new LoginException("Vendor Not logged In");
		}
		Optional<Admin> adminOpt = adminDao.findById(session.getId());
		Admin admin = adminOpt.get();

		return admin;
	}

}
