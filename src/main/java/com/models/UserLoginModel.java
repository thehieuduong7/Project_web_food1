package com.models;



public class UserLoginModel {
	
	int id_user;
	
	String full_name;
	String username;
	String password;
	
	String role;
	
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public UserLoginModel(int id_user, String full_name, String username,
			String password, String role) {
		super();
		this.id_user = id_user;
		this.full_name = full_name;
		
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public UserLoginModel(String full_name,String username,
			String password, String role) {
		this.full_name = full_name;
		this.username = username;
		this.password = password;
		this.role = role;
	}
}
