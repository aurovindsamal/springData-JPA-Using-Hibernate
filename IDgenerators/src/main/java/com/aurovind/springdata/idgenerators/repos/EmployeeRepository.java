package com.aurovind.springdata.idgenerators.repos;

import org.springframework.data.repository.CrudRepository;

import com.aurovind.springdata.idgenerators.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
