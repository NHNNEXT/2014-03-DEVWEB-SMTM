package register;

import dao.UsrDao;
import entity.Usr;
import exception.DaoRequestFailException;
import exception.SameUsrIdExistException;

public class RegisterBiz {
	public void register(Usr usr) throws SameUsrIdExistException, DaoRequestFailException {		
		UsrDao dao = new UsrDao();
		
		Usr findUsr = dao.findUsrById(usr.getId());
		if(findUsr != null) {
			throw new SameUsrIdExistException();
		}
		
		int updatedRows = dao.register(usr);
		if(updatedRows != 1) {
			throw new DaoRequestFailException();
		}
	}
	
}