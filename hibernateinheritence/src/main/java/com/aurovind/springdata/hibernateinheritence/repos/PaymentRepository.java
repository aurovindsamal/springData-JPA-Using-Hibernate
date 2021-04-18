package com.aurovind.springdata.hibernateinheritence.repos;

import org.springframework.data.repository.CrudRepository;

import com.aurovind.springdata.hibernateinheritence.entities.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
