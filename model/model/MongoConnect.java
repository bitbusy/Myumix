package model;

import com.mongodb.*;
import com.mongodb.client.MongoDatabase;


//import java.io.File;
//import java.util.Arrays;

public class MongoConnect{

  public static MongoDatabase connect() {
	//public static void main(String args[]){
	   //String s = "Sheetal";
      try{
		
    	  MongoClient mongoClient = new MongoClient();
    	  MongoDatabase db = mongoClient.getDatabase("Myumix");
    	  System.out.print("test");
    	  //File file = new File("/Myumix/WebContent/images/close.png");
    	  //db.getCollection("User").insertOne(new Document("file",file));
    	  System.out.print("Succeed");	
    	  return db;
      }catch(Exception e){
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          return null;
      }
   }
}