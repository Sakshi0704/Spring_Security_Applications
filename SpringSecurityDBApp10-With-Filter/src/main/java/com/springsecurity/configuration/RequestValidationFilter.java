package com.springsecurity.configuration;

import java.io.IOException;

import org.springframework.security.authentication.BadCredentialsException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RequestValidationFilter implements Filter{

	
	/*
	 * A ServletRequest encapsulates all the details
	 * 
	 *  of a user's request in a Java web application. 
	 *  It provides essential information about the client's HTTP request, 
	 *  allowing you to access parameters, headers, and 
	 *  other important data for processing. 
	 *  But it doesn't have the power of HttpServletRequest with is the child class of ServletRequest
	 *  the power are like with ServletRequest we can not access the header about request
	 * 	you can't get the cookie information this power only have HttpServletRequest
	 * 
	 * */
	
	/**
	 * 
	 * 
	 */
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest hreq  = (HttpServletRequest)request;
		
		HttpServletResponse hres = (HttpServletResponse)response; 
		
		String header = hreq.getHeader("Allow");
		
		if(header == null || header.equals("test")) {
			hres.setStatus(HttpServletResponse.SC_BAD_REQUEST); // response - 400
			throw new BadCredentialsException("Header should contain key as Allow and value should not be test");
		}
		
		chain.doFilter(request, response);
	}

}
