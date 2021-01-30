<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
 
  <c:url value="/common/css/bootstrap.min.css" var="bsCSS"></c:url>
   <c:url value="/common/css/font-awesome.min.css" var="faCSS"></c:url>
  <c:url value="/common/js/bootstrap.min.js" var="bsJS"></c:url>
   <c:url value="/common/js/jquery.min.js" var="jqJS"></c:url>
  
  
<link href="${bsCSS }" rel="stylesheet" type="text/css"/>
<link href="${faCSS }" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${jqJS }"></script>
<script type="text/javascript" src="${bsJS }"></script>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
			 <div class="container">
			 <c:url value="/home" var="home"></c:url>
			 <a class="navbar-brand" href="${home}">
              <i class="fa fa-home"></i>
              POS</a>
			  <ul class="navbar-nav mr-auto">
			   
		        <li class="nav-item">
		        <c:url value="/items" var="items"></c:url>
                <a class="nav-link" href="${items}">
                <i class="fa fa-list"></i>
                Items</a>
             </li>
		        <li class="nav-item">
		        <c:url value="/item-add" var="itemadd"></c:url>
		          <a class="nav-link" href="${itemadd}">
		           <i class="fa fa-plus"></i> Add Items</a>
		        </li>
		         <li class="nav-item">
		        <c:url value="/sales" var="sale"></c:url>
		          <a class="nav-link" href="${sale}"> <i class="fa fa-archive"></i> Sale </a>
		        </li>
			  </ul>
			 </div>
		</nav>