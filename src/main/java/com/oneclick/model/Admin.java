package com.oneclick.model;

public class Admin{
	private int adminId;
	private String userName;
	private String email;
	private String password;
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int id) {
		this.adminId = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
