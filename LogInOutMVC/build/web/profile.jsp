<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div><a href="home.jsp">Home</a> | 
        <a href="profile.jsp">Profile</a> | 
        <a href="logout">Logout</a></div>
        <h1>You have Logged in, <% out.println(session.getAttribute("username"));%>!</h1>
    </body>
</html>
<%@include file="footer.jsp" %>