<%-- 
    Document   : UserIndexPage
    Created on : 05 6, 15, 3:04:42 PM
    Author     : asi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Type</title>
    </head>
    <body>
        <%
            String type = request.getParameter("type");
            String name = request.getParameter("name");
            String course = request.getParameter("course");
            String lang[] = request.getParameterValues("lang");
        %>
        <h1><%=name%>, <%=course%></h1>
        <h2>Type: <%=type%></h2>
        <p>This paragraph is specific to the User Type Page. Plebian.</p>
    </body>
</html>
