package com.service;

import java.util.Map;

public interface StatisticsService {
	public Map<String,Object> getTongTienDaMua(int id_user);
	public Map<String,Object> getDoanhThuNam(int id_seller,int year);
	public Map<String,Object> getDoanhThuThang(int id_seller,int month,int year);
}
