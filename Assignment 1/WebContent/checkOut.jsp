<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#33CCFF">
    <center>
        <h1>VCD Shopping Checkout</h1>
        <hr>
        <p>
        <center>
            <table border="0" cellpadding="0" width="100%" bgcolor="#FFC0CB">
                <tr>
                    <td><b>VCD TITLE</b></td>
                    <td><b>ACTOR</b></td>
                    <td><b>PRICE</b></td>
                    <td><b>QUANTITY</b></td>
                </tr>
                <%@ page import="java.util.Vector" %>
                <%@ page import="model.VCDBean" %>
                <% Vector buylist = (Vector) session.getAttribute("cart"); %>
                    <% float total = 0; %>
                    <% for (int index = 0; index < buylist.size(); index++) {
                           VCDBean anOrder = (VCDBean) buylist.elementAt(index); %>
                        <tr>
                            <td><b><%= anOrder.getTitle() %></b></td>
                            <td><b><%= anOrder.getActor() %></b></td>
                            <td><b><%= anOrder.getPrice() %></b></td>
                            <td><b><%= anOrder.getQuantity() %></b></td>
                        </tr>
                        <% total += anOrder.getPrice() * anOrder.getQuantity(); %>
                    <% } %>
                    <% total += 0.005; %>
                    <% String amount = new Float(total).toString(); %>
                    <% int n = amount.indexOf('.'); %>
                    <% amount = amount.substring(0, n + 3); %>
                    <tr>
                        <td> </td>
                        <td><b>TOTAL</b></td>
                        <td><b><%= amount %></b></td>
                        <td> </td>
                 </tr>
                </table>
                <p><a href="index.jsp">Shop some more!</a>
            </center>
</body>
</html>
