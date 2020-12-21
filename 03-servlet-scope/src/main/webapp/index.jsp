<%@page import="com.mmit.scope.Counter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Scope</title>
</head>
<body>
	<h1>Scope Object</h1>
	<table>
	<tr>
		<td>Application Scope</td>
		<td>
		<%
		Counter appCounter=(Counter)application.getAttribute("counter");
		out.println((appCounter==null)? 0:appCounter.getCount());
		%>
		</td>
	</tr>
	<tr>
	<td>Session Scope</td>
		<td>
		<%
		Counter sessionCounter=(Counter)session.getAttribute("counter");
		out.println((sessionCounter==null)? 0:sessionCounter.getCount());
		%>
		</td>
	</tr>
	<tr>
	<td>Request Scope</td>
		<td>
		<%
		Counter reqCounter=(Counter)request.getAttribute("counter");
		out.println((reqCounter==null)? 0:reqCounter.getCount());
		%>
		</td>
	</tr>
	<tr>
	<td></td>
	<td>
	<a href="count">Count Up</a>
	</td>
  </tr>
	</table>
</body>
</html>