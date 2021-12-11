package com.service;

import java.util.List;

import com.models.CategoryModel;


public interface CategoryService {
	public List<CategoryModel> getAll();
	public CategoryModel searchByID(int id);
	public int countAll();
	public boolean insert(CategoryModel category);
	public boolean update(CategoryModel category);
	public boolean remove(int id_category);
	
}
