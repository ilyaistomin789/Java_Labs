package by.belstu.istomin.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Ttt extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(
                "<br/>surname: " + req.getParameter("surname") +
                        "<br/>lastname: " + req.getParameter("lastname") +
                        "<br/>sex: " + req.getParameter("sex")
        );
    }
}
