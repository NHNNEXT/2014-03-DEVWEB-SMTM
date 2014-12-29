package register;

import dao.UsrDao;
import entity.Usr;

public class RegisterBiz {
	public int registerBiz(Usr usr) {
		UsrDao dao = new UsrDao();
		
		int updatedRows = dao.registerDao(usr);
		
		return updatedRows;
	}
}