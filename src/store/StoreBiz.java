package store;

import java.util.ArrayList;

import dao.StoreDao;
import entity.Employment;
import entity.Store;
import exception.DaoRequestFailException;
import exception.SameStoreExistException;

public class StoreBiz {
	public void register(Store store) throws SameStoreExistException, DaoRequestFailException {	
		StoreDao dao = new StoreDao();
		
		Store findStore = dao.retriveStoreForMake(store.getName(), store.getAddr());
		if(findStore != null) {
			throw new SameStoreExistException();
		}

		int updatedRows = dao.insertStore(store);
		if (updatedRows != 1) {
			throw new DaoRequestFailException();
		}
	}
	
	public ArrayList<Store> retrieve(String storeName, String usrSeq) throws DaoRequestFailException {
		StoreDao dao = new StoreDao();
		
		ArrayList<Store> storeList = dao.retrieveStoreForEmpt(storeName, usrSeq);
		if(storeList.isEmpty())
			throw new DaoRequestFailException();
		
		return storeList;
	}

	public int save(Employment empt) throws DaoRequestFailException {
		StoreDao dao = new StoreDao();
		int updatedRows = dao.insertEmpt(empt);
		
		if (updatedRows != 1) {
			throw new DaoRequestFailException();
		}
		
		return updatedRows;
	}
}