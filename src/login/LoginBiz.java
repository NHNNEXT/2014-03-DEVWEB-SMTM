package login;

import dao.UserDao;
import entity.User;
import exception.PasswordMismatchException;
import exception.UserNotFoundException;

public class LoginBiz {
	public User login(String loginId, String loginPw) throws UserNotFoundException, PasswordMismatchException {
		UserDao dao = new UserDao();
		User usr = dao.selectUsrById(loginId);

		if (usr == null) {
			throw new UserNotFoundException();
		}

		if (!usr.checkPassword(loginPw)) {
			throw new PasswordMismatchException();
		}

		return usr;
	}
}
