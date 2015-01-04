package support;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import exception.DbAccessException;
import exception.InvalidAccessException;

@WebFilter("/*")
public class ExceptionFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {
			chain.doFilter(request, response);
		} catch (DbAccessException e) {
			e.printStackTrace();
			forwardJSP(request, response, e.getErrorMessage());

		} catch (InvalidAccessException e) {
			e.printStackTrace();
			forwardJSP(request, response, e.getErrorMessage());
		}
	}

	public void destroy() {
	}
	
	private void forwardJSP(ServletRequest request,
			ServletResponse response, String message)
			throws ServletException, IOException {
		request.setAttribute("errorMessage", message);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/");
		rd.forward(request,response);
	}
}
