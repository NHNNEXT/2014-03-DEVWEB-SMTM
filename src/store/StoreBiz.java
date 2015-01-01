package store;

import java.util.ArrayList;

import dao.StoreDao;
import entity.Employment;
import entity.Store;

public class StoreBiz {
	public int register(Store store) {	
		StoreDao dao = new StoreDao();
		int updatedRows = dao.register(store);
		return updatedRows;
	}
	
	public ArrayList<Store> retrieve(String storeId, String usrSeq) {
		StoreDao dao = new StoreDao();
		ArrayList<Store> storeList = dao.retrieve(storeId, usrSeq);
		return storeList;
	}

	public int save(Employment empt) {
		StoreDao dao = new StoreDao();
		int updatedRows=0;
		if(dao.retriveEmpt(empt)==null){
			updatedRows = dao.save(empt);
		}
		return updatedRows;
	}
}