package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Problem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer problemId;

	private String problemTitle;

	@Enumerated(EnumType.STRING)
	private ProblemType problemType;

	private String problemDescription;

	@JsonIgnore
	@Enumerated(EnumType.STRING)
	private ProblemStatus problemStatus = ProblemStatus.UNSOLVED;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Calling call;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Solution solution;

}
