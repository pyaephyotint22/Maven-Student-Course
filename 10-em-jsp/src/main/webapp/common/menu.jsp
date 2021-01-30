<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
 
  <c:url value="/common/css/bootstrap.min.css" var="bsCSS"></c:url>
  <c:url value="/common/js/bootstrap.min.js" var="bsJS"></c:url>
   <c:url value="/common/js/jquery.min.js" var="jqJS"></c:url>
  
  
<link href="${bsCSS }" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${jqJS}"></script>
<script type="text/javascript" src="${bsJS}"></script>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
			  <ul class="navbar-nav">
			 
			  <li class="nav-item">
			 
              <a class="nav-link ${empty title ? 'active' :'' }" >Courses</a>
             </li>
		        <li class="nav-item">
		        <c:url value="/course-add.jsp" var="courseAdd"></c:url>
		          <a class="nav-link  ${(not empty title and title=='addcourse') ? 'active' :''}" href="${courseAdd }">Add course</a>
		        </li>
		        <li class="nav-item">
		        <c:url value="/students.jsp" var="student"></c:url>
                <a class="nav-link" href="${student }">Students</a>
             </li>
		        <li class="nav-item">
		        <c:url value="/student-add.jsp" var="studentAdd"></c:url>
		          <a class="nav-link" href="${studentAdd}">Add Student</a>
		        </li>
			  </ul>
		</nav>