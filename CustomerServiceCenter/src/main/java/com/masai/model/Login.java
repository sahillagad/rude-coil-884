package com.masai.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Login {
	

    @NotNull(message = "userName cannot set as null")
    @NotEmpty(message =  "userName cannot set as empty")
	@NotBlank(message =  "userName cannot set as blank")
     private String userName;
    

    @NotNull(message = "password cannot set as null")
    @NotEmpty(message =  "password cannot set as empty")
	@NotBlank(message =  "password cannot set as blank")
     private String password;
	 
    @NotNull
    private String user_Type;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Login(
			@NotNull(message = "userName cannot set as null") @NotEmpty(message = "userName cannot set as empty") @NotBlank(message = "userName cannot set as blank") String userName,
			@NotNull(message = "password cannot set as null") @NotEmpty(message = "password cannot set as empty") @NotBlank(message = "password cannot set as blank") String password,
			@NotNull String user_Type) {
		super();
		this.userName = userName;
		this.password = password;
		this.user_Type = user_Type;
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

	public String getUser_Type() {
		return user_Type;
	}

	public void setUser_Type(String user_Type) {
		this.user_Type = user_Type;
	}
    
    
}
