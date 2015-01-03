package work;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
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
import dao.WorkDao;
import entity.Usr;
import entity.Work;
import exception.InvalidAccessException;

@WebServlet("/ShowWorkListServlet")
public class ShowWorkListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Usr usr = SessionUtils.getValue(session, LoginServlet.SESSION_LOGIN_USR);
		if (usr == null)
			throw new InvalidAccessException();
		
		ShowWorkListBiz biz = new ShowWorkListBiz();
	    Map<String, List<Work>> workMap= null;
		Map<String, Long> confirmedMoneyMap=null;
		Map<String, Long> totalMoneyMap=null;
		
		if(request.getParameter("storeSeq")==null){
			workMap = biz.selectWorkForAlba(usr);
		}
		else{
			String storeSeq = request.getParameter("storeSeq");
			workMap = biz.selectWorkForManager(storeSeq);
		}
		try {
			confirmedMoneyMap = biz.calculateConfirmedMoney();
			totalMoneyMap = biz.calculateTotalMoney();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("workMap", workMap);
		request.setAttribute("confirmedMoneyMap", confirmedMoneyMap);
		request.setAttribute("totalMoneyMap", totalMoneyMap);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/work/showAlbaWork.jsp");
		rd.forward(request, response);	
	}

}
