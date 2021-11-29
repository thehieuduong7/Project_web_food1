package com.models;

import java.awt.Image;

public class ProductModel {
	int id_product ;
	String name_food ;
	int id_category ;
	int id_seller ;
	float price ;
	String description ;
	Image photo;
	public int getId_product() {
		return id_product;
	}
	public void setId_product(int id_product) {
		this.id_product = id_product;
	}
	public String getName_food() {
		return name_food;
	}
	public void setName_food(String name_food) {
		this.name_food = name_food;
	}
	public int getId_category() {
		return id_category;
	}
	public void setId_category(int id_category) {
		this.id_category = id_category;
	}
	public int getId_seller() {
		return id_seller;
	}
	public void setId_seller(int id_seller) {
		this.id_seller = id_seller;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Image getPhoto() {
		return photo;
	}
	public void setPhoto(Image photo) {
		this.photo = photo;
	}
	public ProductModel(int id_product, String name_food, int id_category, int id_seller, float price,
			String description, Image photo) {
		super();
		this.id_product = id_product;
		this.name_food = name_food;
		this.id_category = id_category;
		this.id_seller = id_seller;
		this.price = price;
		this.description = description;
		this.photo = photo;
	}
}
