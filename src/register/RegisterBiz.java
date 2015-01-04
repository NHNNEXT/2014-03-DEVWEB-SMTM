package register;

import dao.UsrDao;
import entity.User;
import exception.DaoRequestFailException;
import exception.SameUsrIdExistException;

public class RegisterBiz {
	public void register(User usr) throws SameUsrIdExistException, DaoRequestFailException {		
		UsrDao dao = new UsrDao();
		
		User findUsr = dao.selectUsrById(usr.getId());
		if(findUsr != null) {
			throw new SameUsrIdExistException();
		}
		
		int updatedRows = dao.insertUsr(usr);
		if(updatedRows != 1) {
			throw new DaoRequestFailException();
		}
	}
	
}