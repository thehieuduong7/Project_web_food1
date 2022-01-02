package com.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;


@Entity(name="Bill")
@Table(name="bill")
public class BillModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	int id_bill;
	
	@ManyToOne
	@JoinColumn(name="id_user")
	UserLoginModel user;
	
	@ManyToOne
	@JoinColumn(name="city_ship")
	ShipModel ship;
	
	@Column(name="time_bill",columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
	@Temporal(value = TemporalType.TIMESTAMP)
	Date time_bill ;
	
	@Column(nullable= false)
	float total_money_pay;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="bill",cascade=CascadeType.ALL)
	Set<BillDetailModel> billDetails;

	public int getId_bill() {
		return id_bill;
	}

	public void setId_bill(int id_bill) {
		this.id_bill = id_bill;
	}

	public UserLoginModel getUser() {
		return user;
	}

	public void setUser(UserLoginModel user) {
		this.user = user;
	}

	public ShipModel getShip() {
		return ship;
	}

	public void setShip(ShipModel ship) {
		this.ship = ship;
	}

	public Date getTime_bill() {
		return time_bill;
	}

	public void setTime_bill(Date time_bill) {
		this.time_bill = time_bill;
	}

	public float getTotal_money_pay() {
		return total_money_pay;
	}

	public void setTotal_money_pay(float total_money_pay) {
		this.total_money_pay = total_money_pay;
	}

	public Set<BillDetailModel> getBillDetails() {
		return billDetails;
	}

	public void setBillDetails(Set<BillDetailModel> billDetails) {
		this.billDetails = billDetails;
	}

	public BillModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
}
