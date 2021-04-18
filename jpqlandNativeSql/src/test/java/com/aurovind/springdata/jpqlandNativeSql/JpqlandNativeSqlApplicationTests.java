package com.aurovind.springdata.jpqlandNativeSql;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;

import com.aurovind.springdata.jpqlandNativeSql.entity.Student;
import com.aurovind.springdata.jpqlandNativeSql.repos.StudentRepository;

@SpringBootTest
class JpqlandNativeSqlApplicationTests {
	
	@Autowired
	StudentRepository studentRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	@Transactional
	//@Rollback(false)
	void testCreateStudent() {
		Student student = new Student("aurovind","samal",100);
		Student student1 = new Student("aurovind","jena",200);
		Student student2 = new Student("satish","samal",300);
		
		studentRepository.save(student);
		studentRepository.save(student1);
		studentRepository.save(student2);
		System.out.println("+++++++++++++++++++++++++++++++++");
		System.out.println(studentRepository.findAllStudentFromfirstName("aurovind"));
		System.out.println(studentRepository.findAllStudentFromfirstNameNQ("satish"));
		System.out.println("---------------------------------");
		Pageable pageable = PageRequest.of(0, 3, Sort.by(new Sort.Order(Direction.DESC, "score")));
		System.out.println(studentRepository.findAllStudents(pageable));
		System.out.println("/////////////////////////////////");
		System.out.println(studentRepository.findAllStudentBetweenScores(100, 300));
		System.out.println("*********************************");
		studentRepository.updateByFirstName(500, "satish");
		System.out.println("###################################");
		System.out.println(studentRepository.findAllStudentsNQ());
		
//		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//		
//		List<Object[]> findFirstNameLastName = studentRepository.findFirstNameLastName();
//		System.out.println(findFirstNameLastName.size());
//		for(Object[] objects:findFirstNameLastName) {
//			System.out.println(objects[1]);
//			System.out.println(objects[1]);
//			System.out.println(objects[2]);
//		}
	
	}

}
