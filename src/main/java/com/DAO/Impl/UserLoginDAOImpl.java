package com.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.DAO.UserLoginDAO;
import com.controller.config.DBConnectMySQL;
import com.models.BillModel;
import com.models.UserLoginModel;

public class UserLoginDAOImpl implements UserLoginDAO {


	private Connection conn = DBConnectMySQL.getConnection();
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	@Override
	public UserLoginModel add(UserLoginModel user) {
		String query ="Insert into UserLogin"
				+ " values(null,?,?,?,?)";
		try {
			
			ps=conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,user.getFull_name());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getRole());
			if(0==ps.executeUpdate())
			 throw new SQLException();		// trong model co ham` covert ResultSet -> List<>
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				int id_user= rs.getInt(1);
				user.setId_user(id_user);
			}
			return user;

		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public UserLoginModel login(String username, String password) {
		// TODO Auto-generated method stub
		String query ="select * from UserLogin where username=? and password=?";
		try {
			ps=conn.prepareStatement(query);
			ps.setString(1, username.trim());
			ps.setString(2, password.trim());
			rs=ps.executeQuery();
			if(rs.next()) {
				int id_user= rs.getInt(1);
				String full_name= rs.getNString(2);
				String usr= rs.getString(3);
				String pwd= rs.getString(4);
				String role= rs.getString(5);
				return new UserLoginModel(id_user,full_name,usr,pwd,role);
			}			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserLoginModel getByID(int id) {
		String query ="select * from UserLogin where id_user=?";
		try {
			ps=conn.prepareStatement(query);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				int id_user= rs.getInt(1);
				String full_name= rs.getNString(2);
				String usr= rs.getString(3);
				String pwd= rs.getString(4);
				String role= rs.getString(5);
				return new UserLoginModel(id_user,full_name,usr,pwd,role);
			}			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
