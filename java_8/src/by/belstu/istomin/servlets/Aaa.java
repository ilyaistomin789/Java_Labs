package by.belstu.istomin.servlets;

import by.belstu.istomin.clients.CustomHttpClient;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Aaa extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clientResponse = CustomHttpClient.getResponseFromBbb("http://localhost:8080/java_8/Bbb", "param1", "param2", "param3", "header1", "header2", "header3");
        resp.addHeader("Content-Type", "text/html");
        PrintWriter pw = resp.getWriter();
        pw.write(clientResponse);
        pw.flush();
    }
}
