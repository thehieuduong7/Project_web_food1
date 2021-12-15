package com.service.impl;

import com.DAO.UserLoginDAO;
import com.DAO.Impl.UserLoginDAOImpl;
import com.models.UserLoginModel;
import com.service.UserLoginService;

public class UserLoginServiceImpl implements UserLoginService {
	UserLoginDAO dao =new UserLoginDAOImpl();
	@Override
	public UserLoginModel add(UserLoginModel user) {
		// TODO Auto-generated method stub
		return dao.add(user);
	}

	@Override
	public UserLoginModel login(String username, String password) {
		// TODO Auto-generated method stub
		return dao.login(username, password);
	}

	@Override
	public UserLoginModel getByID(int id) {
		// TODO Auto-generated method stub
		return dao.getByID(id);
	}

	@Override
	public UserLoginModel register(String username, String password, String full_name) {
		// TODO Auto-generated method stub
		UserLoginModel user= new UserLoginModel(1,full_name,username,password,"user");
		return dao.add(user);
	}

}
