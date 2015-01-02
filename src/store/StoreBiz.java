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
		
		Store findStore = dao.findStore(store.getName(), store.getAddr());
		if(findStore != null) {
			throw new SameStoreExistException();
		}

		int updatedRows = dao.register(store);
		if (updatedRows != 1) {
			throw new DaoRequestFailException();
		}
	}
	
	public ArrayList<Store> retrieve(String storeId, String usrSeq) throws DaoRequestFailException {
		StoreDao dao = new StoreDao();
		
		ArrayList<Store> storeList = dao.retrieve(storeId, usrSeq);
		if(storeList.isEmpty())
			throw new DaoRequestFailException();
		
		return storeList;
	}

	public int save(Employment empt) throws DaoRequestFailException {
		StoreDao dao = new StoreDao();
		int updatedRows = 0;
		
		if(dao.retriveEmpt(empt)==null){
			updatedRows = dao.save(empt);
		}
		
		if (updatedRows != 1) {
			throw new DaoRequestFailException();
		}
		
		return updatedRows;
	}
}