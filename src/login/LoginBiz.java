package login;

import dao.UsrDao;
import entity.Usr;

public class LoginBiz {
	public Usr loginBiz(Usr usr) {

		UsrDao dao = new UsrDao();
		Usr returnUsr = dao.loginDao(usr);
		
		return returnUsr;
	}
}
