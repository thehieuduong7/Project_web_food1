package com.controller.seller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;
import com.models.ProductModel;
import com.service.CategoryService;
import com.service.ProductService;
import com.service.impl.CategoryServiceImpl;
import com.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class ProductSellerController
 */
@WebServlet("/seller/products")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 50, // 50MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
public class ProductSellerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductSellerController() {
        super();
        // TODO Auto-generated constructor stub
    }
   
    public File getFolderUpload(HttpServletRequest req) {
    	String realPath = req.getServletContext().getRealPath("/uploads");
        File folderUpload = new File(realPath);
        if (!folderUpload.exists()) {
          folderUpload.mkdirs();
        }
        return folderUpload;
      }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/htm");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		CategoryService ser =new CategoryServiceImpl();
		
		request.setAttribute("listCate", ser.getAll());
		
		ProductService proSer = new ProductServiceImpl();
		int id_seller=1;
		
		request.setAttribute("listProduct", proSer.getByID_seller(id_seller));

		
		request.getRequestDispatcher("/views/seller/food.jsp").forward(request, response);
        //PrintWriter out = response.getWriter();

		//out.print( this.getFolderUpload(request).getAbsolutePath()); 
	       //return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/htm");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        
		ProductService proSer = new ProductServiceImpl();
		int id_seller= 1;

		try {

			String form_meth= request.getParameter("form_meth");
			if(form_meth.trim().equals("add")) {
				String name_food= request.getParameter("text_name_food");
				float price= Float.parseFloat(request.getParameter("text_price")) ;
				String desc= request.getParameter("text_description");
				float salePercent= Float.parseFloat(request.getParameter("text_salePercent")) ;
				int id_category=Integer.parseInt(request.getParameter("select_category"));
				Part part = request.getPart("file_photo_add");
				String name_file=String.valueOf(id_seller)+"_"+name_food+".png";
				String url=this.getFolderUpload(request).getAbsolutePath() + File.separator+name_file;
				
				ProductModel pro =new ProductModel(-1,name_food,id_category,id_seller,price,desc,"/uploads/"+name_file,salePercent);
				
				
				if(!proSer.insert(pro)) {
					request.setAttribute("mess", "Add fail");
				}
				else {
					request.setAttribute("mess", "Add success!!!");

				}
			    part.write(url);
			}else if(form_meth.trim().equals("update")) {
				int id_product= Integer.parseInt(request.getParameter("text_id_product")) ;

				ProductModel pro =proSer.searchByID(id_product);
				String name_food= request.getParameter("text_name_food");
				float price= Float.parseFloat(request.getParameter("text_price")) ;
				String desc= request.getParameter("text_description");
				float salePercent= Float.parseFloat(request.getParameter("text_salePercent")) ;
				int id_category=Integer.parseInt(request.getParameter("select_category"));
				Part part = request.getPart("file_photo_add");
				String name_file=String.valueOf(id_seller)+"_"+name_food+".png";
				String url=this.getFolderUpload(request).getAbsolutePath() + File.separator+name_file;
				
				if(part!=null) pro.setPhoto("/uploads/"+name_file);
				pro.setName_food(name_food);
				pro.setPrice(price);
				pro.setDescription(desc);
				pro.setSalePercent(salePercent);
				pro.setId_category(id_category);
				
				
				if(!proSer.update(pro)) {
					request.setAttribute("mess", "update fail");
					out.print("fale");
				}
				else {
					request.setAttribute("mess", "update success!!!");
				}
				if(part!=null) part.write(url);
				out.print(part);
			}else {
				int id_product= Integer.parseInt(request.getParameter("text_id_product")) ;

				if(!proSer.remove(id_product)) {
					request.setAttribute("mess", "Remove fail");
				}
				else {
					request.setAttribute("mess", "Remove success!!!");
				}
			}
			


		    //out.print(this.getFolderUpload(request).getAbsolutePath() + File.separator+name_file);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("listProduct", proSer.getByID_seller(id_seller));

	  CategoryService sercate =new CategoryServiceImpl();
		request.setAttribute("listCate", sercate.getAll());
		request.getRequestDispatcher("/views/seller/food.jsp").forward(request, response);

	}


}
