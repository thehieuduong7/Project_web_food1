package com.service;

import java.util.List;

import com.models.UserLoginModel;

public interface UserLoginService {
	public boolean add(UserLoginModel user);
	public boolean edit(UserLoginModel user);
	public boolean remove(int id_user);
	public List<UserLoginModel> getAll();
}
