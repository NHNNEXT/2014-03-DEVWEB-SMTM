package work;

import java.util.ArrayList;

import entity.Store;
import entity.Usr;

public class SelectStoreBiz {
	public ArrayList<Store> selectStoreBiz(Usr usr) {
		WorkDao dao = new WorkDao();
		ArrayList<Store> storeList = null;

		
		if(usr.getType().equals("2001"))
		{
			storeList = dao.selectStoreForAlba(usr);
		}
			
		if(usr.getType().equals("2002"))
		{
			storeList = dao.selectStoreForManager(usr);
			System.out.println(2002);
		}
			
		
		return storeList;
	}
}
