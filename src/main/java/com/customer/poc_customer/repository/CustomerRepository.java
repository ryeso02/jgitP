package com.customer.poc_customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.poc_customer.entity.CustomerEntity;

@Repository
public interface CustomerRepository  extends JpaRepository<CustomerEntity, Long>
{

}
