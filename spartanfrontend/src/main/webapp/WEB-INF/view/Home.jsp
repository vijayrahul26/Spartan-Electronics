<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Home</title>
</head>
<style>
img {
    max-width: 100%;
    height: 100%;
}
</style>
</head>
<body>
<center>
<img src="resources/images/th.jpg">
</center>
<jsp:include page="Header.jsp"/>
<br>
<div class="container">
 <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
      <li data-target="#myCarousel" data-slide-to="4"></li>
    
    </ol>

    <!-- Wrapper for slides -->
    <center>
    <div class="carousel-inner">
      <div class="item active">
       <img src="resources/images/laptop.jpg"alt="Picture1">
      </div>

      <div class="item">
        <img src="resources/images/mobile.jpg"alt="Picture2" >
      </div>
    
      <div class="item">
        <img src="resources/images/pendrive.jpg"alt="Picture3">
      </div>
      
      <div class="item">
        <img src="resources/images/headset.jpg"alt="Picture4">
      </div>
      
    <div class="item">
        <img src="resources/images/speaker.jpg"alt="Picture5">
      </div>
    
    </div>
    </center>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div><br><br>
<jsp:include page="Footer.jsp"/>
</body>
</html>
