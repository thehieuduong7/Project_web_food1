package com.DAO;

import java.util.List;

import com.models.ProductModel;

public interface ProductDAO {
	public boolean insert(ProductModel product);
	public boolean update(ProductModel product);
	public boolean remove(int id_product);
	public List<ProductModel> getAll();
	public ProductModel getByID(int id_product);
	public List<ProductModel> getByCid(int cid);
	public List<ProductModel> getByIDUser(int uid);
}
