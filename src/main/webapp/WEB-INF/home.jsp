<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Book Club</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/main.js"></script>
</head>
<body>
	<h1>Welcome, <c:out value="${userName}"/> </h1>
	<a href="/logout">logout</a>
	<p>Books from everyone's shelves</p>
	<a href="/book">+ Add to my shelf!</a>
	
	<table>
		<tr>
			<th>ID</th>
			<th></th>
			<th>Title</th>
			<th></th>
			<th>Author Name</th>
			<th></th>
			<th>Posted By</th>
		</tr>
	<c:forEach items="${books}" var="i">	
		<tr>
			<td>${i.id}<td>
			<td><a href="/books/${i.id}">${i.title}</a><td>
			<td>${i.author}<td>
			<td>${i.user.userName}<td>
			
		</tr>
		</c:forEach>
	</table>
</body>
</html>