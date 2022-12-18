package com.example.test.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.utils.*;


@CrossOrigin(origins = "*")
@RestController
public class ApiController {
	
	@Autowired
	private JwtToken utils;
	
	
	
	@PostMapping("/login")
	public String returnJwt(@RequestBody UserDetails user) {
		
	 if(user.getPassword() == 123456) {
       String token =  utils.generateToken(user);
       
		 
		return token;
		}
	 
	 return "login failed";
	}
	
	
	@PostMapping("/dashboard")
	public String dashboard (@RequestHeader(value = "Authorization")String auth) throws Exception {
		
		
		return "inside dashboard ";
		
	}
	
	
	@PostMapping("/message")
	public String message () {
	
		return "inside msg service";
	}
	

}
