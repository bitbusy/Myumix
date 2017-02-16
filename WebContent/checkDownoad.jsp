<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="com.mongodb.client.MongoDatabase"%>
<%@ page import="com.mongodb.client.gridfs.GridFSBucket"%>
<%@ page import="com.mongodb.client.gridfs.GridFSBuckets"%>
<%@ page import="com.mongodb.client.gridfs.model.GridFSFile"%>
<%@ page import="model.User"%>
<%@ page import="model.MongoConnect"%>
<%@ page import="com.mongodb.client.FindIterable"%>
<%@ page import="static java.util.Arrays.asList"%>
<%@ page import="org.bson.Document"%>
 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		try{	
		MongoDatabase db = MongoConnect.connect();
		FindIterable<Document> it = db.getCollection("tunes.files").find(new Document("metadata", new Document("email","qw@m.com")));
		for(Document doc : it)
		{
			%>
			<form action="DownloadController" method="post">
			
			<%= doc.getString("filename") %> <br>
			<input type="hidden" value =<%= doc.get("_id") %> name="tuneid"><br>
			<input type="submit" style="width:75px;height:30px;background-color: #E6610A;" value="download">
			<br>
			</form>
	<%		
	  }
	}
	catch(Exception e){
		
		out.print(e);
	}%>


</body>
</html>