package com.service.impl;

import java.util.List;

import com.DAO.CartDAO;
import com.DAO.Impl.CartDAOImpl;
import com.models.CartModel;
import com.models.ProductModel;
import com.service.CartService;
import com.service.ProductService;

public class CartServiceImpl implements CartService{
	
	CartDAO cartDAO = new CartDAOImpl();
	@Override
	public List<CartModel> getAll() {
		
		return cartDAO.getAll();
	}

	@Override
	public List<CartModel> getByIDUser(int id_user) {
		return cartDAO.getByIDUser(id_user);
	}

	@Override
	public boolean addCart(int id_user, int id_product) {
		CartModel cart = cartDAO.getCart(id_user, id_product);
		if(cart==null) {
			return cartDAO.insert(id_user, id_product);
		}
		else return cartDAO.plus(id_user, id_product);
	}

	@Override
	public boolean minuscart(int id_user, int id_product) {
		CartModel cart = cartDAO.getCart(id_user, id_product);
		if(cart==null || cart.getAmount()==1) {
			return cartDAO.remove(id_user, id_product);
		}
		else return cartDAO.minus(id_user, id_product);
	}

	@Override
	public boolean removeCart(int id_user, int id_product) {
		return cartDAO.remove(id_user, id_product);
	}

	@Override
	public CartModel getCart(int id_user, int id_product) {
		return cartDAO.getCart(id_user, id_product);
	}
	
	public static void main(String args[]) {
		CartServiceImpl s = new CartServiceImpl();
		System.out.print(s.getTotalMoney(1));
	}

	@Override
	public float getTotalMoney(int id_user) {
		List<CartModel> listCart = this.getByIDUser(id_user);
		ProductService proSer = new ProductServiceImpl();
		float sum =0;
		for (CartModel cart:listCart) {
			int id_product = cart.getId_product();
			ProductModel pro = proSer.searchByID(id_product);
			sum+= pro.getBuyPrice()*cart.getAmount();
		}
		return sum;
	}

	@Override
	public int getTotalAmount(int id_user) {
		List<CartModel> listCart = this.getByIDUser(id_user);
		int amount=0;
		for (CartModel cart:listCart) {
			amount+=cart.getAmount();
		}
		return amount;
	}
	
	
}
