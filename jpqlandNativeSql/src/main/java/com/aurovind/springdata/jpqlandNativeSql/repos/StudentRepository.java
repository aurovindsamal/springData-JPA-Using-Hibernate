package com.aurovind.springdata.jpqlandNativeSql.repos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.aurovind.springdata.jpqlandNativeSql.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	
	@Query("from Student")
	List<Student> findAllStudents(Pageable pageable);
	
	@Query("from Student")
	List<Student> findAllStudentswithoutPaging();
	
	@Query("select st.firstName, st.lastName from Student st")
	List<Object[]> findFirstNameLastName();
	
	@Query("from Student where firstName=:firssqltName")
	List<Student> findAllStudentFromfirstName(@Param("firssqltName") String firstN);
	
	@Query("from Student where score<:maxScore and score>:minScore")
	List<Student> findAllStudentBetweenScores(@Param("minScore") int min, @Param("maxScore") int max);
	
	@Modifying
	@Query("delete from Student where firstName=:firstname")
	void deleteByFirstName(@Param("firstname") String firstNa);
	
	@Modifying(clearAutomatically = true)
	@Query("update Student std set std.score =:score where std.firstName=:firstName")
	void updateByFirstName(@Param("score") int score, @Param("firstName") String firstName);
	
	//Native Query
	@Query(value = "select * from student",nativeQuery = true)
	List<Student> findAllStudentsNQ();
	
	@Query(value = "select * from student where fname=:firssqltName",nativeQuery = true)
	List<Student> findAllStudentFromfirstNameNQ(@Param("firssqltName") String firstN);
	

}
