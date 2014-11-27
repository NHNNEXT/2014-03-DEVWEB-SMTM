package register;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Usr;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/register/register.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String registerId = request.getParameter("registerId");
		String registerPw = request.getParameter("registerPw");
		String registerName = request.getParameter("registerName");
		String registerPhone1_0 = request.getParameter("registerPhone1_0");
		String registerPhone1_1 = request.getParameter("registerPhone1_1");
		String registerPhone1_2 = request.getParameter("registerPhone1_2");
		String registerPhone1 = registerPhone1_0+"-"+registerPhone1_1+"-"+registerPhone1_2;
		String registerGender = request.getParameter("registerGender");
		String registerBirth = request.getParameter("registerBirth");
		
		Usr usr = new Usr(registerId, registerPw, registerName, registerPhone1, registerGender, registerBirth);
		System.out.println("usr :"+usr);
		
		RegisterBiz registerBiz = new RegisterBiz();
		int updatedRows = registerBiz.registerBiz(usr);
		
		if(updatedRows > 0) {
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/registerSuccess.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/error.jsp");
			rd.forward(request, response);
		}
	}

}
