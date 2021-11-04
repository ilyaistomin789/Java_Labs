<%--
  Created by IntelliJ IDEA.
  User: ilyai
  Date: 06.10.2021
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="taglib" uri="taglib.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ttt</title>
</head>
<body>
<taglib:dossier action="/java_5/Ttt">
    <taglib:surname name="surname"/>
    <taglib:lastname name="lastname"/>
    <taglib:sex name="sex"/>
    <taglib:submit type="OK"/>
    <taglib:submit type="CANCEL"/>
</taglib:dossier>

</body>
</html>
