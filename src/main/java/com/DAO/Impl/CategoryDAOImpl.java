package com.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.DAO.CategoryDAO;
import com.controller.config.DBConnectMySQL;
import com.models.CartModel;
import com.models.CategoryModel;

public class CategoryDAOImpl implements CategoryDAO{
	private Connection conn = DBConnectMySQL.getConnection();
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	@Override
	public List<CategoryModel> getAll() {
		String query ="select * from Category";
		try {
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			List<CategoryModel> list =new ArrayList<>();
			while(rs.next()) {
				int id_cate=rs.getInt(1);
				String name_cate=rs.getNString(2);
				String icon=rs.getString(3);
				list.add(new CategoryModel(id_cate,name_cate,icon));
				
			}
			return list;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public CategoryModel searchByID(int id) {
		List<CategoryModel> list =this.getAll();
		for(CategoryModel cate:list) {
			if(cate.getId_category()==id) {
				return cate;
			}
		}
		return null;
	}
	public static void main(String args[]) {
		CategoryDAO dao =new CategoryDAOImpl();
		System.out.print(dao.searchByID(2).getIcon());
	}

}
