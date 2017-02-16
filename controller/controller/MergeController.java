package controller;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
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
 * Servlet implementation class MergeController
 */
@WebServlet("/MergeController")
public class MergeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MergeController() {
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
		String filename=null;
		HttpSession session=null;
		
		try{
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload sfu = new ServletFileUpload(factory);
			
			session=request.getSession();
		
			if(!ServletFileUpload.isMultipartContent(request)){
				System.out.println("Sorry! No file uploaded");
				return;
			}
			List items = sfu.parseRequest(request);
			
			FileItem title = (FileItem) items.get(0);
			InputStream file = title.getInputStream();
			String fname = title.getName();
			
			FileItem iname = (FileItem) items.get(1);
			String id = iname.getString();
			MongoDatabase db = MongoConnect.connect();
			ObjectId _id = new ObjectId(id);
			FindIterable<Document> it = db.getCollection("tunes.files").find(new Document("_id", _id));
			filename = it.first().getString("filename");
			System.out.println(fname);
		
			
			System.out.println(filename);
			List<String> list = new LinkedList<String>();
			list.add(ToFile.ToFileWrite(file, fname));
			
			list.add("//home//icyshe//workspace/Myumix//WebContent//music//"+filename);
			/*recording voice*/
			
			System.out.println(MergeSound.input(list, "//home//icyshe//workspace/Myumix//WebContent//music//new"+filename,2));
			InputStream in1=ToFile.toInputStream("//home//icyshe//workspace/Myumix//WebContent//music//new"+filename);
			
			User use = new User();
			System.out.println(in1.toString());
			use.uploadSong(in1, filename);		
		}
	catch(Exception e){
			System.out.println(e);
	}	
		
		//System.out.println("Done");
	}
	}


