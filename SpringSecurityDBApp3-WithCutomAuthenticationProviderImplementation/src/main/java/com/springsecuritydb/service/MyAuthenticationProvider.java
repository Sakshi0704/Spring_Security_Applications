package com.springsecuritydb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.springsecuritydb.model.Customer;
import com.springsecuritydb.repository.CustomerRepository;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	private CustomerRepository customerRepo; 
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		
		System.out.println("Inside the Custom Authentication Provider");
		
		String username = authentication.getName();
		
		String pwd = authentication.getCredentials().toString();
		
		Optional<Customer> opt = customerRepo.findByEmail(username);
		
		if(opt.isPresent()) {
			throw new BadCredentialsException("No User registered with this details");
		}
		else {
			Customer customer = opt.get();
			if(passwordEncoder.matches(pwd, customer.getPassword())) {
				List<GrantedAuthority> authorities = new ArrayList<>();
				//authorities.add(new SimpleGrantedAuthority(customer.getRole()));
				
				return new UsernamePasswordAuthenticationToken(username,pwd,authorities);
			}else {
				throw new BadCredentialsException("Invalid Password");
				
			}
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
