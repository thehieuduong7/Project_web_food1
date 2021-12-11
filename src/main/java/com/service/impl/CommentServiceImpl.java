package com.service.impl;

import java.util.List;

import com.DAO.CommentDAO;
import com.DAO.Impl.CommentDAOImpl;
import com.models.CommentModel;
import com.service.CommentService;

public class CommentServiceImpl implements CommentService{
	
	CommentDAO cmtDAO = new CommentDAOImpl();
	@Override
	public List<CommentModel> getCommentByIDProduct(int id_product) {
		return cmtDAO.getCommentByIDProduct(id_product);
	}

	@Override
	public boolean insert(CommentModel comment) {
		return cmtDAO.insert(comment);
	}

	@Override
	public boolean remove(int id_comment) {
		return cmtDAO.remove(id_comment);
	}

	@Override
	public boolean update(CommentModel comment) {
		return cmtDAO.update(comment);
	}

}
