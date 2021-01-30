<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Education</title>
<link href="./common/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<!-- menu -->
<jsp:include page="/common/menu.jsp"></jsp:include>
<div class="container">
	<div class="row">
		<div class="col-10 mt-5">
			<h3>All students</h3> 
		</div>
		<div class="col-2 mt-5">
				<c:url value="/student-add.jsp" var="studentadd"></c:url>
				<a href="${studentadd }" class="btn btn-primary">Add Student</a>
		</div>
	</div>
	<div class="row">
		<table class="table border-dark">
			<tr>
			<th><ID/th>
					<th>Photo</th>
					<th>Name</th>
					<th>Email</th>
					<th>Year</th>
					<th>Age</th>
					<th>Address</th>
					<th>Date of birth</th>
					<th>Action</th>
					
					
			</tr>
			<c:forEach items="${studentlist}" var="student">
				<tr>
				<td>${student.id}</td>
					<td>
					<img src="/10-em-jsp/imgUploads/${student.profile}" alt="Image" width="100" height="100"/>
					</td>
					<td>${student.name }</td>
					<td>${student.email }</td>
					<td>${student.year }</td>
					<td>${student.age }</td>
					<td>${student.address }</td>
					<td>${student.dateOfBirth }</td>
					<td>
						<c:url value="/edit-student" var="edit">
							<c:param name="id" value="${student.id}"></c:param>
						</c:url>
						<a href="${student.id}" class="btn btn-outline-primary">Edit</a>
						
						<c:url value="/remove-student" var="remove">
							<c:param name="studentId" value="${student.id}"></c:param>
						</c:url>
						
					<a href="${remove}" class="btn btn-outline-danger">Remove</a>
					</td>
				</tr>
				</c:forEach>
		</table>
	</div>
</div>
</body>
</html>