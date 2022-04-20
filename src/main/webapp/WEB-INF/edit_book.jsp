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
	
	<h1>Change your Entry</h1>
	<a href="/home">back to the shelves</a>
	
	<form:form action="/edit/${book.id}" method="POST" modelAttribute="book">
		<form:input type="hidden" path="user" value="${user_id}"/>
		<div>
			<form:label path="title">Title:</form:label>
			<form:input type="text" path="title" />
			<form:errors path="title" />
		</div>
		<div>
			<form:label path="author">Author:</form:label>
			<form:input type="text" path="author" />
			<form:errors path="author" />
		</div>
		<div>
			<form:label path="thoughts">My Thoughts:</form:label>
			<form:textarea path="thoughts" />
			<form:errors path="thoughts" />
		</div>
		<input type="submit" value="Submit"/>
		
	</form:form>
</body>
</html>