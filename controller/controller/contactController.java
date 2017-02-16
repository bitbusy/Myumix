package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Contact;
import model.User;

/**
 * Servlet implementation class contactController
 */
@WebServlet("/contactController")
public class contactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public contactController() {
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
		doGet(request, response);
		
		String message= null, email=null, name=null,subject=null,msg=null;
		HttpSession session = null;
		try{
			session = request.getSession();
			email = request.getParameter("email").toLowerCase();
			name = request.getParameter("name").toLowerCase();
			subject = request.getParameter("subject");
			msg = request.getParameter("msg");
			
			Contact user = new Contact();
			if(email==""||name==""||subject==""||msg=="")
				message = "Is any field empty?";
			else {
				
				user.setEmail(email);
				user.setName(name);
				user.setSubject(subject);
				user.setMsg(msg);
				message = user.insert();
			}
			
		}
		catch(Exception e){
			
			message ="Error Registering.. check all fields "+e; 
			
				
		}
		session.setAttribute("message",message);
		response.sendRedirect("index.html");
		System.out.println(message);

		
	}

}
