package store;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import support.SessionUtils;
import login.LoginServlet;
import entity.Store;
import entity.Usr;
import exception.DaoRequestFailException;
import exception.InvalidAccessException;

@WebServlet("/SelectStoreServlet")
public class SelectStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Usr usr = SessionUtils.getValue(session, LoginServlet.SESSION_LOGIN_USR);
		if (usr == null)
			throw new InvalidAccessException();

		try {
			SelectStoreBiz biz = new SelectStoreBiz();
			ArrayList<Store> storeList = biz.selectStore(usr);
			
			request.setAttribute("storeList", storeList);
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/work/selectStore.jsp");
			rd.forward(request, response);	
		} catch (DaoRequestFailException e) {

		}

	}

}
