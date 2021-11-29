package com.models;

public class ShipModel {
	String city_ship ;
	float price_ship ;
	public String getCity_ship() {
		return city_ship;
	}
	public void setCity_ship(String city_ship) {
		this.city_ship = city_ship;
	}
	public float getPrice_ship() {
		return price_ship;
	}
	public void setPrice_ship(float price_ship) {
		this.price_ship = price_ship;
	}
	public ShipModel(String city_ship, float price_ship) {
		super();
		this.city_ship = city_ship;
		this.price_ship = price_ship;
	}
	
}
