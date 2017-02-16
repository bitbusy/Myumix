package model;

import static java.util.Arrays.asList;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

public class Contact {

	String email=null,name=null,msg=null,subject=null;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String insert(){
		
		FindIterable<Document> it = null;
		String message = null;
		MongoDatabase db = MongoConnect.connect();
		if(db==null)
			message = "failed to connect to db";
		else{
				db.getCollection("Contact").insertOne(new Document("email",getEmail()).append("name", getName()).append("msg", getMsg()).append("subject", getSubject()));
			}
		return message;
		
	}
}
