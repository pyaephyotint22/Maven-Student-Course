<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
	<h3>User Profile</h3>
	<table>
		<tr>
		<td>Name</td>
		<td>${userinfo.username}</td>
		</tr>
	<tr>
		<td>Email</td>
		<td>${userinfo.email}</td>
		</tr>
		
		<tr>
		<td>Image</td>
		<td>
		<img src="/07-servlet-file-upload/imgUploads/${userinfo.profile}" alt="Image" width="100" height="100"/>
		</td>
		</tr>
	</table>
</body>
</html>