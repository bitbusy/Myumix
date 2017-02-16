<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="model.MongoConnect"%>
<%@ page import="com.mongodb.client.MongoDatabase"%>
<%@ page import="com.mongodb.client.gridfs.GridFSBucket"%>
<%@ page import="com.mongodb.client.gridfs.GridFSBuckets"%>
<%@ page import="com.mongodb.client.gridfs.model.GridFSFile"%>
<%@ page import="model.User"%>
<%@ page import="com.mongodb.client.FindIterable"%>
<%@ page import="static java.util.Arrays.asList"%>
<%@ page import="org.bson.Document"%>
 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MYUMIX Template</title>

 <script src="jquery.js"></script>
        <script>
            $(function(){
                $("#container").load("header.html");
            });
        </script>


<meta name="keywords" content="">
<meta name="description" content="">
<meta name="viewport" content="initial-scale=1">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,700italic,400,600,700,800' rel='stylesheet' type='text/css'>
<!-- Style Sheets -->
<link rel="stylesheet" href="css/animate.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/templatemo_misc.css">
<link rel="stylesheet" href="css/templatemo_style.css">
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/mycss.css">
<!-- JavaScripts -->
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap-dropdown.js"></script>
<script src="js/bootstrap-collapse.js"></script>
<script src="js/bootstrap-tab.js"></script>
<script src="js/jquery.singlePageNav.js"></script>
<script src="js/jquery.flexslider.js"></script>
<script src="js/custom.js"></script>
<script src="js/jquery.lightbox.js"></script>
<script src="js/templatemo_custom.js"></script>
<script src="js/responsiveCarousel.min.js"></script>
</head>

<body>
<!-- header start -->
<div id="templatemo_home_page">
 <div class="templatemo_topbar">
    <div class="container">
      
      <div class="row">
        <div class="templatemo_titlewrapper">
          <div class="title1"><span>MYUMIX</span></div>
        </div>
        <div class="clear"></div>
        <div class="templatemo_titlewrappersmall">MYUMIX</div>
        <div class="clear"></div>
      </div>
    </div>
  </div>
  
  <div class="templatemo_headerimage">
    <div class="flexslider">
      <ul class="slides" >
        <li><img src="images/slider/19.jpg" alt="Slide 1"></li>
        </ul>
    </div>
  </div>
  
  <div class="slider-cap">
   
      <div class="span_2 column" >
        <table  width=100% style=" border-collapse: separate; border-spacing: 15px; font-size:20px; text-align:left;" >
          <tr><td><a class="menu" href="MyProfile.jsp">My Profile</a></td></tr>
           <tr><td><a class="menu" href="MyProfile.jsp">My Profile</a></td></tr>
          <tr><td><a class="menu" href="CreateMusic.jsp">Create Music</a></td></tr>
          <tr><td><a class="menu" href="MyMusic.jsp">My Music</a></td></tr>
          <tr><td><a class="menu" href="WorldMusic.jsp">World Music</a></td></tr>
          <tr><td><a class="menu" href="WorldTunes.jsp">World Tunes</a></td></tr> 
        </table>
      </div>
      
      <div class="span_5 column">
          <table border=1 width=100% style=" border-collapse: separate; border-spacing: 15px;">
          <tr style="border-style:hidden;"><th style="text-align:center;">SONGS</th></tr>
			<%
		try{	
		MongoDatabase db = MongoConnect.connect();
		FindIterable<Document> it = db.getCollection("song.files").find(new Document("metadata", new Document("email",User.mail)));
		for(Document doc : it)
		{
		
			%>
		<form action="DownloadController" method="post">
		<tr>
		<td><%= doc.getString("filename") %> 
		<input type="hidden" value =<%=doc.get("_id")%> name="tuneid"></td>
	
		<td > <button type="submit" style="width:75px;height:30px;background-color: #E6610A;">download</td>
		<td>
		</form>
		<form action="ShareController" method="get">
		
		 
		<input type="hidden" value =<%=doc.get("_id")%> name="tuneid">
	
		<button type="submit" style="width:75px;height:30px;background-color: #E6610A;">Share</td>
		</tr>
		</form>
<%		
  }
}
catch(Exception e){
	
	out.print(e);
}%>
			          
          
          
          
          
                </table> 
      </div>
      
      <div class="span_5 column">
            <table border=1 width=100% style=" border-collapse: separate; border-spacing: 15px;">
            <tr><th colspan=2 style="text-align:center;">TUNES</th></tr>
            
			<%
		try{	
		MongoDatabase db = MongoConnect.connect();
		FindIterable<Document> it = db.getCollection("tunes.files").find(new Document("metadata", new Document("email",User.mail)));
		for(Document doc : it)
		{
		
			%>
		<form action="DownloadController" method="post">
		<tr>
		<td><%= doc.getString("filename") %> 
		<input type="hidden" value =<%=doc.get("_id")%> name="tuneid"></td>
	
		<td > <button type="submit" style="width:75px;height:30px;background-color: #E6610A;">download</td>
		<td>
		</form>
		<form action="RedirectController" method="get">
		
		 
		<input type="hidden" value =<%=doc.get("_id")%> name="tuneid">
	
		<button type="submit" style="width:75px;height:30px;background-color: #E6610A;">Record</td>
		</tr>
		</form>
<%		
  }
}
catch(Exception e){
	
	out.print(e);
}%>
			</table>
               
      </div>

  </div>

</div>
<!-- header end -->
</body>
</html>s