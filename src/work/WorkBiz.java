package work;

import java.util.ArrayList;

import dao.WorkDao;
import entity.User;
import entity.Work;
import exception.DaoRequestFailException;

public class WorkBiz {

	public void leaveWork(User usr, String storeSeq) throws DaoRequestFailException {
		WorkDao dao = new WorkDao();
		int updatedRows = dao.insertLeaveWork(usr, storeSeq);

		if (updatedRows != 1)
			throw new DaoRequestFailException();
	}

	public void goToWork(User usr, String storeSeq) throws DaoRequestFailException {
		WorkDao dao = new WorkDao();
		int updatedRows = dao.insertGoToWork(usr, storeSeq);

		if (updatedRows != 1)
			throw new DaoRequestFailException();
	}

	public int confirmWork(Work work) throws DaoRequestFailException {
		WorkDao dao = new WorkDao();
		String stus = work.getStatus();
		int updatedRows;

		if (stus.equals("1001"))
			updatedRows = dao.confirmGoToWork(work);

		else if (stus.equals("1002"))
			updatedRows = dao.confirmBoth(work);

		else
			updatedRows = dao.confirmLeaveWork(work);

		if (updatedRows != 1) 
			throw new DaoRequestFailException();
		
		return updatedRows;
	}

	public ArrayList<Work> selectWork(String storeSeq) {
		WorkDao dao = new WorkDao();
		ArrayList<Work> workList = dao.selectWork(storeSeq);

		return workList;
	}
}
