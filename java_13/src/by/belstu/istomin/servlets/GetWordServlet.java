package by.belstu.istomin.servlets;

import by.belstu.istomin.logger.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class GetWordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fileName = req.getParameter("file");
        if (fileName != null) {
            Logger.info("file: " + fileName);
            File file = new File(req.getServletContext().getInitParameter("word-dir") + "//" + fileName);
            resp.setContentType("application/msword");
            resp.addHeader("Content-Disposition", "attachment; filename=" + file.getName());
            resp.setContentLength((int) file.length());

            BufferedInputStream buf = new BufferedInputStream(new FileInputStream(file));
            int readBytes;
            while ((readBytes = buf.read()) != -1) {
                resp.getOutputStream().write(readBytes);
            }
        }
    }
}