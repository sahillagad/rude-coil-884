package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Problem;

public interface ProblemDao extends JpaRepository<Problem, Integer> {

}
