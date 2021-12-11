package com.service;

import java.util.List;

import com.models.CommentModel;

public interface CommentService {
	public List<CommentModel> getCommentByIDProduct(int id_product);
	public boolean insert(CommentModel comment);
	public boolean remove(int id_comment);
	public boolean update(CommentModel comment);
}
