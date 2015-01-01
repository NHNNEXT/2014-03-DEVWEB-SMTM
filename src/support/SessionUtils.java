package support;

import javax.servlet.http.HttpSession;

import login.LoginServlet;
import entity.Usr;

public class SessionUtils {
	public static boolean isEmpty(HttpSession session, String key) {
		Object object = session.getAttribute(key);
		if (object == null) {
			return true;
		}
		return false;
	}
	
	public static <T> T getValue(HttpSession session, String key) {
		if(isEmpty(session, key)) {
			return null;
		}
		return (T)session.getAttribute(key);
	}
	
	public static boolean isUsrLogin(HttpSession session, String loginId) {
		Usr usr = getValue(session, LoginServlet.SESSION_LOGIN_USR);
		if (usr == null) {
			return false;
		}
		return true;
	}
}
