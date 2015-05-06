<%-- 
    Document   : home
    Created on : 05 6, 15, 3:41:11 PM
    Author     : asi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div><a href="home.jsp">Home</a></div>
        <div><a href="profile.jsp">Profile</a></div>
        <h1>You have Logged in, <% out.println(session.getAttribute("username"));%>!</h1>
    </body>
</html>
