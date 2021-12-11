package com.service;
import java.util.List;

import com.models.*;

public interface BillService {
	public List<BillModel> getAllBill();
	public BillModel getBillById(int id_bill);
	public List<BillModel> getBillByIDUser(int id_user);
	public List<BillDetailModel> getBillDetail(int id_bill);
	public boolean insertBill(BillModel bill,List<BillDetailModel> listBillDetail);
	public boolean payment(int id_user,String city_ship);
}
