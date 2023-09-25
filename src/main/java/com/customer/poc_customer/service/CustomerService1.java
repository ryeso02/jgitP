package com.customer.poc_customer.service;

public
package com.customer.poc_customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.poc_customer.entity.CustomerEntity;
import com.customer.poc_customer.repository.CustomerRepository;

@Service
public class CustomerService {

   private final CustomerRepository customerRepo;

   @Autowired
   public CustomerService(CustomerRepository customerRepo) {
       this.customerRepo = customerRepo;
   }

   public CustomerEntity createCustomer1(CustomerEntity customer) {
       return customerRepo.save(customer);
   }
   
   public CustomerResponseDTO createCustomer(CustomerEntity customer) {
       CustomerEntity savedCustomer = customerRepository.save(customer);
       String message = "Customer created successfully";
       
       // Create and return the DTO
       CustomerResponseDTO responseDTO = new CustomerResponseDTO();
       responseDTO.setMessage(message);
       responseDTO.setCustomer(savedCustomer);
       
       return responseDTO;
   }

   // You can add more methods for fetching, updating, or deleting customers if needed
}

{

}
