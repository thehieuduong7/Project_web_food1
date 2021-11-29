package com.models;

import java.util.Date;

public class CommentModel {
	int id_comment;
	int id_user ;
	int id_product;
	String content;
	Date time_cmt ;
	public CommentModel(int id_comment, int id_user, int id_product, String content, Date time_cmt) {
		super();
		this.id_comment = id_comment;
		this.id_user = id_user;
		this.id_product = id_product;
		this.content = content;
		this.time_cmt = time_cmt;
	}
	public int getId_comment() {
		return id_comment;
	}
	public void setId_comment(int id_comment) {
		this.id_comment = id_comment;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public int getId_product() {
		return id_product;
	}
	public void setId_product(int id_product) {
		this.id_product = id_product;
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
}
