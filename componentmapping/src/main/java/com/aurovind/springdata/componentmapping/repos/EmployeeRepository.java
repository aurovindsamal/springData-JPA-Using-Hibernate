package com.aurovind.springdata.componentmapping.repos;

import org.springframework.data.repository.CrudRepository;

import com.aurovind.springdata.componentmapping.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
