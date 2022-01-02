package com.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity(name="Category")
@Table(name="category")
public class CategoryModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	int id_category;
	
	@Column(nullable = false,length=50)
	String name_category;
	
	@Column(nullable = true,length=50)
	String icon;
	
	@OneToMany(mappedBy="category")
	Set<ProductModel> products;
	
	
	public int getId_category() {
		return id_category;
	}
	public void setId_category(int id_category) {
		this.id_category = id_category;
	}
	public String getName_category() {
		return name_category;
	}
	public void setName_category(String name_category) {
		this.name_category = name_category;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Set<ProductModel> getProducts() {
		return products;
	}
	public void setProducts(Set<ProductModel> products) {
		this.products = products;
	}
	public CategoryModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
