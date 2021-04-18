package com.aurovind.springdata.jpaAssociations.OnetoOne.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class DriversLicense {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String type;
	
	@Temporal(TemporalType.DATE)
	private Date issuesFrom;
	
	@Temporal(TemporalType.DATE)
	private Date issuesTo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id")
	private Person person;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getIssuesFrom() {
		return issuesFrom;
	}
	public void setIssuesFrom(Date issuesFrom) {
		this.issuesFrom = issuesFrom;
	}
	public Date getIssuesTo() {
		return issuesTo;
	}
	public void setIssuesTo(Date issuesTo) {
		this.issuesTo = issuesTo;
	}
	

}
