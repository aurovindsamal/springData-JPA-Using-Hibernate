package com.aurovind.springdata.jpaAssociations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.aurovind.springdata.jpaAssociations.entities.Customer;
import com.aurovind.springdata.jpaAssociations.entities.PhoneNumber;
import com.aurovind.springdata.jpaAssociations.manytomany.entities.Programmer;
import com.aurovind.springdata.jpaAssociations.manytomany.entities.Project;
import com.aurovind.springdata.jpaAssociations.manytomany.repos.MayToManyRepository;
import com.aurovind.springdata.jpaAssociations.repos.CustomerRepository;

@SpringBootTest
class JpaAssociationsApplicationTests {
	
	@Autowired
	CustomerRepository customerrepository;
	
	@Autowired
	MayToManyRepository manytomanyrepos;
	
	

	@Test
	@Transactional
	void contextLoads() {
	}
	
	void testCreate() {
		Customer customer = new Customer();
		customer.setName("aurovind");
		
		List<PhoneNumber> list = new ArrayList<>();
		PhoneNumber pn1= new PhoneNumber();
		pn1.setType("landline");
		pn1.setPhoneNumber("1234");
		
		PhoneNumber pn2 = new PhoneNumber();
		pn2.setType("mobile");
		pn2.setPhoneNumber("98614");
		
		list.add(pn1);
		list.add(pn2);
		
		customer.setNumbers(list);
		
		customerrepository.save(customer);
		
		//with these the foreign key value is not updated with the primary key of the parent table . 
		//This can be achieved my setting the value
		Customer newcustomer = new Customer();
		newcustomer.setName("aurovind");
		
		List<PhoneNumber> listnew = new ArrayList<>();
		PhoneNumber pn1new= new PhoneNumber();
		pn1new.setType("landline");
		pn1new.setPhoneNumber("1234");
		pn1new.setCustomer(newcustomer);
		
		PhoneNumber pn2new = new PhoneNumber();
		pn2new.setType("mobile");
		pn2new.setPhoneNumber("98614");
		pn2new.setCustomer(newcustomer);
		
		listnew.add(pn1);
		listnew.add(pn2);
		
		newcustomer.setNumbers(listnew);
		newcustomer.setId(1L);
		
		customerrepository.save(newcustomer);
		
		
		//better way of doing the above approach 
		Customer newcustomerBetter = new Customer();
		newcustomerBetter.setName("aurovind");
		
		PhoneNumber pn1better= new PhoneNumber();
		pn1new.setType("landline");
		pn1new.setPhoneNumber("1234");
		
		PhoneNumber pn2better = new PhoneNumber();
		pn2new.setType("mobile");
		pn2new.setPhoneNumber("98614");
		
		newcustomerBetter.addPhoneNumber(pn1better);
		newcustomerBetter.addPhoneNumber(pn2better);
		
		customerrepository.save(newcustomerBetter);
		
		
		
		//testLoad object
		Customer retrieve = customerrepository.findById(1L).get();
		List<PhoneNumber> retnums = retrieve.getNumbers();
		System.out.println(retrieve.getName());
		retnums.forEach(n->System.out.println(n.getPhoneNumber()));
		
		//testUpdateObject
		Customer update = customerrepository.findById(1L).get();
		update.setName("Updating");
		
		List<PhoneNumber> updateNums = update.getNumbers();
		updateNums.forEach(p->p.setType("mobile"));
		
		customerrepository.save(update);
		
		
		
		
	}
	
	@Test
	public void testDelete() {
		customerrepository.deleteById(1L);
		//it deletes from child table and then the parent table
		
	}
	
	@Test
	public void testManyToMany() {
		Programmer programmer = new Programmer();
		programmer.setName("MAC BOOK PRO");
		programmer.setSalary(10000);
		
		
		Set<Project> hashSet = new HashSet<Project>();
		Project project = new Project();
		project.setProjectName("marketo");
		
		Project project1= new Project();
		project1.setProjectName("mars");
		
		hashSet.add(project);
		hashSet.add(project1);
		
		programmer.setProjects(hashSet);
		manytomanyrepos.save(programmer);
		
	}
	
	
	@Test
	@Transactional
	public void retrieve() {
		Programmer programmer = manytomanyrepos.findById(1).get();
		System.out.println(programmer);
		System.out.println(programmer.getProjects());
		
		
	}
	

}
