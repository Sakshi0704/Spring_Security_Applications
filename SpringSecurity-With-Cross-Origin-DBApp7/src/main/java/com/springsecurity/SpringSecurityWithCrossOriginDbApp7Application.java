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
 * */
