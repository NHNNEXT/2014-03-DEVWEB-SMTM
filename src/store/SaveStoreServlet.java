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
import entity.Employment;
import entity.Usr;

@WebServlet("/SaveStoreServlet")
public class SaveStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		Usr usr = (Usr)session.getAttribute(LoginServlet.SESSION_LOGIN_USR);
		String userSeq = usr.getSeq();
		String storeSeq = request.getParameter("storeSeq");
		
		Employment empt = new Employment(storeSeq, userSeq);
		
		StoreBiz storeBiz = new StoreBiz();
		int updatedRows = storeBiz.save(empt);
		
		if(updatedRows > 0) {
			
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/store/makeSuccess.jsp");
			rd.forward(request, response);
		} else {
			
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/error.jsp");
			rd.forward(request, response);
		}
	
	}

}
