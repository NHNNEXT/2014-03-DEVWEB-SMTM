package login;

import dao.UsrDao;
import entity.Usr;
import exception.PasswordMismatchException;
import exception.UsrNotFoundException;

public class LoginBiz {
	public Usr login(String loginId, String loginPw) throws UsrNotFoundException, PasswordMismatchException {
		UsrDao dao = new UsrDao();
		Usr usr = dao.findUsrById(loginId);
		
		if(usr == null) {
			throw new UsrNotFoundException("Id가 존재하지 않습니다.");
		}
		
		if(!usr.checkPassword(loginPw)) {
			throw new PasswordMismatchException("비밀번호가 틀립니다.");
		}
		
		return usr;
	}
}
