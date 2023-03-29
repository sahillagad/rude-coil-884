package com.masai.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
