package com.controller.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.models.UserLoginModel;
import com.service.UserLoginService;
import com.service.impl.UserLoginServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/decorators/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public static final String SESSION_USERNAME = "username";
	public static final String COOKIE_REMEMBER = "username";
	private void saveRemeberMe(HttpServletResponse response, String
			username){
			Cookie cookie = new Cookie(COOKIE_REMEMBER,username);
			cookie.setMaxAge(30*60);
			response.addCookie(cookie);
			}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("input_username").trim();
		String password = request.getParameter("input_password").trim();
		boolean isRememberMe = false;
		String remember = request.getParameter("remmeber_check");
		if("on".equals(remember)){
		isRememberMe = true;
		}
		String alertMsg="";
		UserLoginService ser = new UserLoginServiceImpl();
		
		UserLoginModel user = ser.login(username, password);
		
		if(user!=null){
			HttpSession session = request.getSession(true);
			session.setAttribute("UserLogin", user);
			if(isRememberMe){
				saveRemeberMe(response, user.getUsername());
			}
				response.sendRedirect(request.getContextPath()+"/waiting");
			}else{
			alertMsg = "Tài khoản hoặc mật khẩu không đúng";
				request.setAttribute("alertMsg", alertMsg);
				request.getRequestDispatcher("/decorators/login.jsp").forward(request,
					response);
			}
		}
}


