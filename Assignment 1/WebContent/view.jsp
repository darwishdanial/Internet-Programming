<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shopping Cart Example - View Cart</title>
</head>
<body bgcolor="#33CCFF">
    <center>
        <table border="0" cellpadding="0" width="100%" bgcolor="#FFFFFF">
            <tr>
                <td><b>VCD TITLE</b></td>
                <td><b>ACTOR</b></td>
                <td><b>PRICE</b></td>
                <td><b>QUANTITY</b></td>
                <td></td>
            </tr>
            <%@ page import="java.util.Vector" %>
            <%@ page import="model.VCDBean" %>
            <% Vector buylist = (Vector) session.getAttribute("cart"); %>
                <% for (int index = 0; index < buylist.size(); index++) {
                       VCDBean anOrder = (VCDBean) buylist.elementAt(index); %>
  					<tr>
                        <td><b><%= anOrder.getTitle() %></b></td>
                        <td><b><%= anOrder.getActor() %></b></td>
                        <td><b><%= anOrder.getPrice() %></b></td>
                        <td><b><%= anOrder.getQuantity() %></b></td>4
                        <td>
                            <form name="deleteForm" action="ShopingServlet" method="POST">
                                <input type="submit" value="Delete">
                                <input type="hidden" name="delindex" value='<%= index %>'>
                                <input type="hidden" name="action" value="DELETE">
                            </form>
                        </td>
                    </tr>
                <% } %>
                </table>
                <center><a href="index.jsp">shopping</a>&nbsp;&nbsp;<a href="ShopingServlet?action=CHECKOUT">checkout</a>
                &nbsp;&nbsp;<a href="ShopingServlet?action=LOGOUT">logout/remove</a></center>
    </center>
</body>
</html>
