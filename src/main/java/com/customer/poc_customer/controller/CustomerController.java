package com.customer.poc_customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.poc_customer.entity.CustomerEntity;
import com.customer.poc_customer.repository.CustomerRepository;


@RestController
public class CustomerController {
	
	@Autowired 
	private CustomerRepository customerRepo;
	
	  @GetMapping("/customer")
	  public String Demo() {
		  System.out.println("working");
		return  "welcome";	
	  } 
	  
	  @GetMapping("/customerDetails")
	  public List<CustomerEntity> getDetails() {
		  return customerRepo.findAll();
	  }
	  
	  @PostMapping("/addCustomer")
	  public ResponseEntity<?> createCustomer(@RequestBody CustomerEntity customer) {
		  if(customer.getName()==null) {
			  System.out.println("------------------HELO--------------------");
		  }else {
			  try {
				  CustomerEntity savedCustomer = customerRepo.save(customer);
				  return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
			  } catch (Exception e) {
				  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			  }
		  }
		  
		  return null;
	  }

	  
	  @DeleteMapping("/deletecustomer/{customerId}")
	    public ResponseEntity<String> deleteCustomer(@PathVariable Long customerId) {
	        try {
	            customerRepo.deleteById(customerId);
	            return ResponseEntity.ok("Customer deleted with ID: " + customerId);
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().body("Failed to delete customer: " + e.getMessage());
	        }
	    }

}
