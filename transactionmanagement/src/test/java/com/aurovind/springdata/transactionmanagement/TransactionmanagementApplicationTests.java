package com.aurovind.springdata.transactionmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.aurovind.springdata.transactionmanagement.services.BankAccountService;

@SpringBootTest
class TransactionmanagementApplicationTests {

	@Autowired
	BankAccountService bankAccountService;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testTransfer() {
		bankAccountService.transfer(500);
	}
	
	

}
