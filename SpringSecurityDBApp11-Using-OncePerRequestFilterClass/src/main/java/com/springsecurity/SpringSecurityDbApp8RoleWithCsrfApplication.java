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
 * Apart from implementing the Filter interface, there are some another advance concepts
are available when we try to implement a custom filter in Spring Security.
1. Using GenericFilterBean class.
2. Using OncePerRequestFilter class
GenericFilterBean:
It is the simple implementation of Filter interface by the Spring Security framework. It is
an abstract class
The main advantage with this class is, it is going to provide all the details of our config
parameters, init parameters, and the ServletContext parameters which we have
configured inside the Servlet configuration file i.e. web.xml, so inside our custom filter if
we want all the details of our init, config, context parameters then we can use this
abstract class.
OncePerRequestFilter:
It is the child class of GenericFilterBean class.
It is also an abstract class
Whenever we create our custom filter, by default the Spring Security framework can not
guarantee that it will execute only one time per request.
There might be scenario, where our servlet container can invoke the same filter multiple
times for various reasons. for example, One servlet may forward the request to another
servlet and the same filter is configured with both the filters.

But if we want to make sure that our custom filter needs to be executed only once per
request at any cost, then we should define our custom filter by extending this abstract
class.
In this filter, inside doFilter(-,-,-) method, it is already mentioned that if our custom filter
is already executed or not, if it is already executed then it simply call the
chain.doFilter(-,-,-) by skipping our custom filter.


In this case we need to write our filtering logic by overriding an abstract method called:

abstract void doFilterInternal(HttpServletRequest request,
 HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException


Inside this OncePerRequestFilter class there is a another method called boolean
shouldNotFilter() where we can define the logic to our custom filter should not
executed for some API path.
Note: the BasicAuthenticationFilter, internally extends this OncePerRequestFilter class
 * 
 * */
 