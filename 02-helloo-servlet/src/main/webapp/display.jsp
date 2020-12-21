<%@page import="com.mmit.Employee"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Info</title>
<link href="./common/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="./common/js/jquery.min.js"></script>
<script type="text/javascript" src="./common/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
		<div class="row">
			<div class="col">
				<table class="table">
				<tr>
					<th>Login Name</th>
					<th>Email</th>
					<th>Phone</th>
				</tr>
				<%
				List<Employee> list=(ArrayList<Employee>)session.getAttribute("employeeList");
				for(Employee e:list){
					%>
					<tr>
						<td><%=e.getLoginName() %></td>
						<td><%=e.getEmail() %></td>
						<td><%=e.getPhone() %></td>
					</tr>
				<%
				} %>	
			
					
				</table>
				<a href="index.jsp">Go Back</a>
			</div>
		</div>
	</div>

</body>
</html>