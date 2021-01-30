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
			<h3>${courselist !=null ? 'Edit Course' : 'Add New Course'}</h3>
		</div>
		<div class="col-4 mt-5">
				<c:url value="/index.jsp" var="course"></c:url>
				<a href="${course}" class="btn btn-primary">Go back</a>
			</div>
	</div>
	<div class="row">
		<div class="col-6 my-2">
			<hr />
			<c:url value="/add-course" var="add"></c:url>
			 <form action="${add }" class="form" method="post">
			<input type="hidden" name="courseid" value="${courselist.id}"/>
				<div class="form-group">
					<label> Course Name</label>
					<input type="text" value="${courselist.name}" name="courseName" required="required" placeholder="Enter course name" class="form-control" />
				</div>
				
				<div class="form-group">
					<label> Price</label>
					<input type="text" value="${courselist.price}" name="price" required="required" placeholder="Enter course price" class="form-control" />
				</div>
				
				<div class="form-group">
					<label for="level">Level</label>
					<select name="level" id="level" class="form-control">
						<option value="basic"${courselist.level == 'Basic' ? 'selected' :'' } >Basic</option>
						<option value="intermediate" ${courselist.level == 'Intermediate' ? 'selected' :'' } >Intermediate</option>
						<option value="advanced" ${courselist.level == 'Advanced' ? 'selected' :'' }>Advanced</option>
					</select>
				</div>
				
				<div class="form-group">
					<label>Duration (Months)</label>
					<input type="number" value="${courselist.duration}" name="duration" required="required" placeholder="Enter course duration" class="form-control" />
				</div>
				
				<div class="form-group">
					<label> Start Date</label>
					<input type="date"value="${courselist.startDate}" name="date" required="required" class="form-control" />
				</div>
				<div class="form-group">
						<button type="submit" class="btn btn-outline-primary">Save</button>
						<button type="submit" class="btn btn-outline-danger float-right">Reset</button>
				</div>
			</form> -
		</div>
	</div>
</div>
</body>
</html>