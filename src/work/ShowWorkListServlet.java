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
import entity.Work;
import entity.WorkAndUsrName;

/**
 * Servlet implementation class ShowWorkList
 */
@WebServlet("/ShowWorkListServlet")
public class ShowWorkListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		Usr usr = (Usr)session.getAttribute("loginUsr");
		ShowWorkDao dao = new ShowWorkDao();
		ArrayList<Work> workList = null;
		
		if(request.getParameter("storeSeq")==null){
			workList = dao.showWorkDao(usr);
		}
		else{
			String storeSeq = request.getParameter("storeSeq");
			String storeName = request.getParameter("storeName");
			
			workList = dao.showWorkOfStoreDao(storeSeq);
		}
		request.setAttribute("workList", workList);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/work/showAlbaWork.jsp");
		rd.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
