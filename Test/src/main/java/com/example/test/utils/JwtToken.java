package com.example.test.utils;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.example.test.controller.*;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtToken {

	private static String secret_key = "karuna@261893";
	private static long expiryDuration =   60 * 60; 
	
	public String generateToken(UserDetails user) {
		
		long milliTime = System.currentTimeMillis();
		long expiryTime = milliTime + expiryDuration * 1000;
		
         Date issuedAt = new Date(milliTime);
		 Date expiryAt = new Date(expiryTime);
		
		
		
		
		//claims
		Claims claims  = Jwts.claims().setIssuer(user.getUserName())
				.setIssuedAt(issuedAt)
				.setExpiration(expiryAt);
		
		
		claims.put("password" , user.getPassword());
		claims.put("userName" , user.getUserName());
		
		
		String token = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret_key).compact();
		
		
		return token;
	}
	
	
	public void verify (String authorization) throws Exception {
		
		
		try{
		Jwts.parser().setSigningKey(secret_key).parseClaimsJws(authorization);
		}catch(Exception e) {
			throw new Exception();
		}
	}
}
