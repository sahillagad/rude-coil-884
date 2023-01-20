package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Customer {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	
    @NotNull(message = "user name cannot set as null")
    @NotEmpty(message =  "user name cannot set as empty")
	@NotBlank(message =  "user name cannot set as blank")
    @Column(unique = true)
    private String userName;
    
    @NotNull(message = "password cannot set as null")
    @NotEmpty(message =  "password cannot set as empty")
	@NotBlank(message =  "password cannot set as blank")
    private String password;
    
    
    
    
    @NotNull(message = "name cannot set as null")
    @NotEmpty(message =  "name cannot set as empty")
	@NotBlank(message =  "name cannot set as blank")
    private String name;
    
    
    /*
    ^     #Match the beginning of the string
	[789] #Match a 7, 8 or 9
	\d    #Match a digit (0-9 and anything else that is a "digit" in the regex engine)
	{9}   #Repeat the previous "\d" 9 times (9 digits)
	$     #Match the end of the string
    
    */
    
    @NotNull(message = "mobile cannot set as null")
    @Pattern(regexp = "^[6-9]\\d{9}$")
    private String mobile;
    
    
	
    @Column(unique = true)
	@Email(message = "email format is incorrect")
	private String email;
	
    
    private CustomerStatus customerStatus;
    
    @OneToMany(mappedBy = "customer",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    List<Calling> calls=new ArrayList<>();
	
	
}
