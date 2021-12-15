package com.controller.API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.login.SessionController;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.models.UserLoginModel;
import com.service.CartService;
import com.service.impl.CartServiceImpl;

/**
 * Servlet implementation class CartAPI
 */
@WebServlet("/CartAPI")
public class CartAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartAPI() {
        super();
        // TODO Auto-generated constructor stub
    }
    Gson gson =new Gson();
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
		
		int id_user=u.getId_user();
		PrintWriter out = response.getWriter();
		CartService cartSer = new CartServiceImpl();
		try {
		     Map<String, Object> data = new HashMap<String, Object>();
		     data.put("totalMoney", cartSer.getTotalMoney(id_user));
		     data.put("totalAmount", cartSer.getTotalAmount(id_user));
		     data.put("listCart", cartSer.getByIDUser(id_user));
			 out.print(gson.toJson(data));
		}catch(NumberFormatException e) {
		}
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/htm");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		

		UserLoginModel u = SessionController.getUserLogin(request, response);
		if(u==null) {
			return;
		}
		int id_user = u.getId_user();
		
		PrintWriter out = response.getWriter();
		boolean res;
		try {
			int id_product=Integer.parseInt(request.getParameter("pid")) ;
			 
			 CartService cartSer = new CartServiceImpl();
			 res = cartSer.removeCart(id_user, id_product);
		}catch(NumberFormatException e) {
			res=false;
		}

		 out.print(res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/htm");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		

		UserLoginModel u = SessionController.getUserLogin(request, response);
		if(u==null) {
			return;
		}
		 int id_user =u.getId_user();

		
		 StringBuffer jb = new StringBuffer(); String line = null; 
		 PrintWriter out = response.getWriter();
		 
		 try { BufferedReader reader = request.getReader(); while ((line =
		 reader.readLine()) != null) jb.append(line); } catch (Exception e) { 
			 }
				 
		 JsonElement root = new JsonParser().parse(new String(jb));
		 int id_product = root.getAsJsonObject().get("id_product").getAsInt();
		 int amount = root.getAsJsonObject().get("amount").getAsInt();
		 
		 
		 CartService cartSer = new CartServiceImpl();
		 boolean res;
		 if(amount==1) {
			 res =cartSer.addCart(id_user, id_product);
		 }else {
			 res =cartSer.minuscart(id_user, id_product);
		 }
		 out.print(res);
	}

}
