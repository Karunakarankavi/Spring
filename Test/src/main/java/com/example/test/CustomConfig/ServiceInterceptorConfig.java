package com.example.test.CustomConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import com.example.test.interceptor.*;
import org.springframework.beans.factory.annotation.Autowired;


@Configuration
public class ServiceInterceptorConfig  extends WebMvcConfigurationSupport {
	
	@Autowired
	Interceptor interceptor;
	
	@Override
	   public void addInterceptors(InterceptorRegistry registry) {
	      registry.addInterceptor(interceptor);
	   }
	

}
