<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EL Demo</title>
</head>
<body>
	<h3>Expression Language Demo</h3>
	<form>
		<table>
				<tr>
					<td>User Name</td>
					<td> 
						<input type="text" name="uname" value="${param.uname}" />
					</td>
					</tr>
				
				<tr>
					<td>Email</td>
					<td> 
						<input type="email" name="email" value="${param.email}"/>
					</td>
				</tr>
				<tr>
					<td>Address</td>
					<td> 
						<input type="text" name="address"  value="${param.address}"/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td> 
						<button type="submit">Display</button>
					</td>
				</tr>
		</table>
	</form>
	<hr />
	<h4>Result</h4>
	<c:if test="${( not empty param.uname) and (param.email !=null ) and (param.address ne null)}">
	 User Name:${param.uname} <br />
	Email:${param.email} <br />
	Address:${param.address} <br />
	</c:if>
	
</body>
</html>