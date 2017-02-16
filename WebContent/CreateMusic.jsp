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
          <tr><td><button type="submit" onclick="prompt('Enter location you wanna search: ');" style="width:175px;height:60px;background-color: #E6610A;">WANNA SEE LOCATION WISE</button></td></tr>
          <tr><td><a class="menu" href="MyProfile.jsp">My Profile</a></td></tr>
          <tr><td><a class="menu" href="CreateMusic.jsp">Create Music</a></td></tr>
          <tr><td><a class="menu" href="MyMusic.jsp">My Music</a></td></tr>
          
          <tr><td><a class="menu" href="WorldMusic.jsp">World Music</a></td></tr>
          <tr><td><a class="menu" href="WorldTunes.jsp">World Tunes</a></td></tr>
          <tr><td><a class="menu" href="Help.html">Help</a></td></tr>
          <tr><td><a class="menu" href="Contact.jsp">Contact Us</a></td></tr>
        </table>
      </div>
      
      <div class="span_10 column">

<form method="post" enctype="multipart/form-data" action="UploadController">

<input type="file" id="tune" name="tune" accept="audio/*" style="width:93px; height:30px;"><br>

<input type="submit" value="upload tune" class="btn">

</form>           
      </div>
      
  </div>

</div>
<!-- header end -->
</body>
</html>
