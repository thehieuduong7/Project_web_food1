package com.DAO;

import java.util.Map;

public interface StatisticsDAO {
	public Map<String,Object> getTongTienDaMua(int id_user);
	public Map<String,Object> getDoanhThuNam(int id_seller,int year);
	public Map<String,Object> getDoanhThuThang(int id_seller,int month,int year);
}
