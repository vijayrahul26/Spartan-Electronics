<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="Header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
input[type=text],input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}
<title>Insert title here</title>
</style>
</head>
<body>
<span style="color:red">${error}</span><br>
${msg}<br>
<center>
<h1>
<b>Login</b>
</h1>
</center>
<c:url value="/j_spring_security_check" var="url"></c:url>
<form method="post" action="${url }">
<label for="email"><b> Enter Email</b></label>
<input type="text" name="j_username"><br>
 <label for="psw"><b> Enter Password</b></label>
 <center>
<input type="password" name="j_password">
<input type="submit" value="Login">
<label>
<input type="checkbox" checked="checked" name="remember"> Remember me
</label>
</center>
<jsp:include page="Footer.jsp"/>
</form>
</body>
</html>