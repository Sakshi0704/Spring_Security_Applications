package com.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityDbApp9RoleWithCsrfTokenApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDbApp9RoleWithCsrfTokenApplication.class, args);
	}

}

/* 
 * Let's implements proper CSRF token solution inside our application
 * 
 * In this when we call any request
 *    we get two cookies -> 1) JSESSIONID 2) XSRF-TOKEN
 *    
 *  So now when we are sending the http request - POST and PUT
 *     Then in Header of the http-Request in Headers we have to send as well as
 *        X-XSRF-TOKEN which going to have same token which is given by web-server application
 *         in the XSRF-TOKEN
 *         so means front-language will reander this token then assign to X-XSRF-TOKEN
 * 
 * */
 