<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page isELIgnored="false" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- JQuery -->
    <script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
<link href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css" rel="stylesheet">
<title>Insert title here</title>

</head>
<body>
<nav class="navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header" width:180px;margin-left:0">
    </div>
    <ul class="nav navbar-nav" >
   <li><a href="<c:url value='/'></c:url>">Home</a></li>
      <li><a href="<c:url value='/AboutUs'></c:url>">AboutUs</a></li>
      <li class="active"><a href="<c:url value='/all/getallproducts'></c:url>">Browse All Products</a></li>
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="Product">Products by Category <span class="caret"></span></a>
        <ul class="dropdown-menu" style="background-color:black">
                <c:forEach items="${category}" var="category">
				<li><a href="<c:url value='/all/searchByCategory?searchCondition=${category.categoryName}'></c:url>">${category.categoryName}</a>
				</li>
				</c:forEach>
				<li>
				<a href="<c:url value='/all/searchByCategory?searchCondition=All'></c:url>">All</a>
				</li>
				</ul>
				</li>
<li class="active"><a href="<c:url value='/ContactUs'></c:url>"><span class="glyphicon glyphicon-earphone"></span>ContactUs</a></li>
  <security:authorize access="hasRole('ROLE_ADMIN')">
  <li class="active"><a href="<c:url value='/admin/getproductform'></c:url>"><span class="glyphicon glyphicon-plus"></span>Add Product</a></li>
    </security:authorize>
     <security:authorize access="hasRole('ROLE_USER')">
    <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span></a></li>
	</security:authorize>
	</ul>
    <ul class="nav navbar-nav navbar-right">
     <c:if test="${pageContext.request.userPrincipal.name==null }">
      <li><a href="<c:url value='/all/registrationform'></c:url>"><span class="glyphicon glyphicon-user"></span>SignUp</a></li>
      <li><a href="<c:url value='/Login'></c:url>"><span class="glyphicon glyphicon-log-in"></span>Login</a></li> 
     </c:if>
	<c:if test="${pageContext.request.userPrincipal.name!=null }">
				<li><a href="#">Welcome ${pageContext.request.userPrincipal.name }</a></li>
				<li><a href="<c:url value='/j_spring_security_logout'></c:url>">Sign out</a></li>
			    </c:if>
     </ul>
  </div>
</nav>
</body>
</html>