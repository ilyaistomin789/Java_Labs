package by.belstu.istomin.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class Bbb extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("BbbHeader1", "BbbHeader1");
        resp.setHeader("BbbHeader2", "BbbHeader2");
        PrintWriter pw = resp.getWriter();
        pw.println(String.format("%s", req.getHeader("header1")));
        pw.println("<br/>");
        pw.println(String.format("%s", req.getHeader("header2")));
        pw.println("<br/>");
        pw.println(String.format("%s", req.getHeader("header3")));
        pw.println("<br/>");
        pw.println(String.format("%s", req.getParameter("param1")));
        pw.println("<br/>");
        pw.println(String.format("%s", req.getParameter("param2")));
        pw.println("<br/>");
        pw.println(String.format("%s", req.getParameter("param3")));
        pw.println("<br/>");

        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = req.getHeader(key);
            pw.println(key + ": " + value);
            pw.println("<br/>");
        }
        pw.flush();
    }
}
