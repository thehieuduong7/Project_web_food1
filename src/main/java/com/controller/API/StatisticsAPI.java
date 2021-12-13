package com.controller.API;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.service.StatisticsService;
import com.service.impl.StatisticsServiceImpl;

/**
 * Servlet implementation class StatisticsAPI
 */
@WebServlet("/StatisticsAPI")
public class StatisticsAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  Gson gson =new Gson();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatisticsAPI() {
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
		 PrintWriter out = response.getWriter();
		 StatisticsService staSer= new StatisticsServiceImpl();
		int id_user =1;
		String res="";
		 try {
			String kind = request.getParameter("kind").trim();
			if(kind.equals("thongKeThang")) {
				int month=Integer.parseInt(request.getParameter("month"));
				int year=Integer.parseInt(request.getParameter("year"));
				res = this.gson.toJson(staSer.getDoanhThuThang(id_user, month, year));
			}else if(kind.equals("thongKeNam")) {
				int year=Integer.parseInt(request.getParameter("year"));
				res = this.gson.toJson(staSer.getDoanhThuNam(id_user, year));

			}else if(kind.equals("thongKeDaMua")) {
				res = this.gson.toJson(staSer.getTongTienDaMua(id_user));
			}
			out.print(res);
		}catch(NumberFormatException e) {
			e.printStackTrace();
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
