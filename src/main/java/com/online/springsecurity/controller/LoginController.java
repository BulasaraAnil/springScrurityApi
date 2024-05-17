package com.online.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.springsecurity.dto.LoginRequest;
import com.online.springsecurity.dto.LoginResponse;
import com.online.springsecurity.utils.JwtUtil;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	private AuthenticationManager authenticationManager;
	private UserDetailsService userDetailsService;
	private JwtUtil jwtUtil;

	@Autowired
	public LoginController(AuthenticationManager authenticationManager, UserDetailsService userDetailsService, JwtUtil jwtUtil) {
		this.authenticationManager = authenticationManager;
		this.userDetailsService = userDetailsService;
		this.jwtUtil = jwtUtil;
	}
	
	@PostMapping
	public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
	    try {
	        authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
	    } catch (AuthenticationException e) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	    }

	    UserDetails userDetails;
	    try {
	        userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }

	    String jwt = jwtUtil.generateToken(userDetails.getUsername());

	    return ResponseEntity.ok(jwt);  // Correctly return the JWT token in the response body
	}

}
