package login;

import dao.UsrDao;
import entity.User;
import exception.PasswordMismatchException;
import exception.UsrNotFoundException;

public class LoginBiz {
	public User login(String loginId, String loginPw) throws UsrNotFoundException, PasswordMismatchException {
		UsrDao dao = new UsrDao();
		User usr = dao.selectUsrById(loginId);
		
		if(usr == null) {
			throw new UsrNotFoundException();
		}
		
		if(!usr.checkPassword(loginPw)) {
			throw new PasswordMismatchException();
		}
		
		return usr;
	}
}
