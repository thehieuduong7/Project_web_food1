package com.DAO.Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DAO.CommentDAO;
import com.controller.DBConnectMySQL;
import com.models.CommentModel;
import com.models.ProductModel;

public class CommentDAOImpl implements CommentDAO {
	private Connection conn = DBConnectMySQL.getConnection();
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	public List<CommentModel> convertListComment(ResultSet rs){
		List<CommentModel> list =new ArrayList<>();
		try {
			while(rs.next()) {
				int id_comment = rs.getInt(1);
				int id_user= rs.getInt(2);
				int id_product = rs.getInt(3);
				String content = rs.getNString(4);
				Date date=rs.getDate(5);
				list.add(new CommentModel(id_comment,id_user,id_product,content,date));
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
	public List<CommentModel> getCommentByIDProduct(int id_product) {
		String query ="select * from Comment where id_product=? order by id_comment ";
		try {
			ps=conn.prepareStatement(query);
			ps.setInt(1, id_product);
			rs=ps.executeQuery();
			
			return this.convertListComment(rs);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean insert(CommentModel comment) {
		String query ="Insert into Comment(id_user,id_product,content)"
				+ " values(?,?,?)";
		try {
			
			ps=conn.prepareStatement(query);
			ps.setInt(1,comment.getId_user());
			ps.setInt(2,comment.getId_product());
			ps.setNString(3,comment.getContent());

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
	public boolean remove(int id_comment) {
		String query ="Delete from Comment where id_comment=?";
		try {
			
			ps=conn.prepareStatement(query);
			ps.setInt(1, id_comment);
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
	public boolean update(CommentModel comment) {
		String query ="Update Comment "
				+ "set "
				+ "id_user=?,id_product=?,content=?,time_cmt=? "
				+ "where id_comment=?";
		try {
			
			ps=conn.prepareStatement(query);
			ps.setInt(1,comment.getId_user());
			ps.setInt(2,comment.getId_product());
			ps.setNString(3,comment.getContent());
			ps.setDate(4,comment.getTime_cmt());
			ps.setInt(5,comment.getId_comment());

			if(0!=ps.executeUpdate())
			return true;		// trong model co ham` covert ResultSet -> List<>
			else return false;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String args[]) {
		CommentDAOImpl dao =new CommentDAOImpl();
		CommentModel cmt = new CommentModel(-1,1,7,"ngon quá",null);
		System.out.print(dao.insert(cmt));
		
	}

}
