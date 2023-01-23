package com.masai.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity 
public class Problem {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer problemId;
	
	@NotNull(message = "problemType  cannot set as null")
	@NotEmpty(message = "problemType  cannot set as empty")
	@NotBlank(message = "problemType  cannot set as blank")
	@Enumerated(EnumType.STRING)
	private ProblemType problemType;
	
	
	private String problemDescription;
	
	
	@Enumerated(EnumType.STRING)
	private ProblemStatus problemStatus;
	

	@OneToOne(cascade = CascadeType.ALL)
	private Calling call;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Solution solution;
	
	
	
}
