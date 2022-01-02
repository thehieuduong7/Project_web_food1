package com.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity(name="BillDetail")
@Table(name="billDetail")
public class BillDetailModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id_billDetail;
	

	@ManyToOne
	@JoinColumn(name="id_bill",nullable = false)
	BillModel bill;
	
	@ManyToOne
	@JoinColumn(name="id_product")
	ProductModel product;
	
	@Column(nullable = false)
	int amount ;
	
	@Column(nullable = false)
	float total_money;

	public int getId_billDetail() {
		return id_billDetail;
	}

	public void setId_billDetail(int id_billDetail) {
		this.id_billDetail = id_billDetail;
	}

	public BillModel getBill() {
		return bill;
	}

	public void setBill(BillModel bill) {
		this.bill = bill;
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

	public float getTotal_money() {
		return total_money;
	}

	public void setTotal_money(float total_money) {
		this.total_money = total_money;
	}

	public BillDetailModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
