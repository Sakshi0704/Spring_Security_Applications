package com.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityInMemoryApp4UsingRequestBodyAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityInMemoryApp4UsingRequestBodyAuthenticationApplication.class, args);
	}

}

/*
 * this application is created for the reason when client used to give username and password
 * through RequestBody which is not recommended for the security purpose
 * But this application used to show how we can take username and password to authenticate user
 * through RequestBody....
 * 
 * */
