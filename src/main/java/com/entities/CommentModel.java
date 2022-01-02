package com.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity(name="Comment")
@Table(name="comment")
public class CommentModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	int id_comment;
	
	@ManyToOne
	@JoinColumn(name="id_user",nullable = false)
	UserLoginModel user ;

	@ManyToOne
	@JoinColumn(name="id_product",nullable = false)
	ProductModel product;
	
	@Column(nullable = false,length=500)
	String content;
	
	@Column(columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
	@Temporal(value = TemporalType.TIMESTAMP)
	Date time_cmt ;

	public int getId_comment() {
		return id_comment;
	}

	public void setId_comment(int id_comment) {
		this.id_comment = id_comment;
	}

	public UserLoginModel getUser() {
		return user;
	}

	public void setUser(UserLoginModel user) {
		this.user = user;
	}

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime_cmt() {
		return time_cmt;
	}

	public void setTime_cmt(Date time_cmt) {
		this.time_cmt = time_cmt;
	}

	

	public CommentModel() {
		super();
	}
	
	
	
	
}
