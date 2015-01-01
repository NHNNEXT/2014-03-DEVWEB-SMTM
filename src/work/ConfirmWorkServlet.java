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

import login.LoginServlet;
import support.SessionUtils;
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
		if (!SessionUtils.isUsrLogin(session, LoginServlet.SESSION_LOGIN_USR)) {
			response.sendRedirect("/jsp");
			return;
		}
		
		ArrayList<WorkAndUsrName> workList = (ArrayList<WorkAndUsrName>)session.getAttribute("workList");
		int idx = Integer.parseInt(request.getParameter("workIdx"));
		Work work = workList.get(idx).getWork();		
	
		ConfirmWorkBiz biz = new ConfirmWorkBiz();
		int updatedRows = biz.confirmWork(work);
		
		if (updatedRows > 0){
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/index.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/error.jsp");
			rd.forward(request, response);
		}
	}

}
