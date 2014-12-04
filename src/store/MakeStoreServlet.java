package store;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Store;
import entity.Usr;


@WebServlet("/MakeStoreServlet")
public class MakeStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/store/makeStore.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session= request.getSession();
		Usr usr = (Usr)session.getAttribute("loginUsr");
		
		String registerUsrId = usr.getId();
		String registerName = request.getParameter("registerName");
		String registerAddr = request.getParameter("registerAddr");
		String registerPhone1_0 = request.getParameter("registerPhone1_0");
		String registerPhone1_1 = request.getParameter("registerPhone1_1");
		String registerPhone1_2 = request.getParameter("registerPhone1_2");
		String registerPhone1 = registerPhone1_0+"-"+registerPhone1_1+"-"+registerPhone1_2;
		
		Store store = new Store(registerUsrId, registerName, registerAddr, registerPhone1);
		System.out.println("store :"+store);
		
		StoreBiz storeBiz = new StoreBiz();
		int updatedRows = storeBiz.registerBiz(store);
		
		if(updatedRows > 0) {
			
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/store/makeSuccess.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/error.jsp");
			rd.forward(request, response);
		}
	}

}
