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
import exception.InvalidAccessException;

@WebServlet("/RetrieveStoreListServlet")
public class RetrieveStoreListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (SessionUtils.isEmpty(session, LoginServlet.SESSION_LOGIN_USR))
			throw new InvalidAccessException();
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/store/findStore.jsp");
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		Usr usr = SessionUtils.getValue(session, LoginServlet.SESSION_LOGIN_USR);
		if (usr == null)
			throw new InvalidAccessException();
		
		String usrSeq = usr.getSeq();
		String storeId = request.getParameter("storeId");
		StoreBiz biz = new StoreBiz();
		
		ArrayList<Store> storeList = biz.retrieve(storeId, usrSeq);
		
		if(storeList !=null){
			request.setAttribute("storeList",storeList);
			
		} else {
			//alert 띄워주기
		}
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/store/findStore.jsp");
		rd.forward(request,response);
	}

}

