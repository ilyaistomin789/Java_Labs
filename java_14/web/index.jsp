<%--
  Created by IntelliJ IDEA.
  User: ilyai
  Date: 02.11.2021
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="/java_14/MailServlet">get 10 messages</a>
  <form action="MailServlet" method="post">
    <label>
      Mail
      <input type="text" name="mail"/>
    </label>
    <label>
      Message
      <input type="text" name="message"/>
    </label>
    <input type="submit" name="press" value="POST"/>
  </form>
  </body>
</html>
