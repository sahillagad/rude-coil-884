package com.masai.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@NoArgsConstructor
@AllArgsConstructor
public class Admin {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adminId;
	
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
    
    @NotNull(message = "mobile cannot set as null")
    @Pattern(regexp = "^[6-9]\\d{9}$")
    private String mobile;
    
    
	
    @Column(unique = true)
	@Email(message = "email format is incorrect")
	private String email;



	public Integer getAdminId() {
		return adminId;
	}



	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}
    
    
}
