package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
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
	private Call call;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Solution solution;
	
	
	
}
