package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.DepartmentException;
import com.masai.exception.OperatorException;
import com.masai.exception.ProblemException;
import com.masai.model.Calling;
import com.masai.model.Department;
import com.masai.model.Operator;
import com.masai.model.Problem;
import com.masai.repository.CallDao;
import com.masai.repository.DepartmentDao;
import com.masai.repository.OperatorDao;
import com.masai.repository.ProblemDao;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@Autowired
	private OperatorDao operatorDao;
	
	@Autowired
	private ProblemDao problemDao;
	
	@Autowired
	private CallDao callDao;
	
	
	@Override
	public String createDepartment(Department department) throws DepartmentException {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	@Override
	public String deleteDepartment(Integer departmentId) throws DepartmentException {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	@Override
	public String updateDepartment(Department department) throws DepartmentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department findDepartmentById(Integer departmentId) throws DepartmentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> findAllDepartment() throws DepartmentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createOperator(Integer departmentID, Operator operator) throws OperatorException,DepartmentException {
		// TODO Auto-generated method stub
		
		Optional<Department> dept = departmentDao.findById(departmentID);
		
		if(dept.isPresent()) {
			
			Department d = dept.get();
			d.getOperators().add(operator);
			operator.setDepartment(d);
			operatorDao.save(operator);
			return "Operator created successfuly";
			
		}else {
			
			throw new DepartmentException("Department id invalid");
		}
	}

	@Override
	public String deleteOperator(Integer operatorId) throws OperatorException {
		// TODO Auto-generated method stub
		
		Optional<Operator> op = operatorDao.findById(operatorId);
		
		if(op.isPresent()) {
			
			operatorDao.delete(op.get());
			return "operator deleted successfuly";
			
		}else {
			throw new OperatorException("invalid operator Id");
		}
	}

	@Override
	public String updateOperator(Operator operator) throws OperatorException {
		// TODO Auto-generated method stub
		
		Optional<Operator> op =  operatorDao.findById(operator.getOperatorId());
		
		if(op.isPresent()) {
			
			Operator existingOp = op.get();
			existingOp.setOperatorName(operator.getOperatorName());
			existingOp.setOperatorStatus(operator.getOperatorStatus());
			existingOp.setEmail(operator.getEmail());
			existingOp.setCity(operator.getCity());
			existingOp.setMobile(operator.getMobile());
			existingOp.setDepartment(operator.getDepartment());
			existingOp.setCalls(operator.getCalls());
			existingOp.setSolution(operator.getSolution());
			existingOp.setUserName(operator.getUserName());
			existingOp.setPassword(operator.getPassword());
			operatorDao.save(existingOp);
			return "Operator updated successfully";
		}else {
			throw new OperatorException("operator with Id "+operator.getOperatorId()+"Not found");
		}

	}

	@Override
	public List<Operator> findAllOperator() throws OperatorException {
		// TODO Auto-generated method stub
		
		List<Operator> ops = operatorDao.findAll();
		if(ops.isEmpty()) {
			throw new OperatorException(" there is not data for operator");
			
		}else {
			return ops;
		}
	}

	@Override
	public Operator findOperator(Integer operatorId) throws OperatorException {
		// TODO Auto-generated method stub
		
		
		Optional<Operator> op =  operatorDao.findById(operatorId);
		if(op.isPresent()) {
			
			Operator operator = op.get();
			return operator;
			
		}else {
			throw new  OperatorException("invalid operator Id ");
		}
	}

	@Override
	public String assign_Problem_To_Operator(Integer problemId, Integer operatorId)
			throws ProblemException, OperatorException {
		// TODO Auto-generated method stub
		
	    Optional<Problem> problem = problemDao.findById(problemId);
	 	Optional<Operator> operator = operatorDao.findById(operatorId);
	 	
	    if(problem.isPresent() && operator.isPresent()) {
	    	
	        Problem existingProblem = problem.get();
	        Operator existingOperator = operator.get();
	       List<Calling> calls= callDao.findAll();
	       
	       
	       for(Calling call:calls) {
	    	if(call.getProblem().getProblemId()== problemId) {
	    		
	    		call.setOperator(existingOperator);
	    		existingOperator.getCalls().add(call);
	    	}
	    	   
	       }
	        problemDao.save(existingProblem);
	        
	        return "Problem assigned to operator successfully.";
	        
	    } else if (!problem.isPresent()) {
	    	
	        throw new ProblemException("Problem with ID " + problemId + " not found.");
	    } else {
	        throw new OperatorException("Operator with ID " + operatorId + " not found.");
	    }
	    
	}

}
