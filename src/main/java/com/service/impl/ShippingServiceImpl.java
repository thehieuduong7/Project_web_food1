package com.service.impl;

import java.util.List;

import com.DAO.ShippingDAO;
import com.DAO.Impl.ShippingDAOImpl;
import com.models.ShipModel;
import com.service.ShippingService;

public class ShippingServiceImpl implements ShippingService {
	ShippingDAO shipDAO = new ShippingDAOImpl();
	@Override
	public List<ShipModel> getAll() {
		// TODO Auto-generated method stub
		return shipDAO.getAll();
	}

}
