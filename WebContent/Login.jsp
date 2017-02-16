<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MYUMIX Template</title>

 <script src="jquery.js"></script>
        <script>
            $(function(){
                $("#container").load("header.html");
            });
        </script>

<%String message = (String) session.getAttribute("message");
	
%>
<meta name="keywords" content="">
<meta name="description" content="">
<meta charset="utf-8">
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
        <div class="templatemo_titlewrapper"><img src="images/templatemo_logobg.png" alt="logo background">
          <div class="templatemo_title"><span>MYUMIX</span></div>
        </div>
        <div class="clear"></div>
        <div class="templatemo_titlewrappersmall">MYUMIX</div>
        <nav class="navbar navbar-default templatemo_menu" role="navigation">
          <div class="container-fluid"> 
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"><span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span></button>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div id="top-menu">
              <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                  <li><a class="menu" href="Index.jsp">Index</a></li>                
                  <li><a class="menu" href="Login.jsp">Login</a></li>
                  <li><a class="menu" href="Help.html">Help</a></li>
                  
                  <li><a class="menu" href="Team.jsp">Our Team</a></li>
                  <li><a class="menu" href="Contact.jsp">Contact</a></li>
                </ul>
              </div>
            </div>
            <!-- /.navbar-collapse --> 
          </div>
          <!-- /.container-fluid --> 
        </nav>
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
  
  <div class="slider-caption">
  <form action="LoginController" method="post">
    <table width=100% style=" border-collapse: separate; border-spacing: 15px;" border=1>  
        <div class="templatemo_homewrapper">
          <tr>
            <td align="right">Email/Username</td>
            <td align="left"><input type="text" size="30" placeholder="Enter your email/username" name="user"> </td>
          </tr>
          <tr>
              <td align="right">Password</td>
              <td align="left"><input type="password" size="30" placeholder="Enter your password" name="password"> </td>
          </tr>
          <tr>
            <td align="right">
              <button type="submit" style="width:75px;height:30px;background-color: #E6610A;">Login</button>
            </td>
            <td align="">
				<input type="button" style="width:75px;height:30px;background-color: #E6610A;" onclick="location.href='register.jsp';" value="Register">           
            </td>
          </tr>
         </div>
      </table> 
  </form>

  
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
</div>
<!-- header end -->
<div class="clear"></div>
</body>
</html>