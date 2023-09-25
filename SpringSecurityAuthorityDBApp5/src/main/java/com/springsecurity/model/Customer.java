package com.springsecurity.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer custId;
	
	
	private String name;
	
	@Column(unique = true)
	private String email;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	private String address;
	
	
	// by default fetchtype is lazy... but we want that when customer details loaded at the same 
	// time second level object is also loaded...
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer" , fetch = FetchType.EAGER)
	private List<Authority> authorities = new ArrayList<>();
	
	//getters & setters
}
