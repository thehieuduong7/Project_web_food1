package com.controller.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.models.CartModel;
import com.models.ShipModel;
import com.service.CartService;
import com.service.ShippingService;
import com.service.impl.CartServiceImpl;
import com.service.impl.ShippingServiceImpl;

/**
 * Servlet implementation class CartController
 */
@WebServlet(urlPatterns="/web/cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
        super();
        // TODO Auto-generated constructor stub
    }
    Gson gson =new Gson();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        response.setContentType("text/htm");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        int id_user = 1;
        CartService cartSer = new CartServiceImpl();
        ShippingService shipSer = new ShippingServiceImpl();
        
        List<CartModel> listCart = cartSer.getByIDUser(id_user);
        
        List<ShipModel> listShip= shipSer.getAll();
        
        request.setAttribute("listCart", gson.toJson(listCart));
        request.setAttribute("listShip", gson.toJson(listShip));

        RequestDispatcher rq = request.getRequestDispatcher("/views/main_cart.jsp");
        rq.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	

}
