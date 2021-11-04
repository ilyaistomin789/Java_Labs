package by.belstu.istomin.servlets;

import by.belstu.istomin.helpers.NumberGenerator;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Sss_JSON extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int nValue = req.getIntHeader("XRand-N");
        int[] arr = NumberGenerator.getRandomArray(nValue);
        PrintWriter pw = resp.getWriter();
        String s = "{ \"rand\" : [";
        for (int i = 0; i < arr.length; i++) {
            s += " { \"num\" : " + arr[i] + " }";
            if (i != (arr.length - 1)) {
                s += ",";
            } else {
                s += "";
            }
        }
        s += "] }";
        System.out.println(s);
        resp.setHeader("Content-Type", "application/json");
        pw.write(s);
        pw.flush();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
