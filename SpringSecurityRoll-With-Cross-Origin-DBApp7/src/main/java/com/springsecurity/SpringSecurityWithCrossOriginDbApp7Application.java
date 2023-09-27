package com.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityWithCrossOriginDbApp7Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityWithCrossOriginDbApp7Application.class, args);
	}

}

/*
 * Cross-Origin resource sharing ---> make it available to access the api throw any frontend..
 * 
 * web can access api through different domain while it's self running in different domain 
 * this problem only comes when any front-end try to access api of one web-service
 * 
 * but it does not occur if any another web-service is using another web-service api..
 * 
 * 
 * there are multiple ways to do so----
 *  1)  @CrossOrigin(origins = "http://localhost:4200") 
 *  			// to any specific domain can access this
 *  
 *  2)  @CrossOrigin(origins = "*") 
 *  		// any domain on which front is running can access these api of any specific controller
 *  
 *  3) Better and recommended way is configure is spring - filter means in SecurityConfig 
 *     if we are using spring-security
 *  	if not then through any configuration file with proper cross configuration...
 *  		// When you want to access all controllers and enable from cross - origin...
 *  
 *  
 *  Note : -
			* if you are using front to access api from the backed application and 
			* that is using security 
			* then it is compulsory to add this cross origin configuration 
			 * then only writing @CrossOrigin annotation will not work at all
 * 
 * */
