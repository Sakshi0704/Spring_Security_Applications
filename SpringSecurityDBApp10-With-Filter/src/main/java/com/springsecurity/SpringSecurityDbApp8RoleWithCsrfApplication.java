package com.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity(debug = true) // if we want to check the 
        						// register filters inside 
								//the Spring Security by using following configuration
public class SpringSecurityDbApp8RoleWithCsrfApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDbApp8RoleWithCsrfApplication.class, args);
	}

}


/*
 *1) make the csrf filter disable in spring security ( or either create filter for csrf
 *	while login any user then genrate the xsrf token in response and then in every request 
 *  take the xsrf token from hearder and send back xsrf new token throw header...
 *  
 *2) in the application creating the one filter RequestValidationFilter and used that filter 
 *	 in filter chain in respected provided order..
 *	creating class RequestValidationFilter.java
 *	then used one like addFilterAfter(-,-) in SecurityConfig.java class
 *
 *3) used the debuger to check how many filters are register
 *	first add the annotation @EnableWebSecurity(debug = true) above the main root class 
 *	second add one line on application.properties file the log 
 *		logging.level.org.springframework.security.web.FilterChainProxy = DEBUG
 *	# used to check all spring security filter on console while any user login himself
 *
 * */
 