<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MYUMIX Template</title>
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
</div>

<!-- header end -->

<div class="clear"></div>
<!-- contact start -->
<div class="templatemo_contactwrapper" id="templatemo_contact_page" style="margin-top:30px;">
  <div class="container">
    <div class="row">	
      <h1>Contact</h1>
    </div>
  </div>
  <!--  <div class="templatemo_contactmap">
    <div id="templatemo_map"></div>
  </div> -->
  <div class="container templatemo_contactmargin">
    <div class="row">
      <div class="col-md-3">
        <div class="templatemo_address_title">Mailing Address:</div>
        No 123, National Institute Of Technology, Karnataka
        <div class="clear"></div>
        <div class="templatemo_address_left">Call us:</div>
        <div class="templatemo_address_right">+001 333 000 1010<br>
          +002 666 000 2020</div>
        <div class="clear"></div>
        <div class="templatemo_address_left">Hot line:</div>
        <div class="templatemo_address_right">+009 000 999 0000</div>
        <div class="clear"></div>
        <div class="templatemo_address_left">Email us:</div>
        <div class="templatemo_address_right">admin@company.com<br>
          info@company.com</div>
      </div>
      <form action="contactController" method="post">
        <div class="col-md-9">
          <div class="col-md-4">
            <input type="text" name="name" id="name" class="name" placeholder="Your Name">
          </div>
          <div class="col-md-4">
            <input type="text" name="email" id="email" class="email" placeholder="Your Email">
          </div>
          <div class="col-md-4">
            <input type="text" name="subject" id="subject" class="subject" placeholder="Subject">
          </div>
          <div class="col-md-12">
            <textarea name="msg" cols="1" rows="1" class="message" placeholder="Your message... " id="message"></textarea>
          </div>
          <div class="col-md-4">
            <input type="submit" name="send" value="Send Message" id="submit" class="button templatemo_sendbtn">
          </div>
        </div>
      </form>
    </div>
  </div>
</div>
<!-- contact end -->  
</body>
</html>