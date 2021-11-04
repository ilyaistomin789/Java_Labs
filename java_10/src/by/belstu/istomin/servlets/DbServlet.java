package by.belstu.istomin.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class DbServlet extends HttpServlet {
    private final String connectionUrl =
            "jdbc:sqlserver://localhost:1433;"
                    + "database=nodejs_lab_4;"
                    + "user=stmnl;"
                    + "password=71182528;"
                    + "encrypt=false;"
                    + "trustServerCertificate=false;"
                    + "loginTimeout=30;";
    private final String SELECT_SUBJECTS = "select * from SUBJECT";
    private final String SELECT_FACULTIES = "select * from FACULTY";
    private Connection connection;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String subject = req.getParameter("subject");
        resp.setHeader("Content-Type", "text/plain;charset=UTF-8");

        try (Connection connection = DriverManager.getConnection(connectionUrl)) {
            PrintWriter pw = resp.getWriter();

            if (subject == null) {
                try (PreparedStatement ps = connection.prepareStatement(SELECT_SUBJECTS); ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        pw.println(rs.getString("SUBJECT") + " " + rs.getString("SUBJECT_NAME") + " " + rs.getString("PULPIT"));
                    }
                    pw.flush();
                }
            } else {
                try (PreparedStatement ps = connection.prepareStatement(SELECT_SUBJECTS + " where SUBJECT = ?")) {
                    ps.setNString(1, subject);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        pw.println(rs.getString("SUBJECT") + " " + rs.getString("SUBJECT_NAME") + " " + rs.getString("PULPIT"));
                    }
                    pw.flush();
                }
            }
        } catch (SQLException throwables) {
            resp.getWriter().println(throwables.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String faculty = req.getParameter("faculty");
        String faculty_name = req.getParameter("faculty_name");
        resp.setHeader("Content-Type", "text/plain;charset=UTF-8");

        try (Connection connection = DriverManager.getConnection(connectionUrl)) {
            PrintWriter pw = resp.getWriter();
            try (CallableStatement callableStatement = connection.prepareCall("{call dbo.CREATE_FACULTY(?, ?)}")) {
                if (faculty == null || faculty_name == null) {
                    throw new Exception("Please, add params");
                }
                callableStatement.setNString(1, faculty);
                callableStatement.setString(2, faculty_name);
                callableStatement.execute();
                try (PreparedStatement ps = connection.prepareStatement(SELECT_FACULTIES); ResultSet rs = ps.executeQuery()) {
                    pw.println(faculty);
                    pw.println(faculty_name);
                    while (rs.next()) {
                        pw.println(rs.getString("FACULTY") + " " + rs.getString("FACULTY_NAME"));
                    }
                    pw.flush();
                }

            } catch (Exception e) {
                resp.getWriter().println(e.getMessage());
            }
        } catch (SQLException throwables) {
            resp.getWriter().println(throwables.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
