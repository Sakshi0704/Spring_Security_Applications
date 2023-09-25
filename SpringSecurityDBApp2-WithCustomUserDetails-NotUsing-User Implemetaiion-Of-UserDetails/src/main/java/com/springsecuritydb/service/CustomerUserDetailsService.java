package com.springsecuritydb.service;

import com.springsecuritydb.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecuritydb.repository.CustomerRepository;

@Service
public class CustomerUserDetailsService implements UserDetailsService{
// InMemoryUserDetailManager is the pre-defined implementation class of UserDetailsService
	
// In UserDetailsService we have one method loadUserByUserName(String username) 
// which provide you UserDetails and 
// spring-security provide us pre-defined implementation of UserDetails(interface)
// which is User class implementing UserDetails interface...


// here we have provide custom CustomerUserDetailsService implementation class of UserDetailsService
// and using CustomerUserDetails class implementation of UserDetails interface which is provided by us.

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		 Optional<Customer> opt = customerRepository.findByEmail(username);
		
		 if(opt.isPresent()) {
			 Customer customer = opt.get();
		
			// Empty Authorities
			 List<GrantedAuthority> authorities = new ArrayList<>();
			 // authorities.add(new SimpleGrantedAuthority(Customer.getRole());
			 
			//return new User(customer.getEmail(), customer.getPassword(), authorities);
			
			 return new CustomerUserDetails(customer);
			 
		 }else {
			 throw new BadCredentialsException("User Details not found with this username : "+ username); 
		 }
	}
}
