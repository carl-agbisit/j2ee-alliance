<%
    response.setHeader("Cache-Control","no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", -1);
    if(session.getAttribute("username") != null)
    {   
%>