<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Page</title>
    </head>
    <body>
        <%@include file="navigation.jsp" %>
        <h2>Username: <% out.println(session.getAttribute("username"));%></h2>
    </body>
</html>
<%@include file="footer.jsp" %>