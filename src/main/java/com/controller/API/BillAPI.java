package com.controller.API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

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
import com.service.BillService;
import com.service.CartService;
import com.service.impl.BillServiceImpl;
import com.service.impl.CartServiceImpl;

/**
 * Servlet implementation class BillAPI
 */
@WebServlet("/BillAPI")
public class BillAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  Gson gson =new Gson();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/htm");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		request.setCharacterEncoding("UTF-8");
		UserLoginModel u = SessionController.getUserLogin(request, response);
		if(u==null) {
			return;
		}
		
		 int id_user = u.getId_user();
		 StringBuffer jb = new StringBuffer(); String line = null; 
		 PrintWriter out = response.getWriter();
		 
		 try { BufferedReader reader = request.getReader(); while ((line =
		 reader.readLine()) != null) jb.append(line); } catch (Exception e) { 
			 }
				 
		 JsonElement root = new JsonParser().parse(new String(jb));
		 String city_ship = root.getAsJsonObject().get("city_ship").getAsString().trim();
		 
		 
		 BillService cartSer = new BillServiceImpl();
		 boolean res= cartSer.payment(id_user, city_ship);
		 out.print(res);
	}

}
