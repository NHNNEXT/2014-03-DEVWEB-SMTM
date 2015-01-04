package work;

import dao.WorkDao;
import entity.Work;

public class ConfirmWorkBiz {

	public int confirmWork(Work work) {
		WorkDao dao = new WorkDao();
		int updatedRows;
		String stus = work.getStatus();
		
		if(stus.equals("1001"))
			updatedRows = dao.confirmGoToWork(work);
		
		else if(stus.equals("1002"))
			updatedRows = dao.confirmBoth(work);
		
		else
			updatedRows = dao.confirmLeaveWork(work);
		
		return updatedRows;
	}
}
