package model;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

public class checkFind {

	public static void main(String args[]){
		
		MongoDatabase db = MongoConnect.connect();
		if(db==null)
			System.out.println("Unable to connect");
		else{
			
			FindIterable<Document> it = db.getCollection("User").find(new Document("username","icyshe"));
			for(Document doc : it) {
			    System.out.println(doc.getString("password"));
			}
			
		}
		
	}
}
