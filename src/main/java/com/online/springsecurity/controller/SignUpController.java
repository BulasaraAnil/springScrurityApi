package com.online.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.springsecurity.dto.SignupRequest;
import com.online.springsecurity.service.AuthService;

@RestController
@RequestMapping("/signup")
public class SignUpController {
	
	private AuthService authService;

	@Autowired
	public SignUpController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@PostMapping
	public ResponseEntity<String> signupController(@RequestBody SignupRequest signupRequest){
		boolean isUserCreated = authService.createCustomer(signupRequest);
		
		if(isUserCreated) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Customer Created Successfully");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to Create User");
		}
	}
}
