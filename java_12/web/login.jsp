<%--
  Created by IntelliJ IDEA.
  User: ilyai
  Date: 27.10.2021
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form method="post" action="j_security_check">
    <label>
        username
        <input type="text" name="j_username"/>
    </label>
    <label>
        password
        <input type="password" name="j_password"/>
    </label>
    <input type="submit"/>
</form>
</body>
</html>
