package store;

import java.util.Map;

import entity.Employment;
import entity.Store;

public class StoreBiz {
	public int registerBiz(Store store) {
		
		StoreDao dao = new StoreDao();
		int updatedRows = dao.registerDao(store);
		return updatedRows;
	}
	public Map<String, Store> retrieveBiz(String storeId, String usrSeq) {
		StoreDao dao = new StoreDao();
		Map<String, Store> storeList = dao.retrieveDao(storeId, usrSeq);
		return storeList;
	}

	public int saveBiz(Employment empt) {
		StoreDao dao = new StoreDao();
		int updatedRows=0;
		if(dao.checkDuplicationEmptDao(empt)==false){
			updatedRows = dao.saveDao(empt);
		}
		return updatedRows;
	}


	


}