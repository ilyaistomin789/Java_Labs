package by.belstu.istomin.servlets;

import by.belstu.istomin.helpers.NumberGenerator;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Sss_XML extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int nValue = req.getIntHeader("XRand-N");
        int[] arr = NumberGenerator.getRandomArray(nValue);
        PrintWriter pw = resp.getWriter();
        String s =
                "<?xml version=\"1.0\"  encoding = \"utf-8\" ?><rand>";
        for (int num : arr) {
            s += "<num>" + num + "</num>";
        }
        s += "</rand>";
        resp.setHeader("Content-Type", "application/xml");
        pw.write(s);
        pw.flush();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
