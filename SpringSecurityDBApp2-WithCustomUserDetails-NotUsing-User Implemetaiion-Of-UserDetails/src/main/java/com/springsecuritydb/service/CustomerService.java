package com.springsecuritydb.service;

import java.util.List;
import java.util.Optional;

import com.springsecuritydb.exception.CustomerException;
import com.springsecuritydb.model.Customer;

public interface CustomerService {

	public Customer registerCustomer(Customer customer);
	
	public Customer getCustomerDetailsByEmail(String email) throws CustomerException;
	
	public List<Customer> getAllCustomerDetails() throws CustomerException;
	
}
