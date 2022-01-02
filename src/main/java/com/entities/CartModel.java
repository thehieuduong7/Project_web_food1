package com.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity(name="Cart")
@Table(name="cart")
public class CartModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name="id_kh")
	UserLoginModel user;
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_product")
	ProductModel product;
	
	@Column(nullable = false)
	int amount ;

	public UserLoginModel getId_kh() {
		return user;
	}

	public void setId_kh(UserLoginModel id_kh) {
		this.user = id_kh;
	}

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	

	public UserLoginModel getUser() {
		return user;
	}

	public void setUser(UserLoginModel user) {
		this.user = user;
	}

	public CartModel() {
		super();
	}
	
	
	
}
