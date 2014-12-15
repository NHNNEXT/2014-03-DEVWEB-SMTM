package work;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Usr;
import entity.Work;
import entity.WorkAndUsrName;

/**
 * Servlet implementation class ConfirmWorkServlet
 */
@WebServlet("/ConfirmWorkServlet")
public class ConfirmWorkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<WorkAndUsrName> workList = (ArrayList<WorkAndUsrName>)session.getAttribute("workList");
		int idx = Integer.parseInt(request.getParameter("workIdx"));
		Work work = workList.get(idx).getWork();		
		System.out.println(work);
		
		
		//ConfirmWorkBiz biz = new ConfirmWorkBiz();
		//biz.confirmWorkBiz(usr, work);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
