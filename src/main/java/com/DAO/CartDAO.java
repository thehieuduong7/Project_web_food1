package com.DAO;

import java.util.List;

import com.models.CartModel;

public interface CartDAO {
	public boolean insert(int id_user,int id_product);
	public boolean plus(int id_user,int id_product);
	public boolean minus(int id_user,int id_product);
	public boolean remove(int id_user,int id_product);
	public CartModel getCart(int id_user, int id_product);
	public List<CartModel> getAll();
	public List<CartModel> getByIDUser(int id_user);

}
