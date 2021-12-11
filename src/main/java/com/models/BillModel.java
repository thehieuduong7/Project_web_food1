package com.models;

import java.util.Date;

public class BillModel {
	int id_bill;
	int id_user;
	String city_ship;
	Date time_bill ;
	float total_money_pay;
	public BillModel(int id_bill, int id_user, String city_ship, Date time_bill,float total_money_pay) {
		super();
		this.id_bill = id_bill;
		this.id_user = id_user;
		this.city_ship = city_ship;
		this.time_bill = time_bill;
		this.total_money_pay=total_money_pay;
	}
	public float getTotal_money_pay() {
		return total_money_pay;
	}
	public void setTotal_money_pay(float total_money_pay) {
		this.total_money_pay = total_money_pay;
	}
	public int getId_bill() {
		return id_bill;
	}
	public void setId_bill(int id_bill) {
		this.id_bill = id_bill;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getCity_ship() {
		return city_ship;
	}
	public void setCity_ship(String city_ship) {
		this.city_ship = city_ship;
	}
	public Date getTime_bill() {
		return time_bill;
	}
	public void setTime_bill(Date time_bill) {
		this.time_bill = time_bill;
	}
}
