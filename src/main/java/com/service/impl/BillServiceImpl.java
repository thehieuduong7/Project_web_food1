package com.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import com.DAO.BillDAO;
import com.DAO.ProductDAO;
import com.DAO.Impl.BillDAOImpl;
import com.DAO.Impl.ProductDAOImpl;
import com.controller.config.MailConnect;
import com.models.BillDetailModel;
import com.models.BillModel;
import com.models.CartModel;
import com.models.ProductModel;
import com.models.ShipModel;
import com.models.UserLoginModel;
import com.service.BillService;
import com.service.CartService;
import com.service.ProductService;
import com.service.ShippingService;
import com.service.UserLoginService;

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
		//System.out.print(sendMail(bill,listDetail));
		if(insertBill(bill,listDetail)==false) {
			return false;
		}
		sendMail(bill,listDetail);
		return true;
	}
	public boolean sendMail(BillModel bill,List<BillDetailModel> listDetail) {
		UserLoginService userSer = new UserLoginServiceImpl();
		UserLoginModel user = userSer.getByID(bill.getId_user());
		String name= user.getFull_name();
		String email=user.getUsername().trim();
		String total_money = String.valueOf(bill.getTotal_money_pay());
		String city_name=bill.getCity_ship();
		
		String content_detail = " <div style=\"display: flex; flex-direction: row;\">\r\n"
				+ "			<h3 style=\"min-width: 400px;\">\r\n"
				+ "				Tên món: <span>%s</span>\r\n"
				+ "			</h3>\r\n"
				+ "			<h3 style=\"min-width: 200px;\">\r\n"
				+ "				Số lượng: <span>%d</span>\r\n"
				+ "			</h3>\r\n"
				+ "			<h3 style=\"margin-left: 14px;\">\r\n"
				+ "				Tổng tiền: <span>%.2f đồng</span>\r\n"
				+ "			</h3>\r\n"
				+ "		</div> ";
		String detail= "";
		
		ProductService proSer = new ProductServiceImpl();
		for (BillDetailModel i: listDetail) {
			ProductModel pro = proSer.searchByID(i.getId_product());
			detail+= String.format(content_detail, pro.getName_food(),i.getAmount(),i.getTotal_money());
		}
		
		
		
		/*String content="<body>\r\n"
				+ "    <div style=\"display:flex; justify-content:center\">  \r\n"
				+ "          <h1>Hoá đơn mua hàng</h1>\r\n"
				+ "    </div>\r\n"
				+ "    <div style=\"display:flex; flex-direction: column;\">  \r\n"
				+ "        <h3 style=\"margin-left:14px; \">Tên khách hàng: <span> %s </span></h3>\r\n"
				+ "        <h3 style=\"margin-left:14px; margin-top:5px;\">Tổng tiền: <span> %f </span>đồng</h3>\r\n"
				+ "        <h3 style=\"margin-left:14px;margin-top:5px;\">Tên thành phố: <span> %s </span></h3>\r\n"
				+ "        \r\n"
				+ "        <div style=\"width:100%; border:1px solid black\"></div>\r\n"
				+ "        <div style=\"display:flex; flex-direction: column; margin-top:15px;\">\r\n"
				+ "			%s "
				+ "        </div>\r\n"
				+ "    </div>\r\n"
				+ "\r\n"
				+ "</body>";*/
		
		String content="<div >  \r\n"
				+ "          <h1>Hoá đơn mua hàng</h1>\r\n"
				+ "    </div>\r\n"
				+ "    <div>\r\n"
				+ "		<div>\r\n"
				+ "			<h3 style=\"margin-left: 14px;\">\r\n"
				+ "				Tên khách hàng: <span> "+name+" </span>\r\n"
				+ "			</h3>\r\n"
				+ "		</div>\r\n"
				+ "		<div>\r\n"
				+ "			<h3 style=\"margin-left: 14px; margin-top: 5px;\">\r\n"
				+ "				Tổng tiền: <span> "+total_money+" đồng </span>\r\n"
				+ "			</h3>\r\n"
				+ "		</div>\r\n"
				+ "		<div>\r\n"
				+ "			<h3 style=\"margin-left: 14px; margin-top: 5px;\">\r\n"
				+ "				Tên thành phố: <span> "+city_name+" </span>\r\n"
				+ "			</h3>\r\n"
				+ "		</div>\r\n"
				+ "	</div>\r\n"
				+ "    <div style=\"width:100%; border:1px solid black\"></div>\r\n"
				+ "	<div style=\"margin-top: 15px;\">\r\n"
				+ "  "+detail+" "
				+ "	</div>";
		//String res =String.format(content,name,total_money,city_name,detail);
		try {
			MailConnect.sendAsHtml(email, "Hoa don thanh toan!!!", content);
			return true;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		//name+total_money+city_name;
	}
	
	public static void main(String args[]) {
		BillServiceImpl ser = new BillServiceImpl();
		System.out.print(ser.payment(1, "Da Nang"));
	}

}
