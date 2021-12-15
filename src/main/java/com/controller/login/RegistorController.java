package com.controller.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.UserLoginModel;
import com.service.UserLoginService;
import com.service.impl.UserLoginServiceImpl;

/**
 * Servlet implementation class RegistorController
 */
@WebServlet("/registor")
public class RegistorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistorController() {
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
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String full_name = request.getParameter("input_full_name").trim();
		String username = request.getParameter("input_username").trim();
		String password = request.getParameter("input_password").trim();
		//String password = request.getParameter("input_password_confirm").trim();
		
		UserLoginService ser = new UserLoginServiceImpl();
		String alertMsg="";
		UserLoginModel user = ser.register(username, password, full_name);
		if(user==null) {
			 alertMsg="Tài khoản đã tồn tại!!!";
			 
		}else {
			alertMsg="Tạo tài khoản thành công!!!";
		}
		request.setAttribute("alertMsg", alertMsg);
		RequestDispatcher rq = request.getRequestDispatcher("/decorators/login.jsp");
		rq.forward(request, response);
		
		
		
	}

}
