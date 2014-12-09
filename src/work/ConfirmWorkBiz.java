package work;

import java.util.ArrayList;

import store.StoreDao;
import entity.Store;
import entity.Usr;
import entity.Work;

public class ConfirmWorkBiz {

	public ArrayList<Store> confirmWorkBiz(Usr usr, Work work) {
		ConfirmWorkDao dao = new ConfirmWorkDao();
		
		if(work.getStus() == "1001")
		{
			// 출근 승인만 한다
		} else if(work.getStus() == "1002" && work.getStartConfirm() == "NULL")
		{
			// 
		} else if(work.getStus() == "1002" && work.getStartConfirm() != "NULL")
		{
			
		}
		else
		{
			
		}
		return null;
	}
}
