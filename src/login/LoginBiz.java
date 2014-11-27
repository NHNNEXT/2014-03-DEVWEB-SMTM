package login;

import entity.Usr;

public class LoginBiz {
	public Usr loginBiz(Usr usr) {

		LoginDao dao = new LoginDao();
		Usr returnUsr = dao.loginDao(usr);
		
		return returnUsr;
	}
}
