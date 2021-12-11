package com.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.DAO.BillDAO;
import com.DAO.CartDAO;
import com.controller.DBConnect;
import com.controller.DBConnectMySQL;
import com.models.BillDetailModel;
import com.models.BillModel;

public class BillDAOImpl implements BillDAO {
	private Connection conn = DBConnectMySQL.getConnection();
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	public List<BillModel> convertListBill(ResultSet rs){
		List<BillModel> list =new ArrayList<>();
		try {
			while(rs.next()) {
				int id_bill=rs.getInt(1);
				int id_user = rs.getInt(2);
				String city_ship = rs.getString(3);
				Date time_bill = rs.getDate(4);
				float total_money_pay= rs.getFloat(5);
				list.add(new BillModel(id_bill,id_user,
						city_ship,time_bill,total_money_pay));
			}
			return list;
		} catch (SQLException e) {
			return new ArrayList<>();
		} catch( Exception e ) {
			return new ArrayList<>();
		}
	}
	public List<BillDetailModel> convertListBillDetail(ResultSet rs){
		List<BillDetailModel> list =new ArrayList<>();
		try {
			while(rs.next()) {
				int id_billDetail=rs.getInt(1);
				int id_bill = rs.getInt(2);
				int id_product = rs.getInt(3);
				int amount = rs.getInt(4);
				float total_money= rs.getFloat(5);

				list.add(new BillDetailModel(id_billDetail,id_bill,
						id_product,amount,total_money));
			}
			return list;
		} catch (SQLException e) {
			return new ArrayList<>();
		} catch( Exception e ) {
			return new ArrayList<>();
		}
	}
	@Override
	public List<BillModel> getAllBill() {
		String query ="select * from Bill";
		try {
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			List<BillModel> list = this.convertListBill(rs);
			return list;
		}
		catch(Exception e) {
			return new ArrayList<BillModel>();
		}
	}

	@Override
	public BillModel getBillByID(int id_bill) {
		String query ="select * from Bill where id_bill=id_bill";
		try {
			ps=conn.prepareStatement(query);
			ps.setInt(1, id_bill);
			rs=ps.executeQuery();
			List<BillModel> list = this.convertListBill(rs);
			if(list==null) return null;
			return list.get(0);
		}
		catch(Exception e) {
			return null;
		}
	}

	@Override
	public List<BillModel> getBillByIDUser(int id_user) {
		String query ="select * from Bill where id_user =?";
		try {
			ps=conn.prepareStatement(query);
			ps.setInt(1, id_user);
			rs=ps.executeQuery();
			List<BillModel> list = this.convertListBill(rs);
			return list;
		}
		catch(Exception e) {
			return null;
		}
	}

	@Override
	public List<BillDetailModel> getBillDetail(int id_bill) {
		String query ="select * from Bill where id_bill =?";
		try {
			ps=conn.prepareStatement(query);
			ps.setInt(1, id_bill);
			rs=ps.executeQuery();
			List<BillDetailModel> list = this.convertListBillDetail(rs);
			return list;
		}
		catch(Exception e) {
			return null;
		}
	}

	@Override
	public boolean insertBill(BillModel bill, List<BillDetailModel> listBillDetail) {
		String queryBill ="insert into Bill(id_user,city_ship,total_money_pay) values(?,?,?)";
		String querryBillDetail ="insert into BillDetail values (null,?,?,?,?)";
		CartDAO cartDAO = new CartDAOImpl();
		
		try {
			conn.setAutoCommit(false);
			ps=conn.prepareStatement(queryBill,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, bill.getId_user());
			ps.setNString(2, bill.getCity_ship());
			ps.setFloat(3, bill.getTotal_money_pay());

            if(0==ps.executeUpdate()) throw new SQLException();
			rs = ps.getGeneratedKeys();
			int id_bill;
			if (rs.next()) {
				id_bill = rs.getInt(1);
            }
            else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
			for(BillDetailModel element :listBillDetail) {
		          ps= conn.prepareStatement(querryBillDetail);
		          ps.setInt(1, id_bill);
		          ps.setInt(2, element.getId_product());
		          ps.setInt(3, element.getAmount());
		          ps.setFloat(4, element.getTotal_money());
		          if(0==ps.executeUpdate()) throw new SQLException();
		          cartDAO.remove(bill.getId_user(), element.getId_product());
			}
	
			conn.commit();
			return true;
		}
		catch(SQLException e) {
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
	
}
