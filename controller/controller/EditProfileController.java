package controller;

import java.io.IOException;
import java.io.InputStream;
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
import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

import model.MongoConnect;
import model.User;

/**
 * Servlet implementation class EditProfileController
 */
@WebServlet("/EditProfileController")
public class EditProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfileController() {
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
			System.out.println(items);
			
			FileItem title = (FileItem) items.get(0);
			InputStream file = title.getInputStream();
		
			String name=(String) title.getName();
			System.out.println(name);
			if(name == null){}
			else message=use.uploadImage(file,name);
			System.out.println(name+" "+message);
			
			FileItem iName = (FileItem) items.get(1);
			String Namee = iName.getString();
			FileItem iuser = (FileItem) items.get(2);
			String user = iuser.getString();
			FileItem iinfo = (FileItem) items.get(3);
			String info = iinfo.getString();
			FileItem imbl = (FileItem) items.get(4);
			String mbl = imbl.getString();
			FileItem icon = (FileItem) items.get(5);
			String country = icon.getString();
			
			System.out.println(Namee+user+mbl+country);
			if(user==""||country=="" || mbl=="" ||Namee=="")
				message="Is any field empty?";
			else{
				use.setNamee(Namee);
				use.setCountry(country);
				use.setUsername(user);
				use.setInfo(info);
				use.setMobile(mbl);
				message=use.updateProfile();
				System.out.println(message);
			}
		}
		catch(Exception e){
			message="Error "+e;
			System.out.println(e);
		}

		session.setAttribute("message", message);
		if(message=="Is any field empty?" || message=="Can't Update")
			response.sendRedirect("EditProfile.jsp");
		else
			response.sendRedirect("MyProfile.jsp");
		
	}
}