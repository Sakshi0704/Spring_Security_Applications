package com.springsecuritydb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.security.SecuritySchemes;
import io.swagger.v3.oas.annotations.servers.Server;



@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "REST API", version = "1.1"),
	security = {
		@SecurityRequirement(name = "basicAuth"),
		@SecurityRequirement(name = "bearerToken")
		},
	servers = {
		@Server(url = "/", description = "Default Server URL")
	    	}
)
@SecuritySchemes({
@SecurityScheme(name = "basicAuth", type = SecuritySchemeType.HTTP, scheme = "basic"),
@SecurityScheme(name = "bearerToken", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "JWT")
})
public class SpringSecurityDbApp2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDbApp2Application.class, args);
		// Sakshi Choudhary
		// Write one more thing again 
	
	}
}
/*
 * In this application I have provided the cutome UserDetails interface
 * implementation
 * 
 * UserDetails (Interface) ----> CustomerUserDetails (Implementation)(provided
 * by us) ( created this one in this application )
 * 
 * UserDetails (Interface) ---> User (Implementation) (provided in Spring
 * Security)
 * 
 * Also Used Swagger dependance and to Test and RESTApi documnetation we use to
 * create Swagger if we want to use Swagger on RestApi which also using spring
 * security then we have to so some configuration also first - permit the all
 * end point related to swagger second - use annotation in
 * the @SpringBootApplication have to done some configuration
 * like @OpenAPIDefinition (for using the open api) and SecuritySchemes and so
 * on which give the idea about project
 * 
 * 
 * 1. for getting json documentation: /v3/api-docs/ 2. for getting ui
 * documentation: /swagger-ui.html
 * //http://localhost:8888/swagger-ui/index.html#
 * 
 * 
 * To apply swagger on Spring boot application with Spring Security and JWT:
 * ============================================================
 * 
 * to the main class apply the following annotation:
 * ------------------------------------------------------------
 * 
 * @OpenAPIDefinition(info = @Info(title = "REST API", version = "1.1"),
 * security = {
 * 
 * @SecurityRequirement(name = "basicAuth"),
 * 
 * @SecurityRequirement(name = "bearerToken") }, servers = {
 * 
 * @Server(url = "/", description = "Default Server URL") } )
 * 
 * @SecuritySchemes({
 * 
 * @SecurityScheme(name = "basicAuth", type = SecuritySchemeType.HTTP, scheme =
 * "basic"),
 * 
 * @SecurityScheme(name = "bearerToken", type = SecuritySchemeType.HTTP, scheme
 * = "bearer", bearerFormat = "JWT") }) public class
 * SpringjwtswaggerappApplication {
 * 
 * 
 * public static void main(String[] args) {
 * SpringApplication.run(SpringjwtswaggerappApplication.class, args); }
 * 
 * }
 * 
 */
