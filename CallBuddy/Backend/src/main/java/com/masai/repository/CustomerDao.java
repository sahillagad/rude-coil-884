package com.masai.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{

	
	
	@Query("Select c From Customer c where c.userName=?1 AND c.password=?2")
	public Customer findByUserNameAndPassword(String userName,String password);
	
	public List<Customer> findByName(String name);
	
	
	public  Optional<Customer> findByEmail(String email);
	
	public Customer findByUserName(String userName);
	
	
}
