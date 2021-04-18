package com.aurovind.springdata.componentmapping.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String city;
	private String stateAddress;
	private String country;
	private String state;
	private String zipcode;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateAddress() {
		return stateAddress;
	}
	public void setStateAddress(String stateAddress) {
		this.stateAddress = stateAddress;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	

}
