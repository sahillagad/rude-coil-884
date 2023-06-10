package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Operator;

@Repository
public interface OperatorDao extends JpaRepository<Operator,Integer> {

	public Operator findByUserName(String userName);
}
