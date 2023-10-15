package com.springsecurity.configuration;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class AuthoritiesLogginAfterFilter implements Filter {
	
	private final Logger log = LoggerFactory.getLogger(AuthoritiesLogginAfterFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		// after user is login successfully then this filter will exicute means that 
		// after user is authenticated then in SecurityContextHolder we will be having
		// Authentication object that have principle object.
		// means
		// this authentication object is authenticated object.
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth!=null) {
			log.info("User "+auth.getName()+" is successfully authenticated and has Authorties "+auth.getAuthorities().toString());
		}
		
		chain.doFilter(request, response);
	}

}
