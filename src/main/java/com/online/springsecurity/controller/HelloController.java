package com.online.springsecurity.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class HelloController {
	
	@GetMapping("/hello")
	public String hello() {
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		return "Hello From Authorized API Request!";	
		}

}
