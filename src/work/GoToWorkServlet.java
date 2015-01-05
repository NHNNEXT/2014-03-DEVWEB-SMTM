package work;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import support.SessionUtils;
import login.LoginServlet;
import entity.User;
import exception.DaoRequestFailException;
import exception.InvalidAccessException;

@WebServlet("/GoToWorkServlet")
public class GoToWorkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User usr = SessionUtils.getValue(session, LoginServlet.SESSION_LOGIN_USR);
		String storeSeq = request.getParameter("storeSeq");
		if (usr == null || storeSeq == null)
			throw new InvalidAccessException();

		WorkBiz biz = new WorkBiz();
		try {
			biz.goToWork(usr, storeSeq);
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/success.jsp");
			rd.forward(request, response);
		} catch (DaoRequestFailException e) {
			request.setAttribute("errorMessage", e.getErrorMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/work/selectStore.jsp");
			rd.forward(request, response);
		}
	}

}
