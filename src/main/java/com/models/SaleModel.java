package com.models;

public class SaleModel {
	int id_sale;
	int id_product ;
	float percent_sale ;
	String description ;
	int status_sale ;
	public SaleModel(int id_sale, int id_product, float percent_sale, String description, int status_sale) {
		super();
		this.id_sale = id_sale;
		this.id_product = id_product;
		this.percent_sale = percent_sale;
		this.description = description;
		this.status_sale = status_sale;
	}
	public int getId_sale() {
		return id_sale;
	}
	public void setId_sale(int id_sale) {
		this.id_sale = id_sale;
	}
	public int getId_product() {
		return id_product;
	}
	public void setId_product(int id_product) {
		this.id_product = id_product;
	}
	public float getPercent_sale() {
		return percent_sale;
	}
	public void setPercent_sale(float percent_sale) {
		this.percent_sale = percent_sale;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStatus_sale() {
		return status_sale;
	}
	public void setStatus_sale(int status_sale) {
		this.status_sale = status_sale;
	}
}
