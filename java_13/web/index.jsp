<%@ page import="by.belstu.istomin.ChoiceWord" %><%--
  Created by IntelliJ IDEA.
  User: ilyai
  Date: 02.11.2021
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
INDEX
<a href="/java_13/Sss">Sss</a>

<%
    String d = (String) request.getServletContext().getInitParameter("word-dir");
    ChoiceWord ch = new ChoiceWord(d, "docx");
    String foundedFile = null;
    for (int i = 0; i < ch.wordList.length; i++) {
        foundedFile = ch.wordList[i];
%>
<br />
<a href="/java_13/GetWord?file=<%=foundedFile%>"> <%=foundedFile%> </a>
<%}%>

</body>
</html>
