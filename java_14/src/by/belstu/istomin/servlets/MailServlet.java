package by.belstu.istomin.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

public class MailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String host = getServletContext().getInitParameter("hostImaps");
        int port = Integer.parseInt(getServletContext().getInitParameter("portImaps"));
        String user = getServletContext().getInitParameter("username") + "@yandex.ru";
        String password = getServletContext().getInitParameter("password");
        Properties properties = System.getProperties();
        Session session = Session.getDefaultInstance(properties);
        Store store = null;
        try {
            store = session.getStore("imaps");
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
        try {
            assert store != null;
            store.connect(host, port, user, password);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        Folder inbox = null;
        try {
            inbox = store.getFolder("Inbox");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            assert inbox != null;
            inbox.open(Folder.READ_ONLY);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        Message[] messages = new Message[0];
        try {
            messages = inbox.getMessages();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        if (messages.length == 0) System.out.println("No messages found.");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < messages.length; i++) {
            if (i > 10) {
                try {
                    inbox.close(true);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                try {
                    store.close();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                break;
            }
            try {
                builder.append("From : ").append(messages[i].getFrom()[0]).append("<br>");
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            try {
                builder.append("Subject : ").append(messages[i].getSubject()).append("<br>");
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            try {
                builder.append("Sent Date : ").append(messages[i].getSentDate()).append("<br>");
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            resp.setContentType("text/html");
        }
        resp.getWriter().write(builder.toString());


    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST");
        final String to = req.getParameter("mail");
        final String mes = req.getParameter("message");
        final String from = getServletContext().getInitParameter("from");
        final String username = getServletContext().getInitParameter("username");
        final String password = getServletContext().getInitParameter("password");
        final String host = getServletContext().getInitParameter("host");
        final String port = getServletContext().getInitParameter("port");
        try {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            message.setSubject("Subject");

            message.setText(mes);

            Transport.send(message);

            resp.getWriter().write("Sent message successfully");
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
}
