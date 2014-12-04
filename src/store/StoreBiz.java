package store;

import java.util.Map;

import entity.Store;

public class StoreBiz {
	public int registerBiz(Store store) {
		
		StoreDao dao = new StoreDao();
		int updatedRows = dao.registerDao(store);
		return updatedRows;
	}

	public Map<String, Store> retrieveBiz(Store store) {
		StoreDao dao = new StoreDao();
		Map<String, Store> storeList = dao.retrieveDao(store);
		return storeList;
	}
	


}