package model;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import org.bson.Document;
import org.bson.types.ObjectId;

import static java.util.Arrays.asList;


import java.io.InputStream;


public class User {

	String email,username,password,location,country, mobile,namee,info;;
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNamee() {
		return namee;
	}

	public void setNamee(String namee) {
		this.namee = namee;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public static String mail;  
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String insert(){
		
		FindIterable<Document> it = null;
		String message = null;
		MongoDatabase db = MongoConnect.connect();
		if(db==null)
			message = "failed to connect to db";
		else{
			it = db.getCollection("User").find(new Document("$or", asList(new Document("email",getEmail()),new Document("username",getUsername()))));
			if(it.first()==null){
				System.out.println("Registered");
				message="EditProfile.jsp";
				db.getCollection("User").insertOne(new Document("email",getEmail()).append("username", getUsername()).append("password", getPassword()));
			}
			else
				message="User already exists .. check username or email";
		}
		return message;
		
	}
	
	public String login(){
		
		String check = getUsername();
		FindIterable<Document> it = null;
		String message = null;
		MongoDatabase db = MongoConnect.connect();
		if(db==null)
			message = "failed to connect to db";
		else{
			//message="UserHome.html";
			it = db.getCollection("User").find(new Document("$or", asList(new Document("email",check),new Document("username",check))).append("password", getPassword()));
			if(it.first()==null)
				message = "Invalid Login. Registered?";
			else
				mail=it.first().getString("email");
				message="UserHome.jsp";
			
			}
		return message;
	}


	public String updateProfile(){
		//FindIterable<Document> it = null;
		String message = null;
		MongoDatabase db = MongoConnect.connect();
		if(db==null){
			message = "failed to connect to db";
		}
		else{
			System.out.println("yes1");
			//MongoCollection<Document> collection = db.getCollection("User");
			//it=collection.find(new Document("email",mail));
		
			BasicDBObject newDocument = new BasicDBObject().append("$set",new BasicDBObject().append("namee", getNamee()).append("mobile", getMobile()).append("country", getCountry()).append("username", getUsername()).append("info", getInfo()));
			db.getCollection("User").updateOne(new BasicDBObject().append("email",mail), newDocument);
			message = "profile updated uploaded";
		}
		return message;
	}

public String uploadImage(InputStream file, String name){
		
		//File _file = (File)file;
		String message=null;
		MongoDatabase db = MongoConnect.connect();
		if(db==null)
			message ="failed to connect to db";
		else{
			try{
				//it=collection.find(new Document("email",mail));
		        	        
		        GridFSBucket gfs = GridFSBuckets.create(db,"images");
			
		        //deleting existing profile image
		        GridFSFile existingfile=gfs.find(new Document("metadata",new Document("email",mail))).first();
		        System.out.println(existingfile);
		        gfs.delete(existingfile.getObjectId());
		        
		        GridFSBucket gfs1 = GridFSBuckets.create(db,"images");
		        // Get the input stream
		        InputStream streamToUploadFrom = (file);

	    	
		        // Create some custom options
		        GridFSUploadOptions options = new GridFSUploadOptions()
	    	                                    .chunkSizeBytes(1024)
	    	                                    .metadata(new Document("email",mail));

	    	ObjectId fileId = gfs1.uploadFromStream(name, streamToUploadFrom, options);
	    	System.out.println(fileId);
	    	message="uploaded successfully";
			}
			catch(Exception e){
				message="Error "+e;
			}
			
		}
		return message;
	}

	
	public String uploadTune(InputStream file,String name){
		
		//File _file = (File)file;
		String message=null;
		MongoDatabase db = MongoConnect.connect();
		if(db==null)
			message =  "failed to connect to db";
		else{
			try{
			FindIterable<Document> it =db.getCollection("User").find(new Document("$or", asList(new Document("email",mail),new Document("username",mail))));
			for(Document doc : it){
				
			//	mail = doc.getString("email");
			}
			
			GridFSBucket gfs = GridFSBuckets.create(db,"tunes");
	    	// Get the input stream
	    	InputStream streamToUploadFrom = (file);

	    	// Create some custom options
	    	GridFSUploadOptions options = new GridFSUploadOptions()
	    	                                    .chunkSizeBytes(1024)
	    	                                    .metadata(new Document("email", mail));

	    	ObjectId fileId = gfs.uploadFromStream(name, streamToUploadFrom, options);
	    	System.out.println(fileId);
	    	int count = 0;
	    	BasicDBObject bdo = new BasicDBObject().append("$set",new BasicDBObject().append("count", count));
	    	db.getCollection("tunes.files").updateOne(new BasicDBObject().append("_id", fileId), bdo);
	    	message="uploaded successfully";
			}
			catch(Exception e){
				message="Error "+e;
			}
			
		}
		
		
		return message;
	}
public String uploadSong(InputStream file,String name){
		
		//File _file = (File)file;
		String message=null;
		MongoDatabase db = MongoConnect.connect();
		if(db==null)
			message =  "failed to connect to db";
		else{
			try{
			FindIterable<Document> it =db.getCollection("User").find(new Document("$or", asList(new Document("email",mail),new Document("username",mail))));
			for(Document doc : it){
				
			//	mail = doc.getString("email");
			}
			
			GridFSBucket gfs = GridFSBuckets.create(db,"song");
	    	// Get the input stream
	    	InputStream streamToUploadFrom = (file);

	    	// Create some custom options
	    	GridFSUploadOptions options = new GridFSUploadOptions()
	    	                                    .chunkSizeBytes(1024)
	    	                                    .metadata(new Document("email", mail));

	    	ObjectId fileId = gfs.uploadFromStream(name, streamToUploadFrom, options);
	    	System.out.println(fileId);
	    	int count = 0;
	    	BasicDBObject bdo = new BasicDBObject().append("$set",new BasicDBObject().append("count", count));
	    	db.getCollection("tunes.files").updateOne(new BasicDBObject().append("_id", fileId), bdo);
	    	message="uploaded successfully";
			}
			catch(Exception e){
				message="Error "+e;
			}
			
		}
		
		
		return message;
	}

	
	public String download(String id){
		String message=null;
		MongoDatabase db = MongoConnect.connect();
		FindIterable<Document> it = db.getCollection("tunes.files").find(new Document("metadata", new Document("email",mail)));
		GridFSBucket buck = GridFSBuckets.create(db,"tunes");
		GridFSDownloadStream gfstream = buck.openDownloadStream(id);
		GridFSFile file = gfstream.getGridFSFile();
		
		return message;
	}



}
