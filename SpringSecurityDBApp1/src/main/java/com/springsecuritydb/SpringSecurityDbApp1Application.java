package com.springsecuritydb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //@Configration + @EnableAutoConfigration + @ComponentScanner
public class SpringSecurityDbApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDbApp1Application.class, args);
	}

}


/*
 * This RESTapi web service application is domestrate the spring-security filters like
 * 1. developing some end - points 
 * 
 * 
 * 4. providing the custom implementation CustomerUserDetailsService of UserDetailsService
 * Which have already pre-defined implementation provided by spring-security
 * like InMemoryUserDetailsManager class implementation of UserDetailsService
 * this service have one method loadUserByUsername abstruct method which called in AuthenticationProvider implementation classes
 * as AuthenticationProvider ----> connect with ----> UserDetailsService ---> to get UserDetails Object through InMemory or through database
 *  
 *  UserDetails is the interface and it's implementation User which pre-created by spring-security
 *  
 *  Used --> 
 *     UserDetailsService custom implementation CustomerUserDetailsService
 *     UseerDetails pre-defined implementation class User by spring-security
 *     SecurityConfg to configure SecurityFilterChain and PasswordEncoder --> use BCryptPasswordEncoder
 *     
 *  */
 