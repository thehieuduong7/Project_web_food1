package com.entities;

import javax.persistence.Entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity(name="Product")
@Table(name="product")
public class ProductModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	int id_product ;
	
	@Column(nullable = false,length=50)
	String name_food ;
	
	@ManyToOne
	@JoinColumn(name="id_category")
	CategoryModel category ;
	
	@ManyToOne
	@JoinColumn(name="id_seller")
	UserLoginModel seller ;
	
	@Column(nullable = false)
	float price ;
	
	@Column(nullable = false, columnDefinition="TEXT")
	String description ;
	
	@Column(nullable = false, columnDefinition="TEXT")
	String photo;
	
	@Column(nullable = false)
	float salePercent;
	
	
	@OneToMany(mappedBy="product",cascade = CascadeType.ALL)
	Set<CommentModel> comments;


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


	public CategoryModel getCategory() {
		return category;
	}


	public void setCategory(CategoryModel category) {
		this.category = category;
	}


	public UserLoginModel getSeller() {
		return seller;
	}


	public void setSeller(UserLoginModel seller) {
		this.seller = seller;
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


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public float getSalePercent() {
		return salePercent;
	}


	public void setSalePercent(float salePercent) {
		this.salePercent = salePercent;
	}


	public Set<CommentModel> getComments() {
		return comments;
	}


	public void setComments(Set<CommentModel> comments) {
		this.comments = comments;
	}


	public ProductModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
