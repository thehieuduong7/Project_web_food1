package com.controller.API;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.login.SessionController;
import com.google.gson.Gson;
import com.models.CommentModel;
import com.models.UserLoginModel;
import com.service.CommentService;
import com.service.UserLoginService;
import com.service.impl.CommentServiceImpl;
import com.service.impl.UserLoginServiceImpl;

/**
 * Servlet implementation class UserLoginAPIController
 */
@WebServlet(urlPatterns="/web/UserLoginAPIController")
public class UserLoginAPIController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginAPIController() {
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
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        try {
	        int id_user = Integer.parseInt(request.getParameter("id_user"));
	        //out.print("'SoLuong': '" + String.valueOf(3)+"'");
	        UserLoginService ser = new UserLoginServiceImpl();
	        UserLoginModel user = ser.getByID(id_user);
	        
	        Map<String,Object> map = new HashMap<String,Object>();
	        map.put("full_name", user.getFull_name());
	        map.put("full_name", user.getUsername());
	       //s map.put("id_user", user.);

	        
	        
	        out.flush();
        }catch(NumberFormatException e) {
        	out.print("");
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
