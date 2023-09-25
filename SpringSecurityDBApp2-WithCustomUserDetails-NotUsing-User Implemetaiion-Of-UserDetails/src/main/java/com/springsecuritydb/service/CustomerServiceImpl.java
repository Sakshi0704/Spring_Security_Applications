package com.springsecuritydb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecuritydb.exception.CustomerException;
import com.springsecuritydb.model.Customer;
import com.springsecuritydb.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		return customerRepository.save(customer);
	}

	@Override
	public Customer getCustomerDetailsByEmail(String email) throws CustomerException {
		// TODO Auto-generated method stub
		Customer customer = customerRepository.findByEmail(email).orElseThrow(() -> new CustomerException("Customer not found with this email"));
		return customer;
	}

	@Override
	public List<Customer> getAllCustomerDetails() throws CustomerException {
		// TODO Auto-generated method stub
		
		List<Customer> customers = customerRepository.findAll();
		
		if(customers.isEmpty()) {
			throw new CustomerException("No Customer Find");
		}
		
		return customers;
	}
	
	
	
	
	
}
