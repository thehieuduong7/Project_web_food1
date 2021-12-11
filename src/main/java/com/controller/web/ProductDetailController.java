package com.controller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.CartModel;
import com.models.ProductModel;
import com.service.CartService;
import com.service.CategoryService;
import com.service.ProductService;
import com.service.impl.CartServiceImpl;
import com.service.impl.CategoryServiceImpl;
import com.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class ProductDetailController
 */
@WebServlet(urlPatterns="/web/productDetail")
public class ProductDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        response.setContentType("text/htm");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        int id;
        try {
            id = Integer.parseInt(request.getParameter("pid"));
        }catch(NumberFormatException e) {
        	throw new ServletException("loi format");
        }
        
        
        ProductService proSer = new ProductServiceImpl();
        ProductModel pro = proSer.searchByID(id);
        
        request.setAttribute("product", pro);
        
        CategoryService cateSer = new CategoryServiceImpl();
        request.setAttribute("cate", "cake");

        
        
        CartService cartSer = new CartServiceImpl();
        CartModel cart = cartSer.getCart(1, id);
        
        
        request.setAttribute("amount", (cart==null)?0:cart.getAmount());
        
        

        

        RequestDispatcher rq = request.getRequestDispatcher("/views/food-detail.jsp");
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
