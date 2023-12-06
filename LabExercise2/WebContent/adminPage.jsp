<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
	
	<!-- scripting element -->
	<%--jsp comment --%>
	
	<% User user = (User)request.getAttribute("user"); %>
	
	<h1>Admin Page</h1>
	
	<p>You are successfully logged in!</p>
	<p>Welcome <%= user.getUserName() %></p>

</body>
</html>