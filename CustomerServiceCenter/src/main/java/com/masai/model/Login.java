package com.masai.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Login {
	

    @NotNull(message = "userName cannot set as null")
    @NotEmpty(message =  "userName cannot set as empty")
	@NotBlank(message =  "userName cannot set as blank")
     private String userName;
    

    @NotNull(message = "password cannot set as null")
    @NotEmpty(message =  "password cannot set as empty")
	@NotBlank(message =  "password cannot set as blank")
     private String password;
	 
}
