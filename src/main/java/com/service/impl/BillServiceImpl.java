package com.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.DAO.BillDAO;
import com.DAO.ProductDAO;
import com.DAO.Impl.BillDAOImpl;
import com.DAO.Impl.ProductDAOImpl;
import com.models.BillDetailModel;
import com.models.BillModel;
import com.models.CartModel;
import com.models.ShipModel;
import com.service.BillService;
import com.service.CartService;
import com.service.ProductService;
import com.service.ShippingService;

public class BillServiceImpl implements BillService {
	BillDAO billDAO = new BillDAOImpl();
	@Override
	public List<BillModel> getAllBill() {
		// TODO Auto-generated method stub
		return billDAO.getAllBill();
	}

	@Override
	public BillModel getBillById(int id_bill) {
		return billDAO.getBillByID(id_bill);
	}

	@Override
	public List<BillModel> getBillByIDUser(int id_user) {
		// TODO Auto-generated method stub
		return billDAO.getBillByIDUser(id_user);
	}

	@Override
	public List<BillDetailModel> getBillDetail(int id_bill) {
		// TODO Auto-generated method stub
		return billDAO.getBillDetail(id_bill);
	}

	@Override
	public boolean insertBill(BillModel bill, List<BillDetailModel> listBillDetail) {
		// TODO Auto-generated method stub
		return billDAO.insertBill(bill, listBillDetail);
	}

	@Override
	public boolean payment(int id_user,String city_ship) {
		CartService cartSer = new CartServiceImpl();
		ShippingService shipSer = new ShippingServiceImpl();
		float total_money = cartSer.getTotalMoney(id_user);
		List<ShipModel> listShip = shipSer.getAll();
		float price_ship=0;
		for (ShipModel i: listShip) {
			if(i.getCity_ship().trim().equals(city_ship.trim())) {
				price_ship=i.getPrice_ship();
			}
		}
		total_money+=price_ship;
		BillModel bill = new BillModel(-1, id_user,city_ship , 
				new Date(System.currentTimeMillis()),total_money);
		ProductService proSer = new ProductServiceImpl();
		List<CartModel> listCart=cartSer.getByIDUser(id_user);
		ArrayList<BillDetailModel> listDetail = new ArrayList<>();
		for (CartModel cart:listCart) {
			int id_pro = cart.getId_product();
			int amount = cart.getAmount();
			float price = proSer.getPrice(id_pro);
			
			BillDetailModel detail = new BillDetailModel(-1, -1, id_pro, amount,price*amount);
			listDetail.add(detail);
		}
		
		return insertBill(bill,listDetail);
	}
	
	public static void main(String args[]) {
		BillServiceImpl ser = new BillServiceImpl();
		System.out.print(ser.payment(1, "Sai Gon"));
	}

}
