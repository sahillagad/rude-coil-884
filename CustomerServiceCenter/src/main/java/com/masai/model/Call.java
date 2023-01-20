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
import javax.validation.constraints.Future;

import com.fasterxml.jackson.annotation.JsonIgnore;



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
