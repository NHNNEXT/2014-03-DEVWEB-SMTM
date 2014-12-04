package store;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Store;


@WebServlet("/RetrieveStoreListServlet")
public class RetrieveStoreListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/store/findStore.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String storeId = request.getParameter("storeId");
		Store store = new Store(storeId);
		StoreBiz biz = new StoreBiz();
		Map<String, Store> storeList = biz.retrieveBiz(store);
		System.out.println(storeList.values());		
		if(storeList !=null){
			HttpSession session = request.getSession();
			session.setAttribute("storeList",storeList);
			System.out.println(session.getAttribute("storeList"));
			
		} else {
			//alert 띄워주기
		}
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/store/findStore.jsp");
		rd.forward(request,response);
	}

}
