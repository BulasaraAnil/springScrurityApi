package com.online.springsecurity.service.jwt;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

import com.online.springsecurity.entity.Customer;
import com.online.springsecurity.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements UserDetailsService {
	
	private final CustomerRepository customerRepository;
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	  @Override
	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	        // Write logic to fetch customer from DB
	        Customer customer = customerRepository.findByEmail(email)
	                .orElseThrow(() -> new UsernameNotFoundException("Customer not found with email: " + email));

	        return new User(customer.getEmail(), customer.getPassword(), Collections.emptyList());
	    }

}
