package com.masai.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Solution {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer solutionId; 
	
	private String solutionDescription;
	
	private LocalDate solutiondate;
	
	private LocalTime solutiontime;
	
	
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Problem problem;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Operator operator;
			
	
	
	
}
