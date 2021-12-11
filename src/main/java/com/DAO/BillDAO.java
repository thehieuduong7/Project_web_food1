package com.DAO;
import java.util.List;

import com.models.*;

public interface BillDAO {
	public List<BillModel> getAllBill();
	public BillModel getBillByID(int id_bill);
	public List<BillModel> getBillByIDUser(int id_user);
	public List<BillDetailModel> getBillDetail(int id_bill);
	public boolean insertBill(BillModel bill,List<BillDetailModel> listBillDetail);
}
