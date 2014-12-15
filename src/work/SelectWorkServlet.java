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

import entity.WorkAndUsrName;

/**
 * Servlet implementation class ConfrimListServlet
 */
@WebServlet("/SelectWorkServlet")
public class SelectWorkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String storeSeq = request.getParameter("storeSeq");
		String storeName = request.getParameter("storeName");
		
		SelectWorkDao dao = new SelectWorkDao();

		ArrayList<WorkAndUsrName> workList = dao.selectWorkDao(storeSeq);
		HttpSession session = request.getSession();
		request.setAttribute("storeName", storeName);
		session.setAttribute("workList", workList);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/work/selectWork.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
