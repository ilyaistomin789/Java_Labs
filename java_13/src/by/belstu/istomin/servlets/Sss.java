package by.belstu.istomin.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Sss extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet:Sss");
        String docDir = getServletContext().getInitParameter("doc-dir");
        System.out.println(docDir);
        resp.getWriter().println("Servlet:Sss");
    }
}
