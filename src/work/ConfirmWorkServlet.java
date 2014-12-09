package work;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Usr;
import entity.Work;

/**
 * Servlet implementation class ConfirmWorkServlet
 */
@WebServlet("/ConfirmWorkServlet")
public class ConfirmWorkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object workObj = request.getParameter("work");
		Work work = (Work)workObj;
		HttpSession session = request.getSession();
		Usr usr = (Usr)session.getAttribute("loginUsr");
		System.out.println("안녕 워크 ?" + work);
		
		
		ConfirmWorkBiz biz = new ConfirmWorkBiz();
		biz.confirmWorkBiz(usr, work);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
