package com.springsecurity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain springSecurityConfiguration(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(auth -> {
			auth
			  .requestMatchers(HttpMethod.POST, "/customers").permitAll()
			  .requestMatchers(HttpMethod.GET,"/customers","/hello").hasRole("ADMIN")
			  .requestMatchers(HttpMethod.GET ,"/customers/**").hasAnyRole("ADMIN","USER") 
			  // what is ** is showing PathVeriable -----
			  .anyRequest().authenticated();
		}).csrf(csrf -> csrf.disable())
		.addFilterBefore(new RequestValidationFilter(), BasicAuthenticationFilter.class)
		.formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		// this is one of the hashing technique and recommendated one
		return new BCryptPasswordEncoder(); 
	}
	
}
