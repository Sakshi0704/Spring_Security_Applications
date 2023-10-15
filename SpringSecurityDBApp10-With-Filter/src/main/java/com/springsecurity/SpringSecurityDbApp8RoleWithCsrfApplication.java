package com.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityDbApp8RoleWithCsrfApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDbApp8RoleWithCsrfApplication.class, args);
	}

}


/*
 * Way to ignoring csrf security on some http methods post or put request 
 * and make those request white list
 * 
 *  but should should be activate csrf security on some http methods post or put
 *  
 *   
 *   so in that case we can not use disable approach. --> csrf(csrf -> csrf.disable()) this one not recommendated also
 * 
 *  So in that we can tell spring security to some public API to not apply csrf protection by default.
 *  
 *  
 *  => .csrf(csrf->csrf.ignoringRequestMatchers("/notice","/contact","/customers"));
 *     			// here you can class notice, contact, customers 
 *		        //but not writeUs even if you authenticate yourself for csrf protection
 *
 *
 * => So to above problem we have to implement proper CSRF token solution inside our application
 * 
 * */
 