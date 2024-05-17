package com.online.springsecurity.dto;

public class LoginResponse {

	private String jwtToken;

	public LoginResponse(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}
}
