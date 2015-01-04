package store;

import java.util.ArrayList;

import dao.StoreDao;
import entity.Store;
import entity.User;
import exception.DaoRequestFailException;

public class SelectStoreBiz {
	public ArrayList<Store> selectStore(User usr) throws DaoRequestFailException {
		StoreDao dao = new StoreDao();
		ArrayList<Store> storeList = null;

		if (usr.getType().equals("2001")) {
			storeList = dao.selectStoreForAlba(usr);
		}

		if (usr.getType().equals("2002")) {
			storeList = dao.selectStoreForManager(usr);
			System.out.println(2002);
		}

		if (storeList.isEmpty())
			throw new DaoRequestFailException();

		return storeList;
	}
}
