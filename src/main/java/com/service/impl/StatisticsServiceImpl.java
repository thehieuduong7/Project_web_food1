package com.service.impl;

import java.util.Map;

import com.DAO.StatisticsDAO;
import com.DAO.Impl.StatisticsDAOImpl;
import com.service.StatisticsService;

public class StatisticsServiceImpl implements StatisticsService{

	StatisticsDAO staDAO = new StatisticsDAOImpl();
	@Override
	public Map<String, Object> getTongTienDaMua(int id_user) {
		return staDAO.getTongTienDaMua(id_user);
	}

	@Override
	public Map<String, Object> getDoanhThuNam(int id_seller, int year) {
		// TODO Auto-generated method stub
		return staDAO.getDoanhThuNam(id_seller, year);
	}

	@Override
	public Map<String, Object> getDoanhThuThang(int id_seller, int month, int year) {
		// TODO Auto-generated method stub
		return staDAO.getDoanhThuThang(id_seller, month, year);
	}









}
