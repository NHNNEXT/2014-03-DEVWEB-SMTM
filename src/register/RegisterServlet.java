package register;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import support.MyValidatorFactory;
import entity.User;
import exception.DaoRequestFailException;
import exception.SameUserIdExistException;

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
		String registerType = request.getParameter("registerType");
		String registerPhone0 = request.getParameter("registerPhone0");
		String registerPhone1 = request.getParameter("registerPhone1");
		String registerPhone2 = request.getParameter("registerPhone2");
		String registerPhone = registerPhone0+"-"+registerPhone1+"-"+registerPhone2;
		String registerGender = request.getParameter("registerGender");
		String registerBirth = request.getParameter("registerBirth");
		
		
		User user = new User(registerId, registerPw, registerName, registerType, registerPhone, registerGender, registerBirth);
		
		Validator validator = MyValidatorFactory.createValidator();
		Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
		if(constraintViolations.size() > 0) {
			String errorMessage = MyValidatorFactory.getErrorMessage(constraintViolations);
			request.setAttribute("inputUsr", user);
			forwardJSP(request, response, errorMessage);
			return;
		}
		
		
		try {
			RegisterBiz registerBiz = new RegisterBiz();
			registerBiz.register(user);
			response.sendRedirect("/jsp/register/registerSuccess.jsp");
		} catch (SameUserIdExistException e) {
			forwardJSP(request, response, e.getErrorMessage());
		} catch (DaoRequestFailException e) {
			forwardJSP(request, response, e.getErrorMessage());
		}
	}

	private void forwardJSP(HttpServletRequest request,
			HttpServletResponse response, String message)
			throws ServletException, IOException {
		request.setAttribute("errorMessage", message);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/register/register.jsp");
		rd.forward(request,response);
	}

}
