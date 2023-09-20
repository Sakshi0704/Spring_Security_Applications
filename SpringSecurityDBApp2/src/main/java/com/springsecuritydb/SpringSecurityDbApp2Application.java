package com.springsecuritydb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityDbApp2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDbApp2Application.class, args);
	}

}

/*
 * In this application I have provided the cutome UserDetails interface implementation 
 * 
 * UserDetails (Interface) ----> CustomerUserDetails (Implementation)(provided by us) ( created this one in this application )
 * 
 * UserDetails (Interface) ---> User (Implementation) (provided in Spring Security) 
 * */
 