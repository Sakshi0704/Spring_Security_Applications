package com.springsecuritydb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecuritydb.exception.CustomerException;
import com.springsecuritydb.model.Customer;
import com.springsecuritydb.service.CustomerService;


/*
 * GET /hello : to test the api should be called only logged-in user (Protected)
 * POST /customers : to register any customer (any one should call this API) (Non-Protected)
 * GET /customers/email : to get any customer details based on their email (Protected)
 * GET /customers : to get all the customer details (Protected)
 * GET /signIn : to login a customer by passing their credentials and getting the authentication message.
 * */

@RestController // @RestController -> @Controller + @ResponseBody
@RequestMapping("/jpa") // universal end point for this controller
public class HelperController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@GetMapping("/hello") //http://localhost:8088/hello
	public String testHandler() {
		return "Welcome to Spring Security";
	}
	
	@PostMapping("/customers") //http://localhost:8088/jpa/customers
	public ResponseEntity<Customer> saveCustomerHandler(@RequestBody Customer customer){
		
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		
		Customer registeredCustomer = customerService.registerCustomer(customer);
		
		return new ResponseEntity<Customer>(registeredCustomer, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/customers/{email}") //http://localhost:8088/jpa/customers/ravi@gmail.com
	public ResponseEntity<Customer> getCustomerByEmailHandler(@PathVariable("email") String email) throws CustomerException{
		Customer customer = customerService.getCustomerDetailsByEmail(email);
		
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	
	@GetMapping("/customers") //http://localhost:8088/jpa/customers
	public ResponseEntity<List<Customer>> getAllCustomerHandler() throws CustomerException{
		List<Customer> customers = customerService.getAllCustomerDetails();
		return new ResponseEntity<>(customers,HttpStatus.OK);
	}
	
	@GetMapping("/signIn") //http://localhost:8088/jpa/signIn
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
	
}
