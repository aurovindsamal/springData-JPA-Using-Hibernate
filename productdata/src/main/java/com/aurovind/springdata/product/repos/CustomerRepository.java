package com.aurovind.springdata.product.repos;

import org.springframework.data.repository.CrudRepository;

import com.aurovind.springdata.product.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
