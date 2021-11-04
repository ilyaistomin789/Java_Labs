package by.belstu.istomin.servlets;

import by.belstu.istomin.CBean;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

public class Ccc extends HttpServlet {
    CBean cBeanInst = new CBean();
    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext sc = getServletContext();
        sc.setAttribute("atrCBean", cBeanInst);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cBean = req.getParameter("CBean");
        String value1 = req.getParameter("Value1");
        String value2 = req.getParameter("Value2");
        String value3 = req.getParameter("Value3");
        if (cBean.equals("new")){
            cBeanInst = new CBean();
            getServletContext().setAttribute("atrCBean", cBeanInst);
        }
        if (value1 != null){
            cBeanInst.setValue1(value1);
        }
        if (value2 != null){
            cBeanInst.setValue2(value2);
        }
        if (value3 != null){
            cBeanInst.setValue3(value3);
        }

    }


}
