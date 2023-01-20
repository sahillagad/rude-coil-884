package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;



@Entity
@Data
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
    private List<Call> calls=new ArrayList<>();
    
    
    @OneToOne(cascade = CascadeType.ALL)
    private Solution solution;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;
    
    
    

    
}
