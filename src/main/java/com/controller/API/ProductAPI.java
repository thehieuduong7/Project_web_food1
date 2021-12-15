package com.controller.API;

import java.io.BufferedReader;
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
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.models.ProductModel;
import com.models.UserLoginModel;
import com.service.ProductService;
import com.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class ProductAPI
 */
@WebServlet("/ProductAPI")
public class ProductAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private Gson gson = new Gson();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/htm");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		UserLoginModel u = SessionController.getUserLogin(request, response);
		if(u==null) {
			return;
		}
		
        PrintWriter out = response.getWriter();
        
        try {
        	
	        int id_product = Integer.parseInt(request.getParameter("pid"));

	        ProductService proSer = new ProductServiceImpl();
	        ProductModel pro = proSer.searchByID(id_product);
	        if(pro!=null) {
	        	out.print(this.gson.toJson(pro));
	        }
	        out.flush();
        }catch(NumberFormatException e) {
        	out.print("");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get list product theo cid
		
		response.setContentType("text/htm");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		UserLoginModel u = SessionController.getUserLogin(request, response);
		if(u==null) {
			return;
		}
		
        PrintWriter out = response.getWriter();
        StringBuffer jb = new StringBuffer(); String line = null; 
		 
		 try { BufferedReader reader = request.getReader(); while ((line =
		 reader.readLine()) != null) jb.append(line); } catch (Exception e) { 
			 }
				 
		 JsonElement root = new JsonParser().parse(new String(jb)); 
		 
		 ProductService proSer = new ProductServiceImpl();
		 int cid = root.getAsJsonObject().get("id_category").getAsInt();
		 int maxInPage = root.getAsJsonObject().get("maxInPage").getAsInt();
		 int page = root.getAsJsonObject().get("page").getAsInt();
		 List<ProductModel> list;
		 if(cid==-1) {
			list=proSer.getAll();
		 }else {
			 list=proSer.getByCID(cid);
		 }
		 try {
			 int lenPage=proSer.lenPage(list, maxInPage);
			 list=proSer.getListInPage(list,page, maxInPage);
			 Map<String,Object> map= new HashMap<>();
			 map.put("category_id",cid);
			 map.put("page", page);
			 map.put("lenPage", lenPage);
			 map.put("listByCID", list);
			 System.out.print(gson.toJson(map));
			 out.print(gson.toJson(map));
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
        
        
	}

}
