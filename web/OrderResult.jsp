<%-- 
    Document   : OrderResult
    Created on : Feb 17, 2014, 10:12:30 PM
    Author     : Nathaniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <p>

    <%
        String welcome = (String)request.getAttribute("welcomeMessage");
        out.print(welcome);
    %>
    
    <p><a href="welcome.html">Back
    
    </body>
</html>
