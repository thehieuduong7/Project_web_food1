package com.controller.seller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.login.SessionController;
import com.models.ProductModel;
import com.models.UserLoginModel;
import com.service.ProductService;
import com.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class HomeSellerController
 */
@WebServlet("/seller/home")
public class HomeSellerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeSellerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/htm");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		UserLoginModel u = SessionController.getUserLogin(request, response);
		if(u==null) {
			return;
		}
		if(u.getRole().trim().equals("seller")) {
			/*ProductService proService = new ProductServiceImpl();
			List<ProductModel> listTop4 = proService.getTop4();
			request.setAttribute("ListTop4", listTop4);
			RequestDispatcher rq = request.getRequestDispatcher("/views/home.jsp");
			rq.forward(request, response);*/
			response.sendRedirect(request.getContextPath()+"/seller/products");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
