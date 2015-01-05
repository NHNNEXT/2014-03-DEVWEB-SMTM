package store;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import login.LoginServlet;
import support.MyValidatorFactory;
import support.SessionUtils;
import entity.Store;
import entity.User;
import exception.DaoRequestFailException;
import exception.InvalidAccessException;
import exception.SameStoreExistException;

@WebServlet("/MakeStoreServlet")
public class MakeStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (SessionUtils.isEmpty(session, LoginServlet.SESSION_LOGIN_USR))
			throw new InvalidAccessException();

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/store/makeStore.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		HttpSession session = request.getSession();
		User user = SessionUtils.getValue(session, LoginServlet.SESSION_LOGIN_USR);
		if (user == null)
			throw new InvalidAccessException();

		String registerUserSeq = user.getSeq();
		String registerName = request.getParameter("registerName");
		String registerAddr = request.getParameter("registerAddr");
		String registerPhone0 = request.getParameter("registerPhone0");
		String registerPhone1 = request.getParameter("registerPhone1");
		String registerPhone2 = request.getParameter("registerPhone2");
		String registerPhone = registerPhone0 + "-" + registerPhone1 + "-" + registerPhone2;

		Store store = new Store(registerUserSeq, registerName, registerAddr, registerPhone);
		checkValidateStore(request, response, store);

		try {
			StoreBiz storeBiz = new StoreBiz();
			storeBiz.register(store);
			response.sendRedirect("/jsp/success.jsp");
		} catch (SameStoreExistException e) {
			e.printStackTrace();
			forwardJSP(request, response, e.getMessage());
		} catch (DaoRequestFailException e) {
			e.printStackTrace();
			forwardJSP(request, response, e.getMessage());
		}
	}

	private void checkValidateStore(HttpServletRequest request, HttpServletResponse response, Store store)
			throws ServletException, IOException {
		Validator validator = MyValidatorFactory.createValidator();
		Set<ConstraintViolation<Store>> constraintViolations = validator.validate(store);
		if (constraintViolations.size() > 0) {
			String errorMessage = MyValidatorFactory.getErrorMessage(constraintViolations);
			request.setAttribute("inputStore", store);
			forwardJSP(request, response, errorMessage);
			return;
		}
	}

	private void forwardJSP(HttpServletRequest request, HttpServletResponse response, String message)
			throws ServletException, IOException {
		request.setAttribute("errorMessage", message);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/store/makeStore.jsp");
		rd.forward(request, response);
	}

}
