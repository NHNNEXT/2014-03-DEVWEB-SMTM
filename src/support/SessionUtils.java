package support;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

public class SessionUtils {
	public static boolean isEmpty(HttpSession session, String key) {
		Object object = session.getAttribute(key);
		if (object == null) {
			return true;
		}
		return false;
	}
	
	public static <T> T getValue(HttpSession session, String key) {
		Object object = session.getAttribute(key);
		if (object == null)
			return null;
		
		return (T)object;
	}
}
