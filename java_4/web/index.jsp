<%@ page import="java.util.Calendar" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.net.http.HttpClient" %>
<%@ page import="java.net.http.HttpRequest" %>
<%@ page import="java.net.URI" %>
<%@ page import="java.net.http.HttpResponse" %>
<%@ page import="java.io.IOException" %><%--
  Created by IntelliJ IDEA.
  User: ilyai
  Date: 28.09.2021
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
<%! Calendar rightNow = Calendar.getInstance();
    int hour = rightNow.get(Calendar.HOUR_OF_DAY);
    String selectedPage = "";

    protected String getGreeting(Integer hour) {
        String text = "Good ";
        if (hour > 0 && hour <= 5) {
            text += "night";
            selectedPage = "night.jsp";
        } else if (hour > 5 && hour <= 12) {
            text += "morning";
            selectedPage = "morning.jsp";
        } else if (hour > 12 && hour <= 17) {
            text += "afternoon";
            selectedPage = "afternoon.jsp";
        } else {
            text += "evening";
            selectedPage = "evening.jsp";
        }
        return text;
    }

    protected String getDateTable() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String dateTableHtml = "";
        dateTableHtml += "<table>";
        for (int i = 0; i < 7; i++) {
            int dayOfWeek = localDate.getDayOfWeek().ordinal() + 1;
            dateTableHtml += "<tr>" +
                    "<td>" + localDate.format(formatter) + "</td>";
            if (dayOfWeek == 1) {
                dateTableHtml += "<td>" + "Понедельник" + "</td>";
            } else if (dayOfWeek == 2) {
                dateTableHtml += "<td>" + "Вторник" + "</td>";
            } else if (dayOfWeek == 3) {
                dateTableHtml += "<td>" + "Среда" + "</td>";
            } else if (dayOfWeek == 4) {
                dateTableHtml += "<td>" + "Четверг" + "</td>";
            } else if (dayOfWeek == 5) {
                dateTableHtml += "<td>" + "Пятница" + "</td>";
            } else if (dayOfWeek == 6) {
                dateTableHtml += "<td>" + "Суббота" + "</td>";
            } else if (dayOfWeek == 7) {
                dateTableHtml += "<td>" + "Воскресенье" + "</td>";
            }

            dateTableHtml += "</tr>";
            localDate = localDate.plusDays(1);
        }
        dateTableHtml += "</table>";
        return dateTableHtml;
    }

    protected String getJjjResponse() {
        HttpClient cl = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/java_4/Jjj")).build();
        try {
            HttpResponse<String> httpResponse = cl.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return httpResponse.body();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
%>
</body>
<h1><%=getGreeting(hour)%>
</h1>
<%=getDateTable()%>
<h1>include file</h1>
<%if (selectedPage.equals("night.jsp")) {%>
<%@ include file="night.jsp" %>
<% } %>
<%if (selectedPage.equals("morning.jsp")) {%>
<%@ include file="morning.jsp" %>
<% } %>
<%if (selectedPage.equals("afternoon.jsp")) {%>
<%@ include file="afternoon.jsp" %>
<% } %>
<%if (selectedPage.equals("evening.jsp")) {%>
<%@ include file="evening.jsp" %>
<% } %>

<form action="<%= selectedPage %>">
    <input type="submit" value="Get page"/>
</form>
<h1>jsp:include</h1>
<jsp:include page="<%= selectedPage %>"/>

<h1>Call afternoon servlet</h1>
<jsp:include page="/afternoon"/>
<%--<jsp:forward page="<%= selectedPage %>"/>--%>
<h1>Jjj HTTP REQUEST</h1>
<%=getJjjResponse()%>
<%--<jsp:include page="/Jjj"/>--%>
<form action="Jjj" method="get">
    <input type="submit" value="Go Jjj Get"/>
</form>
<form action="Jjj" method="get">
    <input type="submit" value="Go Jjj Post"/>
</form>
</html>
