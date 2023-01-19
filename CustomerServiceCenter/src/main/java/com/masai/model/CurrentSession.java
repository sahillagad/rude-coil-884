package com.masai.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CurrentSession {

	@Id
	@Column(unique = true)
	private Integer Id;
	

	private String type;
	
	private String uuid;
	
	private LocalDateTime timeStamp;
	
	
}
