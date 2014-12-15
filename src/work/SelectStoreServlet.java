package work;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Store;
import entity.Usr;

@WebServlet("/SelectStoreServlet")
public class SelectStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		Usr usr = (Usr)session.getAttribute("loginUsr");
		
		SelectStoreBiz biz = new SelectStoreBiz();
		ArrayList<Store> storeList = biz.selectStoreBiz(usr);

		request.setAttribute("storeList", storeList);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/work/selectStore.jsp");
		rd.forward(request, response);	
	}

}
