package com.masai.controller;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Login;
import com.masai.service.LoginService;

@RestController
@RequestMapping("/loginController")
public class LoginController {

	@Autowired
	LoginService loginService;

	@PostMapping("/login")
	public ResponseEntity<String> USerLogin(@RequestBody Login login) throws LoginException {

		String result = loginService.loginUser(login);

		return new ResponseEntity<String>(result, HttpStatus.OK);

	}

	@DeleteMapping("/logout")
	public ResponseEntity<String> UserLogout(@RequestParam(required = false) String key) throws LoginException {
		String Result = loginService.logoutUser(key);
		return new ResponseEntity<String>(HttpStatus.OK);

	}

}
