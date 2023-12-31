 package com.springsecurity.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecurity.model.Authority;
import com.springsecurity.model.Customer;
import com.springsecurity.repository.CustomerRepository;

@Service
public class CustomerUserDetailsService implements UserDetailsService{

	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
			
		Optional<Customer> opt = customerRepo.findByEmail(username);
		
		 if(opt.isPresent()) {
			 Customer customer = opt.get();
		
			// Empty Authorities
			 List<GrantedAuthority> authorities = new ArrayList<>();
			 for(Authority auth : customer.getAuthorities()) {
				 authorities.add(new SimpleGrantedAuthority(auth.getName())); 
			 }
		      return new User(customer.getEmail(), customer.getPassword(), authorities);
//return new User(customer.getEmail(),customer.getPassword(), getGrantedAuthorities(customer.getAuthorities()));
		      
		 }else {
			 throw new BadCredentialsException("User Details not found with this username : "+ username);
		 }

	}
/*	
	public List<GrantedAuthority> getGrantedAuthorities(List<Authority> authorities){
		
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		for(Authority authority : authorities) {
			grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
		}
		return grantedAuthorities;
	}
	
*/
	
}
