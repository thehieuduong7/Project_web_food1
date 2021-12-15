package com.DAO;

import java.util.List;

import com.models.CategoryModel;

public interface CategoryDAO {

	public List<CategoryModel> getAll();
	public CategoryModel searchByID(int id);
}
