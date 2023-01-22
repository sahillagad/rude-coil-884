package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Calling;

public interface CallDao  extends JpaRepository<Calling,Integer>{

	
}
