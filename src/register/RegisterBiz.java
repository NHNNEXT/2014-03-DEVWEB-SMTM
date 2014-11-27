package register;

import entity.Usr;

public class RegisterBiz {
	public int registerBiz(Usr usr) {
		RegisterDao dao = new RegisterDao();
		
		int updatedRows = dao.registerDao(usr);
		
		return updatedRows;
	}
}