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
import dao.StoreDao;
import entity.Store;
import entity.User;
import exception.InvalidAccessException;

@WebServlet("/ShowStoreListServlet")
public class ShowStoreListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User usr = SessionUtils.getValue(session, LoginServlet.SESSION_LOGIN_USR);
		if (usr == null)
			throw new InvalidAccessException();

		StoreDao dao = new StoreDao();
		ArrayList<Store> storeList = dao.selectStoreForManager(usr);
		
		request.setAttribute("storeList", storeList);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/work/showStoreList.jsp");
		rd.forward(request, response);
	}

}
