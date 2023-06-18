package com.masai.controller;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Login;
import com.masai.model.LoginResponse;
import com.masai.service.LoginService;

@RestController
@RequestMapping("/loginController")
public class LoginController {

	@Autowired
	LoginService loginService;

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> USerLogin(@RequestBody Login login) throws LoginException {

		LoginResponse result = loginService.loginUser(login);

		return new ResponseEntity<LoginResponse>(result, HttpStatus.OK);

	}

	@DeleteMapping("/logout/{key}")
	public ResponseEntity<String> UserLogout(@PathVariable("key") String key) throws LoginException {
		String result = loginService.logoutUser(key);

		return new ResponseEntity<String>(result, HttpStatus.OK);

	}

}
