<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Course Page</title>
<link href="./common/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="/common/menu.jsp"></jsp:include>

<div class="container">
	<div class="row">
		<div class="col-8 mt-5">
			<h3>Add course</h3>
		</div>
		<div class="col-4 mt-5">
				<c:url value="/index.jsp" var="course"></c:url>
				<a href="${course }" class="btn btn-primary">Go back</a>
			</div>
	</div>
	<div class="row">
		<div class="col-6 my-2">
			<hr />
			<c:url value="/add-course" var="add"></c:url>
			<form action="${add }" class="form" method="post">
				<div class="form-group">
					<label> Course Name</label>
					<input type="text" name="courseName" required="required" placeholder="Enter course name" class="form-control" />
				</div>
				
				<div class="form-group">
					<label> Price</label>
					<input type="text" name="price" required="required" placeholder="Enter course price" class="form-control" />
				</div>
				
				<div class="form-group">
					<label for="level">Level</label>
					<select name="level" id="level" class="form-control">
						<option value="basic">Basic</option>
						<option value="intermediate">Intermediate</option>
						<option value="advanced">Advanced</option>
					</select>
				</div>
				
				<div class="form-group">
					<label>Duration (Months)</label>
					<input type="number" name="duration" required="required" placeholder="Enter course duration" class="form-control" />
				</div>
				
				<div class="form-group">
					<label> Start Date</label>
					<input type="date" name="date" required="required" class="form-control" />
				</div>
				<div class="form-group">
						<button type="submit" class="btn btn-outline-primary">Save</button>
						<button type="submit" class="btn btn-outline-danger float-right">Reset</button>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>