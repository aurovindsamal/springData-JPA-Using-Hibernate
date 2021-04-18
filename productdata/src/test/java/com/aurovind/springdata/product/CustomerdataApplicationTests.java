package com.aurovind.springdata.product;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.aurovind.springdata.product.entities.Customer;
import com.aurovind.springdata.product.repos.CustomerRepository;


@SpringBootTest
class CustomerdataApplicationTests {
	
	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testCreateProduct(){
		
		Customer customer = new Customer();
		customer.setId(1);
		customer.setName("First Product");
		customer.setEmail("aurovind3061@gmail.com");
		
		customerRepository.save(customer);

	}
	
	@Test
	public void testRead() {
		Customer customer = new Customer();
		customer.setId(1);
		customer.setName("First Customer");
		customer.setEmail("aurovind3061@gmail.com");
		
		customerRepository.save(customer);
		
		Customer retrievecustomer = customerRepository.findById(1).get();
		System.out.println("Retrieve Customer " +retrievecustomer.getName());
		
	}
	
	@Test
	public void testUpdate() {
		Customer customer = new Customer();
		customer.setId(1);
		customer.setName("First Customer");
		customer.setEmail("aurovind3061@gmail.com");
		
		customerRepository.save(customer);
		
		Customer retrievecustomer = customerRepository.findById(1).get();
		retrievecustomer.setEmail("amlansamal98@gmail.com");
		
		customerRepository.save(retrievecustomer);
		
		Customer retrievecustomersecond = customerRepository.findById(1).get();
		assertEquals(retrievecustomersecond.getEmail(), "amlansamal98@gmail.com");
		
	}
	
	@Test
	public void testDelete() {
		Customer customer = new Customer();
		customer.setId(1);
		customer.setName("First Customer");
		customer.setEmail("aurovind3061@gmail.com");
		
		customerRepository.save(customer);
		
		if(customerRepository.existsById(1)) {
			System.out.println("Deelting the customer");
			customerRepository.delete(customer);
		}
	}

	
	@Test
	public void testCount() {
		Customer customer = new Customer();
		customer.setId(1);
		customer.setName("First Customer");
		customer.setEmail("aurovind3061@gmail.com");
		
		Customer customer1 = new Customer();
		customer1.setId(2);
		customer1.setName("Second Customer");
		customer1.setEmail("amlan@gmail.com");
		
		
		customerRepository.save(customer);
		customerRepository.save(customer1);
		
		assertEquals(customerRepository.count(), 2);
		
		
	}
		
}
