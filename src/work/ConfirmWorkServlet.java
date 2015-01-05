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
import exception.DaoRequestFailException;
import exception.InvalidAccessException;

@WebServlet("/ConfirmWorkServlet")
public class ConfirmWorkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String workIdx = request.getParameter("workIdx");
		if (SessionUtils.isEmpty(session, LoginServlet.SESSION_LOGIN_USR) || workIdx == null)
			throw new InvalidAccessException();

		ArrayList<Work> workList = (ArrayList<Work>) session.getAttribute("workList");
		int idx = Integer.parseInt(workIdx);
		Work work = workList.get(idx);

		WorkBiz biz = new WorkBiz();
		try {
			biz.confirmWork(work);
			session.removeAttribute("workList");
			response.sendRedirect("/jsp/success.jsp");
		} catch (DaoRequestFailException e) {
			session.removeAttribute("workList");
			request.setAttribute("errorMessage", e.getErrorMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/");
			rd.forward(request, response);
		}
	}
}
