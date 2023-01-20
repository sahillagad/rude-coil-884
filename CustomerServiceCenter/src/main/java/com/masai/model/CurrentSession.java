package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrentSession {

	@javax.persistence.Id
	@Column(unique = true)
	private Integer Id;
	

	
	
	private String uuid;
	
	
	
	private LocalDateTime timeStamp;
	
	private String type;
}
