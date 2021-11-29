package com.models;

public class CartModel {
	int id_kh;
	int id_product;
	int amount ;
	public CartModel(int id_kh, int id_product, int amount) {
		super();
		this.id_kh = id_kh;
		this.id_product = id_product;
		this.amount = amount;
	}
	public int getId_kh() {
		return id_kh;
	}
	public void setId_kh(int id_kh) {
		this.id_kh = id_kh;
	}
	public int getId_product() {
		return id_product;
	}
	public void setId_product(int id_product) {
		this.id_product = id_product;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
