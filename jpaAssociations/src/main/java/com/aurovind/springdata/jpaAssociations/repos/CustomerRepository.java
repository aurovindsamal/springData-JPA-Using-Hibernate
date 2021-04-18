package com.aurovind.springdata.jpaAssociations.repos;

import org.springframework.data.repository.CrudRepository;

import com.aurovind.springdata.jpaAssociations.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
	

}
