package controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;

import model.MongoConnect;

/**
 * Servlet implementation class RedirectController
 */
@WebServlet("/RedirectController")
public class RedirectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String id=null,name=null;
		HttpSession session=null;
			
			session = request.getSession();
			
			id = request.getParameter("tuneid");
			System.out.println("id = "+id);
			
			session.setAttribute("id", id);
			MongoDatabase db = MongoConnect.connect();
			ObjectId _id = new ObjectId(id);
			FindIterable<Document> it = db.getCollection("tunes.files").find(new Document("_id", _id));
			name = it.first().getString("filename");
			
			System.out.println(name); 
			/*GridFSBucket buck = GridFSBuckets.create(db,"tunes");
			GridFSDownloadStream gfstream = buck.openDownloadStream(_id);
			GridFSFile file = gfstream.getGridFSFile();
				
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		        int data = gfstream.read();
		        while (data >= 0) {
		            outputStream.write(data);
		            data = gfstream.read();
		        }
		        byte[] bytesToWriteTo = outputStream.toByteArray();
				
				int len = (int)file.getLength();
				response.setContentType(getServletContext().getMimeType(name));
                response.setContentLength(len);
                response.getOutputStream().write(bytesToWriteTo);
*/				session.setAttribute("name", name);
				session.setAttribute("id", id);
				response.sendRedirect("sound.jsp");
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
