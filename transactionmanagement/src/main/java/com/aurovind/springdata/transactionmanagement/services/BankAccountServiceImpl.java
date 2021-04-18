package com.aurovind.springdata.transactionmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aurovind.springdata.transactionmanagement.entity.BankAccount;
import com.aurovind.springdata.transactionmanagement.repos.BankAccountRepository;

@Service
public class BankAccountServiceImpl implements BankAccountService {
	
//	@Autowired
//	BankAccountService bankAccountService;
	
	@Autowired
	BankAccountRepository bankAccountRepository;

	@Override
	@Transactional
	public void transfer(int amount) {
		// TODO Auto-generated method stub
		
		BankAccount obama = bankAccountRepository.findById(1).get();
		obama.setAccno(obama.getBalance()+amount);
		bankAccountRepository.save(obama);
		
		if(true) {
			throw new RuntimeException();
		}
		
		//if it throws runtime exception then the changes are rolled back and its not committed . 
		//Below will not execute if the any exception happens 
		
		@SuppressWarnings("unused")
		BankAccount trump = bankAccountRepository.findById(2).get();
		trump.setBalance(trump.getBalance()-amount);
		bankAccountRepository.save(trump);

	}

}
