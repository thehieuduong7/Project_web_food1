package com.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity(name="Ship")
@Table(name="ship")
public class ShipModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(length=50)
	String city_ship ;
	
	@Column
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
	public ShipModel() {
		super();
	}
	
}
