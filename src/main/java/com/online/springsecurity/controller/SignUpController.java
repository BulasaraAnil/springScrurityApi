package com.online.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.springsecurity.dto.SignupRequest;
import com.online.springsecurity.entity.Customer;
import com.online.springsecurity.service.AuthService;

@RestController
@RequestMapping("/signup")
@CrossOrigin("*")
public class SignUpController {
	
	private AuthService authService;

	@Autowired
	public SignUpController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
//	@PostMapping(produces = "application/json")
//	public ResponseEntity<String> signupController(@RequestBody SignupRequest signupRequest){
//		boolean isUserCreated = authService.createCustomer(signupRequest);
//		
//		if(isUserCreated) {
//			return new ResponseEntity<>("Customer Created Successfully", HttpStatus.CREATED);
//			//return ResponseEntity.status(HttpStatus.CREATED).body("Customer Created Successfully");
//		}else {
//			return new ResponseEntity<>("Failed to Create User", HttpStatus.BAD_REQUEST);
//			//return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to Create User");
//		}
//	}
	
    @PostMapping
    public ResponseEntity<Customer> signupCustomer(@RequestBody SignupRequest signupRequest) {
        Customer createdCustomer = authService.createCustomer(signupRequest);
        if (createdCustomer != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
