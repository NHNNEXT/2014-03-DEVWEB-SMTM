package work;

import entity.Work;

public class ConfirmWorkBiz {

	public int confirmWorkBiz(Work work) {
		ConfirmWorkDao dao = new ConfirmWorkDao();
		int updatedRows;
		String stus = work.getStus();
		
		if(stus.equals("1001"))
			updatedRows = dao.confirmGoToWork(work);
		
		else if(stus.equals("1002"))
			updatedRows = dao.confirmBoth(work);
		
		else
			updatedRows = dao.confirmLeaveWork(work);
		
		return updatedRows;
	}
}
