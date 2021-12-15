package com.controller.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.models.UserLoginModel;

/**
 * Servlet implementation class WaitingController
 */
@WebServlet("/waiting")
public class WaitingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WaitingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session= request.getSession();
		if(session != null && session.getAttribute("UserLogin") != null) {
			UserLoginModel u=(UserLoginModel) session.getAttribute("UserLogin");
			request.setAttribute("username", u.getUsername());
			if(u.getRole().trim().equals("admin")) {
			response.sendRedirect(request.getContextPath()+"/admin/home");
			}else if(u.getRole().trim().equals("seller")) {
				response.sendRedirect(request.getContextPath()+"/seller/home");
			}else {
				response.sendRedirect(request.getContextPath()+"/web/home");
			}
		}else {
			response.sendRedirect(request.getContextPath()+"/login");
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
