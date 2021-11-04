package by.belstu.istomin.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class UrlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String urlParameter = req.getParameter("Urln");
        PrintWriter pw = resp.getWriter();
        resp.setHeader("Content-Type", "text/html");
        if (urlParameter == null) {
            pw.println("parameter URLn not found");
        } else {
            if (urlParameter.equals("1")) {
                resp.sendRedirect(getServletContext().getInitParameter("URL1"));
            } else if (urlParameter.equals("2")) {
                resp.sendRedirect(getServletContext().getInitParameter("URL2"));
            } else {
                pw.println("parameter URLn not found");
            }
        }
    }
}
