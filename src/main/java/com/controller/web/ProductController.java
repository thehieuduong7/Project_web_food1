package com.controller.web;

import javax.servlet.*;
import javax.servlet.http.*;

import com.controller.login.SessionController;
import com.google.gson.Gson;
import com.models.UserLoginModel;
import com.service.CategoryService;
import com.service.ProductService;
import com.service.impl.CategoryServiceImpl;
import com.service.impl.ProductServiceImpl;

import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns="/web/product")
public class ProductController extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/htm");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        UserLoginModel u = SessionController.getUserLogin(request, response);
		if(u==null) {
			return;
		}
        CategoryService cateSer = new CategoryServiceImpl();
        ProductService proSer = new ProductServiceImpl();
        Gson gson = new Gson();
        request.setAttribute("listCategory",gson.toJson(cateSer.getAll()));
        
        
        
        
        RequestDispatcher rq = request.getRequestDispatcher("/views/food.jsp");
        
        rq.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
