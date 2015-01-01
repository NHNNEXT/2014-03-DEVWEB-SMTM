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
		
		WorkDao dao = new WorkDao();
		ArrayList<Work> workList = null;
		
		if(request.getParameter("storeSeq")==null){
			workList = dao.showWork(usr);
		}
		else{
			String storeSeq = request.getParameter("storeSeq");
			//String storeName = request.getParameter("storeName");
			
			workList = dao.showWorkOfStore(storeSeq);
		}
		request.setAttribute("workList", workList);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/work/showAlbaWork.jsp");
		rd.forward(request, response);	
	}

}
