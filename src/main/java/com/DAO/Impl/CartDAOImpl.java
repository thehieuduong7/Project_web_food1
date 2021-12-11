package com.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DAO.CartDAO;
import com.controller.DBConnect;
import com.controller.DBConnectMySQL;
import com.models.CartModel;

public class CartDAOImpl implements CartDAO{
	private Connection conn = DBConnectMySQL.getConnection();
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	public List<CartModel> getList(ResultSet rs){
		List<CartModel> list =new ArrayList<>();
		try {
			while(rs.next()) {
				int id_kh=rs.getInt(1);
				int id_product = rs.getInt(2);
				int amount = rs.getInt(3);
				list.add(new CartModel(id_kh,id_product,amount));
			}
			return list;
		} catch (SQLException e) {
			return new ArrayList<>();
		} catch( Exception e ) {
			return new ArrayList<>();
		}
	}
	@Override
	public boolean insert(int id_user, int id_product) {
		String query ="Insert into Cart values(?,?,?)";
		try {
			ps=conn.prepareStatement(query);
			ps.setInt(1,id_user);
			ps.setInt(2, id_product);
			ps.setInt(3, 1);
			if(0!=ps.executeUpdate())
			return true;		
			else return false;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean plus(int id_user, int id_product) {
		String query ="Update Cart "
				+ "Set amount=amount+1 "
				+ "where id_kh=? and id_product=?";
		try {
			ps=conn.prepareStatement(query);
			ps.setInt(1,id_user);
			ps.setInt(2, id_product);
			if(0!=ps.executeUpdate())
			return true;		// trong model co ham` covert ResultSet -> List<>
			else return false;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean minus(int id_user, int id_product) {
		String query ="Update Cart "
				+ "Set amount=amount-1 "
				+ "where id_kh=? and id_product=?";
		try {
			ps=conn.prepareStatement(query);
			ps.setInt(1,id_user);
			ps.setInt(2, id_product);
			if(0!=ps.executeUpdate())
			return true;		// trong model co ham` covert ResultSet -> List<>
			else return false;
		}
		catch(Exception e) {
			e.printStackTrace();

			return false;
		}
	}

	@Override
	public boolean remove(int id_user, int id_product) {
		String query ="delete from Cart "
				+ "where id_kh=? and id_product=?";
		try {
			ps=conn.prepareStatement(query);
			ps.setInt(1,id_user);
			ps.setInt(2, id_product);
			if(0!=ps.executeUpdate())
			return true;		// trong model co ham` covert ResultSet -> List<>
			else return false;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public CartModel getCart(int id_user, int id_product) {
		String query ="select * from Cart where id_kh=? and id_product=? ";
		try {
			ps=conn.prepareStatement(query);
			ps.setInt(1, id_user);
			ps.setInt(2, id_product);
			rs=ps.executeQuery();
			List<CartModel> list = this.getList(rs);
			if(list==null || list.isEmpty()) return null;
			return list.get(0);
		}
		catch(Exception e) {
			return null;
		}
	}

	@Override
	public List<CartModel> getAll() {
		String query ="select * from Cart";
		try {
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			List<CartModel> list = this.getList(rs);
			return list;
		}
		catch(Exception e) {
			return new ArrayList<CartModel>();
		}
	}

	@Override
	public List<CartModel> getByIDUser(int id_user) {
		String query ="select * from Cart where id_kh=? ";
		try {
			ps=conn.prepareStatement(query);
			ps.setInt(1, id_user);
			rs=ps.executeQuery();
			List<CartModel> list = this.getList(rs);
			return list;
		}
		catch(Exception e) {
			return new ArrayList<CartModel>();
		}
	}
	
	public static void main(String args[]) {
		CartDAOImpl dao =new CartDAOImpl();
		CartModel cart = new CartModel(0, 0, 0);
		System.out.print(dao.insert(1, 2));
		System.out.print(dao.plus(1, 2));
		System.out.print(dao.minus(1, 2));
		System.out.print(dao.remove(1, 2));


	}

}
