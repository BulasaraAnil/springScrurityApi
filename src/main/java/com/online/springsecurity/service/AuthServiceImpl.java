package com.online.springsecurity.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.online.springsecurity.dto.SignupRequest;
import com.online.springsecurity.entity.Customer;
import com.online.springsecurity.repository.CustomerRepository;

@Service
public class AuthServiceImpl implements AuthService {
	
	
	private final CustomerRepository customerRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	
	@Autowired
	public AuthServiceImpl(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
		super();
		this.customerRepository = customerRepository;
		this.passwordEncoder = passwordEncoder;
	}



	@Override
	public Customer createCustomer(SignupRequest signupRequest) {
		// check customer already create or not
		
		if(customerRepository.existsByEmail(signupRequest.getEmail())) {
			return null;
		}
		Customer customer = new Customer();
		BeanUtils.copyProperties(signupRequest, customer);
		
		customer.setEmail(signupRequest.getEmail());
		customer.setName(signupRequest.getName());
		//Hash the password before saving
		String hashPassword =	passwordEncoder.encode(signupRequest.getPassword());
		customer.setPassword(hashPassword);
		customerRepository.save(customer);
		
		
		return customer;
	}

}
