package com.online.springsecurity.service;

import com.online.springsecurity.dto.SignupRequest;
import com.online.springsecurity.entity.Customer;

public interface AuthService {

	Customer createCustomer(SignupRequest signupRequest);

}
