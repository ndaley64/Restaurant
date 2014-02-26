<%-- 
    Document   : OrderResult
    Created on : Feb 17, 2014, 10:12:30 PM
    Author     : Nathaniel
--%>

<%@page import="DAO.MenuItem"%>
<%@page import="java.util.List"%>
<%@page import="java.text.NumberFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <p>

    <h2>Thank you! Your meal order has been placed.</h2>
        <p>You ordered the following:</p>
        <ul>
            <%
                double totalBill = 0;
                double tip = 0;
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                Object order = request.getAttribute("order");
                if(order != null) {
                    List<MenuItem> orderList = (List<MenuItem>)order;
                    for(MenuItem item : orderList) {
                        out.println("<li>" + item.getItemName() + ", " + nf.format(Double.valueOf(item.getItemPrice())) + "</li>");
                        totalBill += Double.valueOf(item.getItemPrice());
                    }
                    out.println("<br/><br/>");
                    out.println("Subtotal: " + nf.format(totalBill) + "<br/>");
                    out.println("WI Tax: " + (nf.format(totalBill * .05)) + "<br/>");
                    out.println("Total Bill: " + (nf.format(totalBill * 1.05)) + "<br/>");
                    out.println("Suggested Gratuity: " + (nf.format(totalBill * 1.05 * 0.15)) + "<br/>");
                } else {
                    out.print("Sorry, your order could not be found. Please contact your waiter/waitress");
                }
            %>
    
    <p><a href="welcome.html">Back
    
    </body>
</html>
