package by.belstu.istomin.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Sss_Header extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int valueX = req.getIntHeader("Value_x");
        int valueY = req.getIntHeader("Value_y");
        int valueZ = valueX + valueY;
        resp.setIntHeader("Value_z", valueZ);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
