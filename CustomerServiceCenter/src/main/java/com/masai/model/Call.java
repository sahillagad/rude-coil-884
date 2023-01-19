package com.masai.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Future;

@Entity
public class Call {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer callId;
	
	@Future(message = "Please Provide Proper Date")
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
