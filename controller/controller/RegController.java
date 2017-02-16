package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

/**
 * Servlet implementation class RegController
 */
@WebServlet(description = "Used for registering new user", urlPatterns = { "/RegController" })
public class RegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegController() {
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
		String message= null, email=null, username=null,password=null,cpassword=null;
		HttpSession session = null;
		try{
			session = request.getSession();
			email = request.getParameter("email").toLowerCase();
			username = request.getParameter("username").toLowerCase();
			password = request.getParameter("password");
			cpassword = request.getParameter("cpassword");
			
			User user = new User();
			if(email==""||username==""||password==""||cpassword=="")
				message = "Is any field empty?";
			else if(password.equals(cpassword)){
				
				user.setEmail(email);
				user.setPassword(password);
				user.setUsername(username);
				message = user.insert();
			}
			else
				message = "Password and confirm password do not match";
		}
		catch(Exception e){
			
			message ="Error Registering.. check all fields "+e; 
			
				
		}
		session.setAttribute("message",message);
		response.sendRedirect("Login.jsp");
		System.out.println(message);
	}

}
