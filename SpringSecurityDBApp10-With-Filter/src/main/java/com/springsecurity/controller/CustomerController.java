package com.springsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.exception.CustomerException;
import com.springsecurity.model.Customer;
import com.springsecurity.service.CustomerService;

@RestController
//@RequestMapping("/jpa")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	//http://localhost:8088/swagger-ui/index.html#/ --> use this url while using swagger
	@GetMapping("/hello") //http://localhost:8082/hello
	public String testHandler() {
		return "Welcome to Spring Security";
	}
	
	//add this Customer with two authorities
	
	/*  
		{
			"name" : "Ram",
			"email" : "ram@gmail.com",
			"password" : "1234",
			"address" : "Delhi",
			"role" : "admin"
		}
	*/
	
	// add also another Customer with only one authority "user"
	
	// to register any customer...
	@PostMapping("/customers")  //http://localhost:8082/customers
	public ResponseEntity<Customer> saveCustomerHandler(@RequestBody Customer customer){
		
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		
		customer.setRole("ROLE_"+customer.getRole().toUpperCase());
		
		Customer registeredCustomer = customerService.registerCustomer(customer);
		
		return new ResponseEntity<>(registeredCustomer,HttpStatus.ACCEPTED);
		
	}
	
	
	@GetMapping("/customers/{email}") //http://localhost:8082/customers/ravi@gmail.com
	public ResponseEntity<Customer> getCustomerByEmailHandler(@PathVariable("email") String email) throws CustomerException{
		Customer customer = customerService.getCustomerDetailsByEmail(email);
		
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	
	@GetMapping("/customers") //http://localhost:8082/customers
	public ResponseEntity<List<Customer>> getAllCustomerHandler() throws CustomerException{
		List<Customer> customers = customerService.getAllCustomerDetails();
		return new ResponseEntity<>(customers,HttpStatus.OK);
	}
	
	@GetMapping("/signIn") //http://localhost:8082/signIn
	public ResponseEntity<String> getLoggedInCustomerDetailsHandler(Authentication auth) throws CustomerException{
		
		System.out.println(auth); // this Authentication object having Principle object details
		
		Customer customer = customerService.getCustomerDetailsByEmail(auth.getName());
		
		/*===== Or =====*/
			
		// because after the filter and after verify this principle 
		// object is given and then this end-point get able to call 
		
		// there are two way to send username and password.
		// first --> throw RequestBody which is not recommended because of password security purpose.
		// second --> throw spring security flow --> throw Hander as Basic Authentication recommend way.
		
		// Once username and password was given throw the handler then spring security filters do their tasks
		// and after authenticate that object along with checking the autherity of user
		// then it will allow this api to get call.... 
		// so because of that we can say this Authentication object also have principle object 
		// which is store in spring context after authenticated the respective user
				
		return new ResponseEntity<>(customer.getName() + " Logged In Successfully", HttpStatus.ACCEPTED);
	}

	@PostMapping("/contact")
	public String postDemo1() {
		return "Not harmfull POST operation";
	}
	
	
	@PutMapping("/notice")
	public String putDemo1() {
		return "Not harmfull PUT operation";
	}
	
	@PostMapping("/writeUs")
	public String postDemo3() {
		return "It is harmfull POST operation";
	}
	
}
