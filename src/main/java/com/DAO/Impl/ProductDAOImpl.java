package com.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.DAO.ProductDAO;
import com.controller.config.DBConnect;
import com.controller.config.DBConnectMySQL;
import com.models.CategoryModel;
import com.models.ProductModel;

public class ProductDAOImpl implements ProductDAO {
	private Connection conn = DBConnectMySQL.getConnection();
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	/**
	 * @param rs
	 * @return
	 */
	public List<ProductModel> getList(ResultSet rs){
		List<ProductModel> list =new ArrayList<>();
		try {
			while(rs.next()) {
				int id_product=rs.getInt(1);
				String name_food=rs.getString(2);
				int id_category=rs.getInt(3);
				int id_seller=rs.getInt(4);
				float price=rs.getFloat(5);
				String description=rs.getString(6);
				//byte[] photo = rs.getBytes(7);
				String photo= rs.getString(7);
				float salePrice= rs.getFloat(8);
				list.add(new ProductModel(id_product,name_food,id_category,
						id_seller,price,description,photo,salePrice));
			}
			if(list.isEmpty()==true) return null;
			return list;
		} catch (SQLException e) {
			return null;
		} catch( Exception e ) {
			return null;
		}
	}
	@Override
	public boolean insert(ProductModel product) {
		String query ="Insert into Product (name_food ,id_category,id_seller,price,description,photo,salePercent)"
				+ " values(?,?,?,?,?,?,?)";
		try {
			
			ps=conn.prepareStatement(query);
			ps.setString(1,product.getName_food());
			ps.setInt(2, product.getId_category());
			ps.setInt(3, product.getId_seller());
			ps.setFloat(4,product.getPrice());
			ps.setString(5, product.getDescription());
			ps.setString(6, product.getPhoto());
			ps.setFloat(7,product.getSalePercent());
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
	public boolean update(ProductModel product) {
		String query ="Update Product set name_food=?,"
				+ "id_category=?,id_seller=?,price=?,"
				+ "description=?,photo=?,salePercent=? "
				+ "where id_product=?";
		try {
			ps=conn.prepareStatement(query);
			ps.setString(1,product.getName_food());
			ps.setInt(2, product.getId_category());
			ps.setInt(3, product.getId_seller());
			ps.setFloat(4,product.getPrice());
			ps.setString(5, product.getDescription());
			ps.setString(6,product.getPhoto());
			ps.setFloat(7,product.getSalePercent());
			ps.setInt(8, product.getId_product());
			if(ps.executeUpdate()!=0)
			return true;		
			else return false;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean remove(int id_product) {
		String query ="delete from Product where id_product=?";
		try {
			ps=conn.prepareStatement(query);
			ps.setInt(1, id_product);
			if(ps.executeUpdate()!=0)
			return true;		
			else return false;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public List<ProductModel> getAll() {
		String query ="select * from Product order by id_product desc ";
		try {
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			return this.getList(rs);
		}
		catch(Exception e) {
			return null;
		}
	}

	@Override
	public ProductModel getByID(int id_product) {
		String query ="select * from Product where id_product=? ";
		try {
			ps=conn.prepareStatement(query);
			ps.setInt(1, id_product);
			rs=ps.executeQuery();
			return this.getList(rs).get(0);
		}
		catch(Exception e) {
			return null;
		}
	}

	@Override
	public List<ProductModel> getByCid(int cid) {
		String query ="select * from Product where id_category=? ";
		try {
			ps=conn.prepareStatement(query);
			ps.setInt(1, cid);
			rs=ps.executeQuery();
			return this.getList(rs);
		}
		catch(Exception e) {
			return null;
		}
	}

	@Override
	public List<ProductModel> getByIDUser(int uid) {
		String query ="select * from Product where id_seller=? ";
		try {
			ps=conn.prepareStatement(query);
			ps.setInt(1, uid);
			rs=ps.executeQuery();
			return this.getList(rs);
		}
		catch(Exception e) {
			return null;
		}
	}
	public boolean testAdd(CategoryModel product) {
		conn=DBConnectMySQL.getConnection();
		String query ="Insert into category(name_category,icon) values(?,?)";
		try {
			conn.setAutoCommit(false);

			ps=conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,product.getName_category());
			ps.setString(2, product.getIcon());
			
			if(0==ps.executeUpdate()) return false;
			
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);

            }
            else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
			
			conn.commit();
			return true;		// trong model co ham` covert ResultSet -> List<>
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]) {
		ProductDAOImpl dao = new ProductDAOImpl();
		//CategoryModel pro = new CategoryModel(1, "Cake", "fa fa-birthday-cake");

		//System.out.print(dao.testAdd(pro));
		//pro = new CategoryModel(1, "Apple", "fa fa-apple");
		//System.out.print(dao.testAdd(pro));
		
		ProductModel pro = dao.getByID(12);
		pro.setName_food("cake ngon");
		//System.out.print(pro.getName_food());
		System.out.print(dao.update(pro));
	}


}
