package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

public class JjjServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type", "text/html");
        Calendar rightNow = Calendar.getInstance();
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
        if (hour > 0 && hour <= 5) {
            req.getRequestDispatcher("night.jsp").forward(req, resp);
        } else if (hour > 5 && hour <= 12) {

            req.getRequestDispatcher("morning.jsp").forward(req, resp);
        } else if (hour > 12 && hour <= 17) {
            req.getRequestDispatcher("afternoon.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("evening.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type", "text/html");
        Calendar rightNow = Calendar.getInstance();
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
        if (hour > 0 && hour <= 5) {
            req.getRequestDispatcher("night.jsp").forward(req, resp);
        } else if (hour > 5 && hour <= 12) {

            req.getRequestDispatcher("morning.jsp").forward(req, resp);
        } else if (hour > 12 && hour <= 17) {
            req.getRequestDispatcher("afternoon.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("evening.jsp").forward(req, resp);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
