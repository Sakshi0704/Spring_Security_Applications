package com.springsecuritydb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain springSecurityCongiguration(HttpSecurity http) throws Exception{
	
		http.authorizeHttpRequests(auth -> {
			auth.requestMatchers(HttpMethod.POST, "jpa/customers").permitAll()
			.anyRequest().authenticated();
			
		})
		.csrf(csrf -> csrf.disable())
		.formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); 
		// this is one of the hashing technique and recommendated one
	}
}
/*Writing the securityFilterChain which help us to deal with authrizes */