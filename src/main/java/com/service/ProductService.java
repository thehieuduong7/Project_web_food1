package com.service;

import java.util.List;

import com.models.ProductModel;

public interface ProductService {
	public List<ProductModel> getTop4();
	public List<ProductModel> getAll();
	public ProductModel searchByID(int id_product);
	public ProductModel searchFilterName(String name);
	public int countAll();
	public int countByCID(int cid);
	public int lenPage(int maxInPage);
	public List<ProductModel> getListInPage(int page,int maxInPage);
	public boolean insert(ProductModel product);
	public boolean update(ProductModel product);
	public boolean remove(int id_product);
	public float getPrice(int id_product);
}
