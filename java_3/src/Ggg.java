

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class Ggg extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Ggg: doGet()");

        // Task1
//        var param = req.getParameterNames().nextElement();
//        resp.getWriter().write(param + ": " + req.getParameter(param));
        // end Task1

        // Task4
//         RequestDispatcher rd4 = req.getRequestDispatcher("/page.html");
//        rd4.forward(req, resp);
        // end Task4

        // Task5
//        resp.getWriter().write("TASK 5");
        // end Task5

        // Task6 при редиректе null
//         resp.getWriter().write(req.getQueryString());
        // end Task6

        // Task 7
        resp.getWriter().write("query: " + req.getQueryString());
        // end Task7
    }

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("Ggg " + req.getMethod());
//
//        // Task2
//        String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
//        resp.getWriter().write("from Ggg: " + body);
//        // end Task2
//    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Ggg: doPost()");
        String body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        response.getWriter().write(body);
    }
}
