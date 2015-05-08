<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <%@include file="navigation.jsp" %>
        <h1>You have Logged in, <% out.println(session.getAttribute("username"));%>!</h1>
        <hr>
        <h2><a href="usercontrol?action=add">Add User</a></h2><br>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th colspan="2">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td><c:out value="${user.userid}"/></td>
                        <td><c:out value="${user.username}"/></td>
                        <td><c:out value="${user.password}"/></td>
                        <td><a href="usercontrol?action=edit&userid=<c:out value="${user.userid}"/>"/>Edit</td>
                        <td><a href="usercontrol?action=delete&userid=<c:out value="${user.userid}"/>"/>Delete</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <!--
        /*<%
            String username = request.getParameter("username");
        %>*/
        <h1>You have Logged in, <%=username%>!</h1>
        -->
    </body>
</html>
<%@include file="footer.jsp" %>
