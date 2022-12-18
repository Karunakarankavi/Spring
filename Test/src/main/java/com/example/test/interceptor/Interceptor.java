package com.example.test.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.test.utils.*;


@Component
public class Interceptor implements HandlerInterceptor {
	
	@Autowired
	private JwtToken jwtUtils;

	@Override
	   public boolean preHandle(
	      HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	    
		  String auth = request.getHeader("Authorization");
		  if(!(request.getRequestURI().equals("/login"))) {
		 jwtUtils.verify(auth);}
	      return true;}
	
}
