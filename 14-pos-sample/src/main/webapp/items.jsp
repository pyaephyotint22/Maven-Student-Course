<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Items</title>
</head>
<body>
	<div class="container">
		<jsp:include page="/common/menu.jsp"></jsp:include>
		<div class="row mt-2">
			<div class="col">
			<h3>All Items</h3>
			</div>
		</div>
		<table class="table">
		 <thead>
		 	<tr>
		 	<th>ID</th>
		 	<th>Product</th>
		 	<th>Price</th>
		 	<th>Expired Date</th>
		 	<th>Category</th>
		 	<th></th>
		 	</tr>
		 </thead>
		 <tbody>
		 <c:forEach items="${itemlist}" var="i">
		 	<tr>
		 		<td>${i.id}</td>
		 		<td>${i.name}</td>
		 		<td>${i.price}</td>
		 		<td>${i.expiredate}</td>
		 		<td>${i.category.name}</td>
		 		<td>
		 		<c:url value="/item-edit" var="edit">
		 			<c:param name="id" value="${i.id}"></c:param>
		 		</c:url>
		 		<a href="${edit}"><i class="fa fa-edit"></i>Edit</a>
		 		</td>
		 	</tr>
		 </c:forEach>
		 </tbody>
		</table>
	</div>
</body>
</html>