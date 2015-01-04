package register;

import dao.UserDao;
import entity.User;
import exception.DaoRequestFailException;
import exception.SameUsrIdExistException;

public class RegisterBiz {
	public void register(User user) throws SameUsrIdExistException, DaoRequestFailException {		
		UserDao dao = new UserDao();
		
		User findUsr = dao.selectUsrById(user.getId());
		if(findUsr != null) {
			throw new SameUsrIdExistException();
		}
		
		int updatedRows = dao.insertUsr(user);
		if(updatedRows != 1) {
			throw new DaoRequestFailException();
		}
	}
	
}