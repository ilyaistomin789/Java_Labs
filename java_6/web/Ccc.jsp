<%@ page import="by.belstu.istomin.CBean" %><%--
  Created by IntelliJ IDEA.
  User: ilyai
  Date: 07.10.2021
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%CBean cBeanInst = (CBean) request.getServletContext().getAttribute("atrCBean");%>
</head>
<body>
    <h1>GET PARAMS</h1>
<p>Value1 <%=cBeanInst.getValue1()%></p>
<p>Value2 <%=cBeanInst.getValue2()%></p>
<p>Value3 <%=cBeanInst.getValue3()%></p>
</body>
</html>
