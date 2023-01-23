package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer departmentId;
	
	
    @NotNull(message = "department name cannot set as null")
    @NotEmpty(message =  "department name cannot set as empty")
	@NotBlank(message =  "department name cannot set as blank")
	private String departmentName;
	
	

    @NotNull(message = "department State cannot set as null")
    @NotEmpty(message =  "department State cannot set as empty")
	@NotBlank(message =  "department State cannot set as blank")   
	private String departmentState;
    
    @NotNull(message = "department City cannot set as null")
    @NotEmpty(message =  "department City cannot set as empty")
	@NotBlank(message =  "department City cannot set as blank")
	private String departmentCity;
    
    @NotNull(message = "pincode cannot set as null")
    @NotEmpty(message =  "pincode name cannot set as empty")
	@NotBlank(message =  "pincode name cannot set as blank")
	@Size(min = 6 ,max = 6 ,message = "pincode is Must Be 6 digit")
    private String pincode;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "department")
     private List<Operator> operators=new ArrayList<>();
	
}
