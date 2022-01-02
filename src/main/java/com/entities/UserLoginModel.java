package com.entities;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity(name="UserLogin")
@Table(name="userlogin")
public class UserLoginModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	int id_user;
	
	@Column(nullable = false,length=50)
	String full_name;
	@Column(nullable = false,length=50)
	String username;
	@Column(nullable = false,length=50)
	String password;
	
	@Column(nullable = false,length=50)
	String role;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	Set<CartModel> carts;
	
	@OneToMany(mappedBy="user")
	Set<BillModel> bills;
	
	@OneToMany(mappedBy="seller")
	Set<ProductModel> products;

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

	public Set<CartModel> getCarts() {
		return carts;
	}

	public void setCarts(Set<CartModel> carts) {
		this.carts = carts;
	}

	public Set<BillModel> getBills() {
		return bills;
	}

	public void setBills(Set<BillModel> bills) {
		this.bills = bills;
	}

	public Set<ProductModel> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductModel> products) {
		this.products = products;
	}

	public UserLoginModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
