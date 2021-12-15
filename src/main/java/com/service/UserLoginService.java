package com.service;


import com.models.UserLoginModel;
import com.service.impl.UserLoginServiceImpl;

public interface UserLoginService {
	public UserLoginModel add(UserLoginModel user);
	public UserLoginModel login(String username,String password);
	public UserLoginModel getByID(int id);
	public UserLoginModel register(String username,String Password,String full_name);
	public static void main(String args[]) {
		UserLoginService ser = new UserLoginServiceImpl();
		System.out.print(ser.register("19110342@student.hcmute.edu.vn","1","Duong"));
	}
}
