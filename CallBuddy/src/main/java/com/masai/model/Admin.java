package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
public class Admin {

	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
	
	private String adminName;
	
	private String eamil;

    
    @NotNull(message = "user name cannot set as null")
    @NotEmpty(message =  "user name cannot set as empty")
	@NotBlank(message =  "user name cannot set as blank")
    @Column(unique = true)
    private String userName;
    
    @NotNull(message = "password cannot set as null")
    @NotEmpty(message =  "password cannot set as empty")
	@NotBlank(message =  "password cannot set as blank")
    private String password;
	
	//@JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private List<Department> department=new ArrayList<>();
    
	
	
	
	
	
}

