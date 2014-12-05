package work;

import java.util.ArrayList;

import store.StoreDao;
import entity.Store;
import entity.Usr;

public class ConfirmWorkBiz {

	public ArrayList<Store> confirmWorkBiz(Usr usr) {
		ConfirmWorkDao dao = new ConfirmWorkDao();
		int updatedRows;
//		
//		if("출근승인"){ 
//			updatedRows = dao.confirmGoToWorkDao(usr);
//		}
//		else // 퇴근승인
//		{
//			updatedRows = dao.confirmGoToWorkDao(usr);
//		}
//		
		return null;
	}
	public int registerBiz(Store store) {
		
		StoreDao dao = new StoreDao();
		int updatedRows = dao.registerDao(store);
		return updatedRows;
	}
}
