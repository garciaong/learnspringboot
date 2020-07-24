package com.garcia.springboot.learning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.garcia.springboot.learning.interceptor.ListInterceptor;

@Component
public class InterceptorConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private ListInterceptor listInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(listInterceptor);
	}

}
