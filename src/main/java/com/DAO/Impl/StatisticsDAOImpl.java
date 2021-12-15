package com.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.DAO.ProductDAO;
import com.DAO.StatisticsDAO;
import com.controller.config.DBConnectMySQL;
import com.google.gson.Gson;
import com.models.ProductModel;

public class StatisticsDAOImpl implements StatisticsDAO{

	private Connection conn = DBConnectMySQL.getConnection();
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	@Override
	public Map<String, Object> getTongTienDaMua(int id_user) {
		String query = "select * from thongkedamua where id_user=?";
		
		try {
			ps=conn.prepareStatement(query);
			ps.setInt(1, id_user);
			rs=ps.executeQuery();
			Map<String,Object> map = new HashMap<>();
			map.put("id_user", id_user);
			List<Map<String,Object>> list= new ArrayList<>();
			while(rs.next()) {
				float total_amount=rs.getInt(2);
				float total_money=rs.getFloat(3);
				int month=rs.getInt(4);
				int year= rs.getInt(5);
				Map<String,Object> mapSub = new HashMap<>();
				mapSub.put("total_amount", total_amount);
				mapSub.put("total_money", total_money);
				mapSub.put("month", month);
				mapSub.put("year", year);
				list.add(mapSub);
			}
			map.put("detail",list);

			return map;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public Map<String, Object> getDoanhThuNam(int id_seller, int year) {
		String query = "select * from doanhthunam "
				+ "where id_seller=? and year=?";
		
		try {
			ps=conn.prepareStatement(query);
			ps.setInt(1, id_seller);
			ps.setInt(2, year);

			rs=ps.executeQuery();
			Map<String,Object> map = new HashMap<>();
			map.put("id_user", id_seller);
			map.put("year", year);

			List<Map<String,Object>> list= new ArrayList<>();
			while(rs.next()) {
				int total_amount=rs.getInt(2);
				float total_money=rs.getFloat(3);
				int month=rs.getInt(4);
				Map<String,Object> mapSub = new HashMap<>();
				mapSub.put("total_amount", total_amount);
				mapSub.put("total_money", total_money);
				mapSub.put("month", month);
				list.add(mapSub);
			}
			map.put("detail",list);

			return map;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public Map<String, Object> getDoanhThuThang(int id_seller, int month, int year) {
		String query = "select * from doanhthuthang "
				+ "where id_seller=? and month=? and year=?";
		ProductDAO proDAO = new ProductDAOImpl();
		try {
			ps=conn.prepareStatement(query);
			ps.setInt(1, id_seller);
			ps.setInt(2, month);
			ps.setInt(3, year);

			rs=ps.executeQuery();
			Map<String,Object> map = new HashMap<>();
			map.put("id_user", id_seller);
			map.put("month", year);
			map.put("year", year);

			List<Map<String,Object>> list= new ArrayList<>();
			while(rs.next()) {
				int id_product=rs.getInt(2);
				int total_amount=rs.getInt(3);
				float total_money=rs.getFloat(4);
				Map<String,Object> mapSub = new HashMap<>();
				mapSub.put("id_product", id_product);
				ProductModel pro = proDAO.getByID(id_product);
				mapSub.put("name_food", pro.getName_food());
				mapSub.put("total_amount", total_amount);
				mapSub.put("total_money", total_money);
				list.add(mapSub);
			}
			map.put("detail",list);
			return map;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String argsp[]) {
		StatisticsDAOImpl dao = new StatisticsDAOImpl();
		Gson gson =new Gson();
		String result = gson.toJson(dao.getTongTienDaMua(1));
		System.out.print(result);
	}

}
