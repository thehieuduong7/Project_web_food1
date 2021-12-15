package com.service.impl;

import java.util.List;

import com.DAO.ProductDAO;
import com.DAO.Impl.ProductDAOImpl;
import com.google.gson.Gson;
import com.models.ProductModel;
import com.service.ProductService;

public class ProductServiceImpl implements ProductService{

	ProductDAO proDAO = new ProductDAOImpl();
	@Override
	public List<ProductModel> getTop4() {
		List<ProductModel> list  = proDAO.getAll();
		if(list.size()<4) return list;
		return list.subList(0, 4);

	}

	@Override
	public List<ProductModel> getAll() {
		List<ProductModel> list  = proDAO.getAll();
		return list;
	}

	@Override
	public ProductModel searchByID(int id_product) {
		ProductModel pro  = proDAO.getByID(id_product);
		return pro;
	}

	@Override
	public ProductModel searchFilterName(String name) {
		
		return null;
	}

	@Override
	public int countAll(List<ProductModel> list) {
		return list.size();
	}

	@Override
	public int countByCID(int cid) {
		
		return proDAO.getByCid(cid).size();
	}

	@Override
	public int lenPage(List<ProductModel> list,int maxInPage) {
		int len = this.countAll(list);
		int du = (len%maxInPage!=0)?1:0;
		return ((int)len/maxInPage)+du;
	}

	
	@Override
	public List<ProductModel> getListInPage(List<ProductModel> list,
			int page, int maxInPage) {
		int len = list.size();
		int start = (page-1)*maxInPage;
		int end = start+maxInPage;
		try {
			if(end>len-1) return list.subList(start, len);
			else return list.subList(start, end);
		}catch(IndexOutOfBoundsException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean insert(ProductModel product) {
		
		return proDAO.insert(product);
	}

	@Override
	public boolean update(ProductModel product) {
		
		return proDAO.update(product);
	}

	@Override
	public boolean remove(int id_product) {
		// TODO Auto-generated method stub
		return proDAO.remove(id_product);
	}

	@Override
	public float getPrice(int id_product) {
		ProductModel pro = proDAO.getByID(id_product);
		float price = pro.getPrice()*(1-pro.getSalePercent());
		return price;
	}

	@Override
	public List<ProductModel> getByCID(int cid) {
		// TODO Auto-generated method stub
		return proDAO.getByCid(cid);
	}
	public static void main(String args[]) {
		Gson gson = new Gson();
		ProductServiceImpl pro = new ProductServiceImpl();
		List<ProductModel> list =pro.getByID_seller(2);
		System.out.print(gson.toJson( pro.getAll()));
	}

	@Override
	public List<ProductModel> getByID_seller(int id_selle) {
		// TODO Auto-generated method stub
		return proDAO.getByIDUser(id_selle);
	}

}
