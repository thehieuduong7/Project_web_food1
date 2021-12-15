package com.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.controller.login.SessionController;
import com.models.ProductModel;
import com.models.UserLoginModel;
import com.service.ProductService;
import com.service.impl.ProductServiceImpl;

import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(urlPatterns="/web/home")
public class HomeController extends HttpServlet {
	//private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/htm");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		UserLoginModel u = SessionController.getUserLogin(request, response);
		if(u==null) {
			return;
		}
		
		ProductService proService = new ProductServiceImpl();
		
		List<ProductModel> listTop4 = proService.getTop4();
		
		
		request.setAttribute("ListTop4", listTop4);
		
		RequestDispatcher rq = request.getRequestDispatcher("/views/home.jsp");
		rq.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
