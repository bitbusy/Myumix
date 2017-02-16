package model;

import java.io.FileOutputStream;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.model.GridFSFile;

public class DownloadCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MongoDatabase db = MongoConnect.connect();
		FindIterable<Document> it = db.getCollection("tunes.files").find(new Document("metadata", new Document("email","qw@m.com")));
		
		for(Document doc :it)
			System.out.println(doc.getString("filename"));
		GridFSBucket gridbucket = GridFSBuckets.create(db, "tunes");
		System.out.println(gridbucket.getBucketName());
		try{
		GridFSFile file = gridbucket.find(new Document("metadata", new Document("email","qw@m.com"))).first();
		String name =it.first().getString("filename");
		FileOutputStream op = new FileOutputStream(name);
		gridbucket.downloadToStream(it.first().getObjectId("_id"),op);
		//gridbucket.delete(it.first().getObjectId("_id"));
		}
		catch(Exception e){
			
			System.out.println(e);
			}
		
	}

}
