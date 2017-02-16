package controller;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
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
import com.mongodb.gridfs.GridFSDBFile;

import model.MongoConnect;
import model.User;

/**
 * Servlet implementation class DownloadController
 */
@WebServlet("/DownloadController")
public class DownloadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadController() {
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
		String id=null,message=null;
		HttpSession session=null;
		
		try{
			
			session = request.getSession();
			
			id = request.getParameter("tuneid");
			System.out.println("id = "+id);
			//User use = new User();
			//message = use.download(id);
			//System.out.println(message);
			
			MongoDatabase db = MongoConnect.connect();
			ObjectId _id = new ObjectId(id);
			FindIterable<Document> it = db.getCollection("tunes.files").find(new Document("_id", _id));
			int count = it.first().getInteger("count")+1;
			System.out.println(it);
			//System.out.println("Name = "+id);
			GridFSBucket buck = GridFSBuckets.create(db,"tunes");
			
			System.out.println(_id);
			GridFSDownloadStream gfstream = buck.openDownloadStream(_id);
			GridFSFile file = gfstream.getGridFSFile();
			String name =  file.getFilename();
			response.setHeader("Content-Disposition","attachment; filename="+name);
			System.out.println(name);
			
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        int data = gfstream.read();
	        while (data >= 0) {
	            outputStream.write(data);
	            data = gfstream.read();
	        }
	        byte[] bytesToWriteTo = outputStream.toByteArray();
			
			int len = (int)file.getLength();
			response.setContentLength(len);
			ServletOutputStream op = response.getOutputStream(); 
			
			op.write(bytesToWriteTo);
			op.flush();
			op.close();
			
			BasicDBObject bdo = new BasicDBObject().append("$set",new BasicDBObject().append("count", count));
	    	db.getCollection("tunes.files").updateOne(new BasicDBObject().append("_id", _id), bdo);
	    	name="//Myumix//WebContent//music//"+name;
	    	FileOutputStream opp = new FileOutputStream(name);
			buck.downloadToStream(it.first().getObjectId("_id"),opp);
			
			//bdo.put("count", arg1)
			//response.sendRedirect("try.jsp");
			
		}
		catch(Exception e){
			
			System.out.println(e);
		}
		response.sendRedirect("try.jsp");
	}

}
