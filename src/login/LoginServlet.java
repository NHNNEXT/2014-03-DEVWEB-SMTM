package login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import support.SessionUtils;
import entity.User;
import exception.InvalidAccessException;
import exception.PasswordMismatchException;
import exception.UserNotFoundException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	public static final String SESSION_LOGIN_USR = "loginUsr";
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (!SessionUtils.isEmpty(session, SESSION_LOGIN_USR))
			throw new InvalidAccessException();
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/login/login.jsp");		
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginId = request.getParameter("loginId");
		String loginPw = request.getParameter("loginPw");
		
		try {
			LoginBiz biz = new LoginBiz();
			User user = biz.login(loginId, loginPw);			
			HttpSession session = request.getSession();
			session.setAttribute(SESSION_LOGIN_USR, user);
			response.sendRedirect("/jsp/");
		} catch (UserNotFoundException e) {
			forwardJSP(request, response, e.getErrorMessage());
		} catch (PasswordMismatchException e) {
			forwardJSP(request, response, e.getErrorMessage());
		}
	}

	private void forwardJSP(HttpServletRequest request,
			HttpServletResponse response, String message)
			throws ServletException, IOException {
		request.setAttribute("errorMessage", message);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/login/login.jsp");
		rd.forward(request,response);
	}

}
