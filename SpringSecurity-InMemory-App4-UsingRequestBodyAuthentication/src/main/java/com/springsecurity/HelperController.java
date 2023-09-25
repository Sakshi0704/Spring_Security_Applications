package com.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class HelperController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/hello1")
	public String sayHello1() {
		return "Welcome1";
	}
	
	
	@GetMapping("/hello2")
	public String sayHello2() {
		return "Welcome2";
	}
	
	@PostMapping("/signIn")
	public String loginHanlder(@RequestBody LoginBean loginBean , HttpServletRequest req) {
	
		try {
			
			Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginBean.getUsername(),loginBean.getPassword()));
			

           // going to store this Authentication Object in SecurityContext for so in the further interaction of http request urls
			//we don't need to again the username and password.....	
			SecurityContext sc = SecurityContextHolder.getContext();
			sc.setAuthentication(auth);
			
			
			// In older version of the spring - security we can't not configure 
			//Session but in latest version of spring-security we can pass the jsonsession id...
			HttpSession session = req.getSession(true);
			session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,sc);
			
			return "Authentication Successfull";
		}catch(Exception e) {
			return "Authentication Fails";
		}	
	}
}
