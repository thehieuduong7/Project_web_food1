package com.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DAO.ShippingDAO;
import com.controller.config.DBConnectMySQL;
import com.models.ShipModel;

public class ShippingDAOImpl implements ShippingDAO{
	private Connection conn = DBConnectMySQL.getConnection();
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	@Override
	public List<ShipModel> getAll() {
		String query ="select * from Ship";
		List<ShipModel> list = new ArrayList<ShipModel>();
		try {
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				String city_ship=rs.getNString(1);
				float price_ship = rs.getFloat(2);
				list.add(new ShipModel(city_ship,price_ship));
			}
			return list;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String args[]) {
		ShippingDAOImpl dao =new ShippingDAOImpl();
		System.out.print(dao.getAll().get(0).getCity_ship());
	}
}
