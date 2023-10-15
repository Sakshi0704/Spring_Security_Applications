package com.springsecurity.configuration;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class LoggingFilterAt implements Filter{

	private final Logger log = LoggerFactory.getLogger(LoggingFilterAt.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		// this filter order is not specified so it can be anywhere either before BasicAuthenticationFilter or after that filter
		// mostly we don't use this method
		
		log.info("Authentication validation is in progress");
		
		chain.doFilter(request, response);
	}

}
