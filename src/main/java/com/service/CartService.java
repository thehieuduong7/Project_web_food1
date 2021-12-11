package com.service;

import java.util.List;

import com.models.CartModel;

public interface CartService {
	public List<CartModel> getAll();
	public List<CartModel> getByIDUser(int id_user);
	public boolean addCart(int id_user,int id_product);
	public boolean minuscart(int id_user,int id_product);
	public boolean removeCart(int id_user,int id_product);
	public CartModel getCart(int id_user,int id_product);
	public float getTotalMoney(int id_user);
	public int getTotalAmount(int id_user);
}
