package com.springsecuritydb.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.springsecuritydb.model.Customer;

/*
* UserDetails (Interface) ----> CustomerUserDetails (Implementation)(provided by us) ( created this one in this application )
* 
* UserDetails (Interface) ---> User (Implementation) (provided in Spring Security) 
* */


public class CustomerUserDetails implements UserDetails{

	private Customer customer;
	
	public CustomerUserDetails(Customer customer) {
		this.customer = customer;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		//List<Authority> auths = customer.getAuthorities();
		
		// for(Authority auth : auths) {
			// SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGentedAuthority(auth.getName());
			// authorities.add(simpleGrantedAuthority);
		// }
		
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return customer.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return customer.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
