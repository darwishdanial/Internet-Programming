<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping Cart Example Using JSP</title>
</head>
<body bgcolor="#33CCFF">
	
	<p>
	<center>
		<form name="shoppingForm" action="ShopingServlet" method="POST"> 
		<select name=VCD>
		    <option>MI2 | Tom Cruise | RM15.95</option>
		    <option>The Grinch | Jim Carrey | RM16.95</option>
		    <option>The Sixth Day | Arnold Shwarzeneeger | RM16.95</option>
		    <option>Unbreakable | Bruce Willis | RM13.95</option>
		    <option>The Killer | Chow Yuen Fatt | RM14.95</option>
		    <option>Snake Eyes | Nicholas Cage | RM12.95</option>
		    <option>Blade | Wesley Snipes | RM14.95</option>
		</select>
			<input type="hidden" name="action" value="ADD">
			<b>Quantity: </b><input type="text" name="qty" SIZE="3" value=1>
			<INPUT NAME="reset" TYPE="reset" VALUE="Reset">
			 <INPUT NAME="submit" TYPE="submit" VALUE="Submit">
		</form>
	</center>
	<center>
		<p><a href="ShopingServlet?action=VIEW">view</a>&nbsp;&nbsp;<a href="ShopingServlet?action=CHECKOUT">checkout</a>&nbsp;&nbsp;<a href="ShopingServlet?action=LOGOUT">logout/remove</a>
	</center>
	</body>

</html>