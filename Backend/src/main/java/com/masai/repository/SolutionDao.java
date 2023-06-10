package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Solution;

public interface SolutionDao extends JpaRepository<Solution,Integer> {

}
