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
		<h1><c:out value="${book.title}"/></h1>
		<a href="/home">back to the shelves</a>
		<p>You read <c:out value="${book.title}"/> by <c:out value="${book.author}"/></p>
		<p>Here are your thoughts:</p>
		<p><c:out value="${book.thoughts}"/></p>
		<a href="/edit/${book.id}">Edit</a>
</body>
</html>