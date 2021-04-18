package com.aurovind.springdata.idgenerators;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.aurovind.springdata.idgenerators.entity.Employee;
import com.aurovind.springdata.idgenerators.repos.EmployeeRepository;

@SpringBootTest
class IDgeneratorsApplicationTests {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testCreate() {
		Employee employee = new Employee();
		employee.setName("Aurovind Samal");
		
		employeeRepository.save(employee);
		assertEquals(employee.getName(), "Aurovind Samal");
		
		Iterable<Employee> emp = employeeRepository.findAll();
		
		List employeeArray = new ArrayList();
		emp.forEach(e -> employeeArray.add(e));
		
		System.out.println("Employee Records" +employeeArray);
		
		
		
	}

}
