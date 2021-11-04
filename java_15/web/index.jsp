<%--
  Created by IntelliJ IDEA.
  User: ilyai
  Date: 04.11.2021
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script src="script/websocket.js"></script>
</head>
<body>
<h1>Web Sockets</h1>
<section style="width: 215px; border: solid">
    <div style="margin: 5px 5px 5px 5px">
        <button onclick="startSendMessage()" style="width: 100px" id="startButton">Start</button>
        <button onclick="stopSendMessage()" id="stopButton">Stop</button>
        <label for="textarea">Messages</label>
        <textarea id="textarea" rows="20" cols="25" style="text-align: center"
                  readonly></textarea>
    </div>
</section>
</body>
</html>
