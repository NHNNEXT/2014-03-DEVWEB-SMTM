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

@WebServlet("/SelectWorkServlet")
public class SelectWorkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String storeSeq = request.getParameter("storeSeq");
		String storeName = request.getParameter("storeName");
		if (SessionUtils.isEmpty(session, LoginServlet.SESSION_LOGIN_USR) || storeSeq == null || storeName == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/");
			rd.forward(request, response);
		}

		WorkBiz biz = new WorkBiz();
		ArrayList<Work> workList = biz.selectWork(storeSeq);

		request.setAttribute("storeName", storeName);
		session.setAttribute("workList", workList);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/work/selectWork.jsp");
		rd.forward(request, response);
	}

}
