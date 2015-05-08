<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>
        <%@include file="navigation.jsp" %>
        <h2>
            MODE: <c:out value="${mode}"/><br>
            ID: <c:out value="${user.userid}"/>
        </h2>
        <form method="POST" action="usercontrol">
            <p>
                <input type="hidden" name="mode" value="<c:out value="${mode}"/>"/>
                <input type="hidden" name="id" value="<c:out value="${user.userid}"/>"/>
                Username: <input type="text" name="username"/><br>
                Password: <input type="password" name="password"/><br><br>
                <input type="submit"/>
            </p>
        </form>
    </body>
</html>
<%@include file="footer.jsp" %>