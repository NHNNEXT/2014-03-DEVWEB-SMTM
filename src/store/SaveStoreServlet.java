package store;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.LoginServlet;
import support.SessionUtils;
import entity.Employment;
import entity.Usr;
import exception.DaoRequestFailException;
import exception.InvalidAccessException;

@WebServlet("/SaveStoreServlet")
public class SaveStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		Usr usr = SessionUtils.getValue(session, LoginServlet.SESSION_LOGIN_USR);
		if (usr == null)
			throw new InvalidAccessException();
		
		String userSeq = usr.getSeq();
		String storeSeq = request.getParameter("storeSeq");
		
		Employment empt = new Employment(storeSeq, userSeq);
		
		try {
			StoreBiz storeBiz = new StoreBiz();
			storeBiz.save(empt);
			response.sendRedirect("/jsp/store/success.jsp");
		} catch (DaoRequestFailException e) {
			request.setAttribute("errorMessage", e.getErrorMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/store/findStore.jsp");
			rd.forward(request,response);
		}
	}

}
