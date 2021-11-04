package servlets;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.Enumeration;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class Sss extends HttpServlet implements Servlet {
    String fileName = "D:\\education\\Fourth_Course\\Java\\java_2\\log\\log.txt";
    java.util.logging.Logger log = java.util.logging.Logger.getLogger(Sss.class.getName());
    FileHandler fh = new FileHandler(fileName);
    String getMessage = "";
    String postMessage = "";

    public Sss() throws IOException {
        super();
        log.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
        log.info("Sss:constructor()");
        getMessage += "Sss:constructor()<br/>";
    }

    @Override
    public void init() throws ServletException {
        super.init();
        log.info("Sss:init()");
        getMessage += "Sss:init()<br/>";
    }

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html;");
//        InetAddress IP= InetAddress.getLocalHost();
//        log.info("Sss:service()");
//        getMessage += "Sss:service()<br/>";
//        getMessage += "Method " + req.getMethod() + "<br/>";
//        getMessage += "Server Name " + req.getServerName() + "<br/>";
//        getMessage += "IP Address " + IP.getHostAddress() + "<br/>";
//        getMessage += "Remote Host " + req.getRemoteHost() + "<br/>";
//        PrintWriter pw = resp.getWriter();
//        pw.print(getMessage);
//        pw.close();
//    }

    //10 doGet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;");
        //get-method, showing params
        String s;
        for (Enumeration<String> pp = req.getParameterNames(); pp.hasMoreElements();){
            s = pp.nextElement();
            getMessage += s + " : " + req.getParameter(s) + "<br/>";
        } 
        //get query string
        getMessage += "Query String: " + req.getQueryString() + "<br/>";
        InetAddress IP = InetAddress.getLocalHost();
        log.info("Sss:service()");
        getMessage += "Sss:doGet() <br/>";
        getMessage += "Method " + req.getMethod() + "<br/>";
        getMessage += "Server Name " + req.getServerName() + "<br/>";
        getMessage += "IP Address " + IP.getHostAddress() + "<br/>";
        getMessage += "Remote Host " + req.getRemoteHost() + "<br/>";
        getMessage += "<br/>";
        PrintWriter pw = resp.getWriter();
        pw.print(getMessage);
        pw.close();
    }
    //12 doPost
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;");
        //post-method, showing params;
        String s;
        for (Enumeration<String> pp = req.getParameterNames(); pp.hasMoreElements();){
            s = pp.nextElement();
            postMessage += s + " : " + req.getParameter(s) + "<br/>";
        }
        InetAddress IP= InetAddress.getLocalHost();
        log.info("Sss:service()");
        postMessage += "Sss:doPost() <br/>";
        postMessage += "Method " + req.getMethod() + "<br/>";
        postMessage += "Server Name " + req.getServerName() + "<br/>";
        postMessage += "IP Address " + IP.getHostAddress() + "<br/>";
        postMessage += "Remote Host " + req.getRemoteHost() + "<br/>";
        postMessage += "<br/>";
        PrintWriter pw = resp.getWriter();
        pw.print(postMessage);
        pw.close();
    }

    @Override
    public void destroy() {
        super.destroy();
        log.info("Sss:destroy()");
    }
}
