package com.masai.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class Calling {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer callId;

	private LocalDate date;

	private LocalTime startTime;

	@JsonIgnore()
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;

	@OneToOne(cascade = CascadeType.ALL)
	private Problem problem;

	@JsonIgnore()
	@ManyToOne()
	private Operator operator;

}
