package model;

import com.mongodb.*;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;
import com.mongodb.gridfs.GridFS;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.bson.Document;
import org.bson.types.ObjectId;
public class UploadCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			
			MongoClient mongoClient = new MongoClient();
	    	MongoDatabase db = mongoClient.getDatabase("Myumix");
	    	 
	    	GridFSBucket gfs = GridFSBuckets.create(db,"tunes");
	    	// Get the input stream
	    	InputStream streamToUploadFrom = new FileInputStream(new File("/home/icyshe/workspace/Myumix/WebContent/images/close.png"));

	    	// Create some custom options
	    	GridFSUploadOptions options = new GridFSUploadOptions()
	    	                                    .chunkSizeBytes(1024)
	    	                                    .metadata(new Document("username", "icyshe"));

	    	ObjectId fileId = gfs.uploadFromStream("mongodb-tutorial", streamToUploadFrom, options);
	    	System.out.println(fileId);
	    	
	    	  
	      }catch(Exception e){
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	          
	      }

	}

}
