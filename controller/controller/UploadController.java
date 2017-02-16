package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import model.User;

/**
 * Servlet implementation class UploadController
 */
@WebServlet("/UploadController")
public class UploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadController() {
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
		// TODO Auto-generated method stub
				
				String message=null;
				HttpSession session=null;
				
				try{
					DiskFileItemFactory factory = new DiskFileItemFactory();
					ServletFileUpload sfu = new ServletFileUpload(factory);
					
					session=request.getSession();
				
					if(!ServletFileUpload.isMultipartContent(request)){
						System.out.println("Sorry! No file uploaded");
						return;
					}
					
					User use = new User();					
					
					List items = sfu.parseRequest(request);
					
					FileItem title = (FileItem) items.get(0);
					InputStream file = title.getInputStream();
					
					
				
					//File file = (File) items.get(0);
					//File file = (File) request.getAttribute("tune");
					//String content =(String) file.getContentType();
					//System.out.println("debug_upload field.. "+content);
					String name=(String) title.getName();
					//System.out.println("debug_upload name.. "+name);
					
				
					//String check = content.substring(0,5);
					//System.out.println("debug check "+check);
					//if(check.equals("audio")){
						message=use.uploadTune(file,name);
					//}
					//else
					//message=("This file is not a tune :P");
				}
				catch(Exception e){
					message=("Error uplaoding file"+e);
				}
				
				System.out.println(message);
				session.setAttribute("message", message);
				response.sendRedirect("UserHome.jsp");
			}

	}


