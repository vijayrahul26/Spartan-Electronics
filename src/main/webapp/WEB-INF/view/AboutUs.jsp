<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/bootstrap.min.js"></script>
<head>
<style>
img {
    max-width: 100%;
    max-height: 100%;
}
.container {
    position: relative;
    text-align: center;
    color: black;
}

.centered {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
}
</style>
</head>
<body>
<jsp:include page="Header.jsp"/>
<center>
<img src="resources\images\th.jpg">
</center>
<div class="container">
<img src="resources\images\wall.jpg">
<div class="centered">
<p>
<h4>
<p>This is a marketplace with a mission to deliver an outstanding shopping experience and offer a good brand of eletronics devices of your interest.

<p>We empower retailers to build individual relationships and go the extra mile for their customers. We are located in India. It is one of the growing website for purchasing electronics.

<p>We take privacy and security very seriously. Every transaction is protected and your information is kept on password protected, limited access servers.

<p>Wherever possible and applicable, our servers reside behind a corporate firewall that maintains access control to the system from both our internal network and the Internet.
</h4>
</div>
</div>
<jsp:include page="Footer.jsp"/>
</body>
</html>