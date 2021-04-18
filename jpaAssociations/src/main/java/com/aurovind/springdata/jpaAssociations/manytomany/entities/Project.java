package com.aurovind.springdata.jpaAssociations.manytomany.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String projectName;
	
	@OneToMany(mappedBy = "projects")
	private Set<Programmer> programmer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Set<Programmer> getProgrammer() {
		return programmer;
	}

	public void setProjects(Set<Programmer> programmer) {
		this.programmer = programmer;
	}

}
