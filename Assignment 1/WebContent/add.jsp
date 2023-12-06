<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shoping Cart Add Result</title>
</head>
<body bgcolor="#33CCFF" >
            <%@ page import="java.util.Vector" %>
            <%@ page import="model.VCDBean" %>
            <% Vector buylist = (Vector) session.getAttribute("cart");
             VCDBean vcd = (VCDBean) buylist.lastElement();%>
            
            <center><B><%=vcd.getQuantity()%> item added to your shopping cart</B></center><br>
		    <center><a href="ShopingServlet?action=VIEW">view</a>&nbsp;&nbsp;<a href="index.jsp">shopping</a>&nbsp;&nbsp;<a href="ShopingServlet?action=CHECKOUT">checkout</a>
		    &nbsp;&nbsp;<a href="ShopingServlet?action=LOGOUT">logout/remove</a>
		    </center>
</body>
</html>