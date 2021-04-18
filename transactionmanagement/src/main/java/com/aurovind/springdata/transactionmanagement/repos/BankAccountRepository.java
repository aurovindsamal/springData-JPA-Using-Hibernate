package com.aurovind.springdata.transactionmanagement.repos;

import org.springframework.data.repository.CrudRepository;

import com.aurovind.springdata.transactionmanagement.entity.BankAccount;

public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {

}
