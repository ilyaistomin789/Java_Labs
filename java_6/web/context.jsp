<%--
  Created by IntelliJ IDEA.
  User: ilyai
  Date: 07.10.2021
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%String URL1 = request.getServletContext().getInitParameter("URL1"), URL2= request.getServletContext().getInitParameter("URL2");%>
</head>
<body>
URL 1 = <%=URL1%>
URL 2 = <%=URL2%>
</body>
</html>
