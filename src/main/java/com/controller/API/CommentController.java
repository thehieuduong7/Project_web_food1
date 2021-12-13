package com.controller.API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JScrollBar;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.models.CommentModel;
import com.service.CommentService;
import com.service.impl.CommentServiceImpl;

/**
 * Servlet implementation class CommentController
 */
@WebServlet(urlPatterns = "/CommentAPI")
public class CommentController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommentController() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Gson gson = new Gson();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/htm");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
			int id_product = Integer.parseInt(request.getParameter("id_product"));
			CommentService cmtSer = new CommentServiceImpl();
			List<CommentModel> listcmt = cmtSer.getCommentByIDProduct(id_product);
			String listJson = this.gson.toJson(listcmt);
			out.print(listJson);
			// out.print("'SoLuong': '" + String.valueOf(3)+"'");

			out.flush();
		} catch (NumberFormatException e) {
			out.print("");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/htm");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		
		 StringBuffer jb = new StringBuffer(); String line = null; 
		 PrintWriter out = response.getWriter();
		 
		 try { BufferedReader reader = request.getReader(); while ((line =
		 reader.readLine()) != null) jb.append(line); } catch (Exception e) { 
			 }
				 
		 JsonElement root = new JsonParser().parse(new String(jb)); 
		
		 int id_user = 1;
		 int id_product = root.getAsJsonObject().get("id_product").getAsInt();

		 String content = root.getAsJsonObject().get("content").getAsString();
		 Date time_cmt= new Date(System.currentTimeMillis());
		 CommentModel cmt = new CommentModel(-1, id_user, id_product, content, time_cmt);
		 
		 CommentService cmtSer = new CommentServiceImpl();
		 if(!cmtSer.insert(cmt)) {
			 out.print("failt");
		 }else {
			 out.print(this.gson.toJson(cmt));
		 }
		 
		
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}

}
