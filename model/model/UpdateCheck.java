package model;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoDatabase;

public class UpdateCheck {

	public static void main(String args[]){
		try{
		MongoDatabase db = MongoConnect.connect();
		
		if(db==null)
			System.out.println("Error occured");
		else{
			System.out.println("done1");
			BasicDBObject bdo = new BasicDBObject().append("$set",new BasicDBObject().append("password", "values"));
			System.out.println("done2");
			db.getCollection("User").updateOne(new BasicDBObject().append("username", "icyshe"), bdo);
			System.out.println("done3");
			
			}	
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
