<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Coach Page</title>
</head>
<body>
	<!-- action element -->
	
	<h1>Coach Page</h1>
    
    <jsp:useBean id="user" class="model.User" scope="request" />
    
    <p>You are successfully logged in!</p>
    <p>Welcome <jsp:getProperty name="user" property="userName" /></p>

	

</body>
</html>