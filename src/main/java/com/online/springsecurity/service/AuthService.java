package com.online.springsecurity.service;

import com.online.springsecurity.dto.SignupRequest;

public interface AuthService {

	boolean createCustomer(SignupRequest signupRequest);

}
