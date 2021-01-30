<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${item.id !=0 ? 'Edit' :'Add'} Item</title>
</head>
<body>
	<div class="container">
		<jsp:include page="/common/menu.jsp"></jsp:include>
		<div class="row mt-2">
			<div class="col">
			<h3>${item.id !=0 ? 'Edit' :'Add'} Item</h3>
			</div>
		</div>
		<hr />
		<c:url value="/item-save" var="save"></c:url>
		<form action="${save}" class="form col-6" method="post">
		<input type="hidden" value="${item.id}" name="itemid" />
			<div class="form-group">
			<label>Name</label>
			<input value="${item.name}" type="text" class="form-control" name="name" placeholder="Enter item name" required="required"/> 
			</div>
			<div class="form-group">
			<label>Price</label>
			<input  value="${item.price}" type="number" class="form-control" name="price" placeholder="Enter item price" required="required"/> 
			</div>
			<div class="form-group">
			<label>Expired Date</label>
			<input  value="${item.expiredate}" type="date" class="form-control" name="expired"> 
			</div>
			<div class="form-group">
			<label>Category</label>
			<select class="form-control" name="category">
				<c:forEach items="${categories}" var="c">
					<option value="${c.id}" selected="${item.category.id==c.id ? 'selected' : ''}">${c.name}</option>
				</c:forEach>
			
			</select>
			</div>
			<div class="form-group">
			<button type="submit" class="btn btn-primary">Save</button> 
			<button type="reset" class="btn btn-danger">Clear</button> 
			</div>
		</form>
	</div>
</body>
</html>