package work;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import support.SessionUtils;
import login.LoginServlet;
import entity.User;
import entity.Work;
import exception.InvalidAccessException;

@WebServlet("/ShowWorkListServlet")
public class ShowWorkListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User usr = SessionUtils.getValue(session, LoginServlet.SESSION_LOGIN_USR);
		if (usr == null)
			throw new InvalidAccessException();
		
		String storeSeq = request.getParameter("storeSeq");
		ShowWorkListBiz biz = new ShowWorkListBiz();
		Map<String, List<Work>> workMap = null;
		Map<String, Long> confirmedMoneyMap = null;
		Map<String, Long> totalMoneyMap = null;

		workMap = biz.selectWork(usr, storeSeq);
		try {
			biz.calculate();
			confirmedMoneyMap = biz.getConfirmedMoneyMap();
			totalMoneyMap = biz.getTotalMoneyMap();
		} catch (ParseException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "날짜 형식에 문제가 발생할 수 있습니다.");
		}
		System.out.println(workMap);
		request.setAttribute("workMap", workMap);
		request.setAttribute("confirmedMoneyMap", confirmedMoneyMap);
		request.setAttribute("totalMoneyMap", totalMoneyMap);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/work/showAlbaWork.jsp");
		rd.forward(request, response);
	}

}
