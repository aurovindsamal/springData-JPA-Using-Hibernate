package com.aurovind.springdata.componentmapping;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.aurovind.springdata.componentmapping.entity.Address;
import com.aurovind.springdata.componentmapping.entity.Employee;
import com.aurovind.springdata.componentmapping.repos.EmployeeRepository;

@SpringBootTest
class ComponentmappingApplicationTests {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}
	
	void testCreate() {
		Address address = new Address();
		address.setCity("Bhubaneswar");
		address.setCountry("india");
		address.setState("Odisha");
		address.setStateAddress("Inside");
		address.setZipcode("751016");
		
		Employee employee = new Employee();
		employee.setName("aurovind samal");
		employee.setAddress(address);
		
		employeeRepository.save(employee);
		
	}

}
