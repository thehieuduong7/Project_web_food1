package com.DAO;

import com.models.UserLoginModel;

public interface UserLoginDAO {
	public UserLoginModel add(UserLoginModel user);
	public UserLoginModel login(String username,String password);
	public UserLoginModel getByID(int id);

}
