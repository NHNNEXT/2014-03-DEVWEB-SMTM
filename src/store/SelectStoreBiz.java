package store;

import java.util.ArrayList;

import dao.StoreDao;
import entity.Store;
import entity.User;

public class SelectStoreBiz {
	public ArrayList<Store> selectStore(User usr) {
		StoreDao dao = new StoreDao();
		ArrayList<Store> storeList = null;

		if (usr.isAlba())
			storeList = dao.selectStoreForAlba(usr);

		if (usr.isManager())
			storeList = dao.selectStoreForManager(usr);
		
		return storeList;
	}
}
