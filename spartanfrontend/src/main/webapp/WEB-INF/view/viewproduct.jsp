<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="Header.jsp"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
         <div class="panel-info">
			<div class="panel panel-heading">Product Details</div>
			<div class="panel panel-body">
			<c:url value="/cart/addtocart/${productObj.id}" var="url"></c:url>
			<form action="${url }" >
			<img src="<c:url value='/resources/images/${productObj.id}.jpg'></c:url>"><br>
			<b>Product Name:       </b>${productObj.productName }<br>
			<b>Product Description:</b>${productObj.productDescription }<br>
			<b>Product Price:      </b>${productObj.productPrice }<br>
			<b>Product Quantity:   </b>${productObj.productQuantity }<br>
			<b>Category:</b>${productObj.category.categoryName}<br>
			<c:if test="${productObj.productQuantity==0 }">
			<button class="btn btn-primary btn-lg" disabled>Out Of Stock</button>
			</c:if>
			<c:if test="${productObj.productQuantity>0 }">
			<security:authorize access="hasRole('ROLE_USER')">
	        Enter Quantity:<input type="number" min="1" max="${productObj.productQuantity }" name="requestedQuantity">
		    <button class="btn btn-lg"><span class="glyphicon glyphicon-shopping-cart" ></span>Add To Cart</button>
			</security:authorize>
			</c:if>
			</form>
			</div>
		    </div>
	        </div>
	        <a href="<c:url value='/all/getallproducts'></c:url>">Browse all products</a>
            </body>
            </html>