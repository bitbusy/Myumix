package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Merge
 */
@WebServlet("/Merge")
public class Merge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Merge() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		List<String> l=new LinkedList<String>();
		l.add("//home//krishna//Desktop//music//ChillingMusic.wav");
		l.add("//home//krishna//Desktop//music//voice.wav");
		l.add("//home//krishna//Desktop//music//DesiJourney.wav");
		
		out.print(MergeSound.input(l,"//home//krishna//Desktop//music//sinha.wav",2));
		out.println("done");
		//out.println("not created");

		out.append("Served at: ").append(request.getContextPath());
	}

	

}
