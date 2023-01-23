package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Operator {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer operatorId;
	
	@NotNull(message = "user name cannot set as null")
	@NotEmpty(message = "user name cannot set as empty")
	@NotBlank(message = "user name cannot set as blank")
	@Column(unique = true)
	private String userName;
	
	
	@NotNull(message = "password cannot set as null")
	@NotEmpty(message = "password cannot set as empty")
	@NotBlank(message = "password cannot set as blank")
	private String password;
	
	
	@NotNull(message = "operator Name cannot set as null")
	@NotEmpty(message = "operator Name cannot set as empty")
	@NotBlank(message = "operator Name cannot set as blank")
	private String operatorName;
	
    @Column(unique = true)
	@Email(message = "email format is incorrect")
	private String email;
	
    
    @NotNull(message = "mobile cannot set as null")
    @Pattern(regexp = "^[6-9]\\d{9}$")
	private String mobile;
	
    
    @NotNull(message = "city  cannot set as null")
	@NotEmpty(message = "city  cannot set as empty")
	@NotBlank(message = "city  cannot set as blank")
	private String city;
	
	
    @Enumerated(EnumType.STRING)
	private OperatorStatus operatorStatus;

    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy ="operator")
    private List<Calling> calls=new ArrayList<>();
    
    
    @OneToOne(cascade = CascadeType.ALL)
    private Solution solution;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;
    
    
    

    
}
