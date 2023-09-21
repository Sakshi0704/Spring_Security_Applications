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
 * 
 * Also Used Swagger dependance and to Test and RESTApi documnetation we use to create Swagger
 *  if we want to use Swagger on RestApi which also using spring security then we have to so some configuration also
 *  first - permit the all end point related to swagger
 *  second - use annotation in the @SpringBootApplication have to done some configuration 
 *  like @OpenAPIDefinition (for using the open api) and SecuritySchemes and so on 
 *  which give the idea about project
 *  
 * */
