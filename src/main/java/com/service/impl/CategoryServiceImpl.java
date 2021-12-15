package com.service.impl;

import java.util.List;

import com.DAO.CategoryDAO;
import com.DAO.Impl.CategoryDAOImpl;
import com.models.CategoryModel;
import com.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	CategoryDAO catedao = new CategoryDAOImpl();
	@Override
	public List<CategoryModel> getAll() {
		// TODO Auto-generated method stub
		return catedao.getAll();
	}

	@Override
	public CategoryModel searchByID(int id) {
		// TODO Auto-generated method stub
		return catedao.searchByID(id);
	}


}
