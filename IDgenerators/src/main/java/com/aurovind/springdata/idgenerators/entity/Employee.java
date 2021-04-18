package com.aurovind.springdata.idgenerators.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Employee {
	
	@Id
	//@TableGenerator(name = "employee_gen",table = "id_gen",pkColumnName = "gen_name",valueColumnName = "gen_val",allocationSize=100)
	//@GeneratedValue(strategy=GenerationType.TABLE, generator = "employee_gen")
	@GenericGenerator(name="emp_id",strategy="com.aurovind.springdata.idgenerators.CustomRandomIDGenerator")
	@GeneratedValue(generator="emp_id")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

	
	
	

}
