package com.springsecurity.configuration;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain springSecurityConfiguration(HttpSecurity http) throws Exception{
		
		http.cors(cors -> {
			
			// if you are using front to access api from the backed application and that is using security 
			// then it is compulsory to add this cross origin configuration then only writing @CrossOrigin annotation will not work at all
			cors.configurationSource(new CorsConfigurationSource() {

				@Override
				public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
					
					CorsConfiguration cfg = new CorsConfiguration();
					
					cfg.setAllowedOriginPatterns(Collections.singletonList("*")); // ("//http://localhost:8800") instead ("*") this if we have specific domain
					cfg.setAllowedMethods(Collections.singletonList("*")); // "GET,PUT,POST,PATCH"
					cfg.setAllowCredentials(true);   // username , password
					cfg.setAllowedHeaders(Collections.singletonList("*"));  // any kind header
					cfg.setExposedHeaders(Arrays.asList("Authorization"));  // any new header can we send through backend like jwtToken , csrfToken to the frontend
					
					return cfg;
				}
				});
			
		}).
		authorizeHttpRequests(auth -> {
			auth
			  .requestMatchers(HttpMethod.POST, "/customers").permitAll()
			  .requestMatchers(HttpMethod.GET,"/customers","/hello").hasRole("ADMIN")
			  .requestMatchers(HttpMethod.GET ,"/customers/**").hasAnyRole("ADMIN","USER") 
			  // what is ** is showing PathVeriable -----
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
