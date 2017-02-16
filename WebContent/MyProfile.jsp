<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@ page import="com.mongodb.client.MongoDatabase"%>
<%@ page import="com.mongodb.client.model.Updates"%>
<%@ page import="com.mongodb.BasicDBObject"%>
<%@ page import="com.mongodb.Block"%>
<%@ page import="com.mongodb.client.FindIterable"%>
<%@ page import="com.mongodb.client.MongoCollection"%>
<%@ page import="model.MongoConnect" %>
<%@ page import="model.User"%>
<%@ page import="static java.util.Arrays.asList"%>
<%@ page import="java.io.File"%>
<%@ page import="java.io.FileInputStream"%>
<%@ page import="java.io.InputStream"%>
<%@ page import="com.mongodb.client.gridfs.GridFSBucket"%>
<%@ page import="com.mongodb.client.gridfs.GridFSBuckets"%>
<%@ page import="com.mongodb.client.gridfs.model.GridFSFile"%>
<%@ page import="com.mongodb.client.gridfs.model.GridFSUploadOptions"%>
<%@ page import="com.mongodb.client.model.Filters"%>
<%@ page import="java.io.FileOutputStream" %>

<%@ page import="org.bson.Document"%>
<%@ page import="org.bson.types.ObjectId"%>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MYUMIX Template</title>

 <script src="jquery.js"></script>
        <script>
            $(function(){
                $("#container").load("header.html");
            });
        </script>

<%String message = (String) session.getAttribute("message");%>

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
	<%
	MongoDatabase db1 = MongoConnect.connect();
	MongoCollection<Document> collection1 = db1.getCollection("images.files");
	GridFSBucket gridBucket = GridFSBuckets.create(db1,"images.files");
	FindIterable<Document> it1=collection1.find(new Document("metadata",new Document("email",User.mail)));
	
	//String fil="../img/"+it1.first().getString("filename");
	//FileOutputStream fileOutputStream = new FileOutputStream(fil);
	//gridBucket.downloadToStream(it1.first().getString("filename"), fileOutputStream);
	
	for(Document doc : it1){}
	%>
    <div class="span_2a column" >
      <table  width=100% style=" border-collapse: separate; border-spacing: 15px; font-size:20px; text-align:center;" >
        <tr><td>
    	    <!--  <object data="<% %>" type="image/png" class="img-circle"  width=100px height=100px> -->
        	<img src="" alt="images/person.png"  class="img-circle"  width=100px height=100px >
        
        </td></tr>
      </table>
    </div>
    
    <%
	MongoDatabase db = MongoConnect.connect();
	MongoCollection<Document> collection = db.getCollection("User");
	FindIterable<Document> it = null;
	it=collection.find(new Document("email",User.mail));
    for(Document doc : it){
    	if(doc.getString("namee") != null){
    		
	%>  
    <div class="span_8 column">
      <table width=100% style=" border-collapse: separate; border-spacing: 15px;">
        <tr><th style="text-align:center; font-family: 'Times New Roman', Times, serif; font-size: 20pt;"><%=doc.getString("namee") %></th></tr>
      </table> 
    </div>
    
    <%} else{ %>
    <div class="span_8 column">
      <table width=100% style=" border-collapse: separate; border-spacing: 15px;">
        <tr><th style="text-align:center; font-family: 'Times New Roman', Times, serif; font-size: 20pt;"><%=doc.getString("username") %></th></tr>
      </table> 
    </div>
    <% }} %>
    <div class="span_2b column">
      <table  style=" border-collapse: separate; border-spacing: 15px; font-size:20px; text-align:left;" >
        <tr><td>
        <input type="button"  onclick="location.href='EditProfile.jsp';" style="width:155px;height:30px;background-color: #E6610A;" value="Edit Profile">
        <input type="button" onclick="location.href='EditProfile.jsp';" style="width:155px;height:30px;background-color: #E6610A;" value="Edit Profile">
        </td></tr>
      </table>     
    </div>
  
  </div>
  
  <div class="slider-caption">
  	<%
	MongoDatabase db2 = MongoConnect.connect();
	MongoCollection<Document> collection2 = db2.getCollection("User");
	FindIterable<Document> it2 = null;
	it2=collection.find(new Document("email",User.mail));
    for(Document doc : it2){
	%>
  	
    <div class="span_2 column" >
      <table  width=100% style=" border-collapse: separate; border-spacing: 15px; font-size:20px; text-align:left;" >
        <tr><td align="center"><%= doc.getString("username")%></td></tr>
        <% if(doc.getString("info") != null){%>
        <tr><td align="justify"><%= doc.getString("info") %></td></tr>
      </table>
    </div>
    <%}} %>
    <div class="span_8 column">
      <table border=1 width=100% style=" border-collapse: separate; border-spacing: 15px;">
        <tr style="border-style:hidden;"><th style="text-align:center;">SONGS</th></tr>
        <tr><td>dsf</td></tr>
      </table> 
    </div>
      
    <div class="span_2_2 column">
      <table  width=100% style=" border-collapse: separate; border-spacing: 15px; font-size:20px; text-align:left;" >
        <tr><td><a class="menu" href="MyProfile.jsp">My Profile</a></td></tr>
        <tr><td><a class="menu" href="CreateMusic.jsp">Create Music</a></td></tr>
        <tr><td><a class="menu" href="MyMusic.jsp">My Music</a></td></tr>
        <tr><td><a class="menu" href="WorldMusic.jsp">World Music</a></td></tr>
        <tr><td><a class="menu" href="WorldTunes.jsp">World Tunes</a></td></tr>
        <tr><td><a class="menu" href="">Logout</a></td></tr>
      </table>     
    </div>
  </div>
 <%
if(message==null)
{
	out.println();
}
else
{
%>
<h4 align="center"><font color="white"> <%= message %> </font> </h4>
<% } 
session.invalidate();
message=null;
%>
</div>
<!-- header end -->
</body>
</html>