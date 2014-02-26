<%-- 
    Document   : OrderCreator
    Created on : Feb 17, 2014, 10:07:10 PM
    Author     : Nathaniel
--%>

<%@page import="java.util.List"%>
<%@page import="DAO.MenuItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
	List<MenuItem> menu = (List<MenuItem>) request.getAttribute("menu");
        List<MenuItem> orderList = (List<MenuItem>) request.getAttribute("orderList");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="waiter">
                    <%
                        for(MenuItem menuItem : menu) {
                            String itemName = menuItem.getItemName();
                            String itemPrice = menuItem.getItemPrice();
                    %>
                    
                    <!-- Remember, using the %= notation below is a shortcut for out.print -->
                    <input type="checkbox" name="menuItems" value="<%= itemName %>" /> <%= (itemName + ", " + itemPrice) %><br/>
                    
                    <%
                        }
                        
                     %>

                     <br/>
                     <input type="submit" value="Place Order" name="submit">
		</form>
    </body>
</html>
