package com.aurovind.springdata.hibernateinheritence;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.aurovind.springdata.hibernateinheritence.entities.Check;
import com.aurovind.springdata.hibernateinheritence.entities.CreditCard;
import com.aurovind.springdata.hibernateinheritence.repos.PaymentRepository;

@SpringBootTest
class HibernateinheritenceApplicationTests {

	@Autowired
	PaymentRepository paymentRepository;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void testCreateCheck() {
		Check check = new Check();
		check.setId(123);
		check.setCheckNumber("123456");
		check.setAmount(3000);
		paymentRepository.save(check);
	}
	
	//When we run above test we see 2 insert statements. One into Payment and other into Check . Happens only in Join Strategy
	
	@Test
	void testCreateCreditCard() {
		CreditCard cc = new CreditCard();
		cc.setId(123);
		cc.setCreditCardNumber("123654");
		cc.setAmount(3000);
		paymentRepository.save(cc);
	}

}
