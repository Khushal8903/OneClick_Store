package com.oneclick.model;


public class Customer {
	private int customerId;
	private String name;
	private String email;
	private String password;
	private String contact;
	private String address;
	
	public Customer(String name, String email, String password, String contact, String address) {
		this.name = name;
		this.email=email;
		this.password=password;
		this.contact = contact;
		this.address=address;
	}
	public Customer() {
		
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int id) {
		this.customerId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassward() {
		return password;
	}
	public void setPassward(String passward) {
		this.password = passward;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
