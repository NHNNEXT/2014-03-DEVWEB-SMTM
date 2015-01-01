package register;

import dao.UsrDao;
import entity.Usr;
import exception.RegisterUsrException;
import exception.SameUsrIdExistException;

public class RegisterBiz {
	public void registerBiz(Usr usr) throws SameUsrIdExistException, RegisterUsrException {
		int updatedRows = 0;
		
		UsrDao dao = new UsrDao();
		
		Usr findUsr = dao.findUsrById(usr.getId());
		if(findUsr != null) {
			throw new SameUsrIdExistException();
		}
		
		updatedRows = dao.register(usr);
		if(updatedRows != 1) {
			throw new RegisterUsrException();
		}	
	}
	
}