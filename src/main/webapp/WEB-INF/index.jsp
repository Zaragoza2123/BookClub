<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Book Club</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/main.js"></script>
</head>
<body>
	<h1>Welcome!</h1>
	<p>Join our growing community</p>
	<div>
		<div>
			<h1>Register</h1>
			<form:form action="/register" method="POST" modelAttribute="newuser">
			<div>
				<form:label path="userName">Name:</form:label>
				<form:input type="text" path="userName" />
				<form:errors path="userName" />
			</div>
			<div>
				<form:label path="email">Email:</form:label>
				<form:input type="text" path="email" />
				<form:errors path="email" />
			</div>
			<div>
				<form:label path="password">Password:</form:label>
				<form:input type="password" path="password" />
				<form:errors path="password" />
			</div>
			<div>
				<form:label path="confirm">Confirm Password:</form:label>
				<form:input type="password" path="confirm" />
				<form:errors path="confirm" />
			</div>
			<input type="submit" value="Submit"/>
			</form:form>
		</div>
		<div>
			<h1>Login</h1>
			<form:form action="/login" method="POST" modelAttribute="user">
			<div>
				<form:label path="email">Email:</form:label>
				<form:input type="text" path="email" />
				<form:errors path="email" />
			</div>
			<div>
				<form:label path="password">Password:</form:label>
				<form:input type="password" path="password" />
				<form:errors path="password" />
			</div>
			<input type="submit" value="Submit"/>
			</form:form>
		</div>
	
	</div>

</body>
</html>