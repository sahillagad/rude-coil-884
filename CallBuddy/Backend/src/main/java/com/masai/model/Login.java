package com.masai.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login {
	

    @NotNull(message = "userName cannot set as null")
    @NotEmpty(message =  "userName cannot set as empty")
	@NotBlank(message =  "userName cannot set as blank")
     private String userName;
    
    

    @NotNull(message = "password cannot set as null")
    @NotEmpty(message =  "password cannot set as empty")
	@NotBlank(message =  "password cannot set as blank")
     private String password;
    
    @NotNull(message = "password cannot set as null")
    @NotEmpty(message =  "password cannot set as empty")
	@NotBlank(message =  "password cannot set as blank")
    private String User_Type;
	 
}
