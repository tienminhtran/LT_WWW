package vn.edu.iuh.fit.registration.registration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "registrationServler", value = "/registration")
public class registrationServler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/index.html").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String facebook = req.getParameter("facebook");
        String shortBio = req.getParameter("shortBio");


        resp.getWriter().println("<h1>Registration success</h1>");

        resp.getWriter().println("<h1>First Name: " + firstName + "</h1>");
        resp.getWriter().println("<h1>Last Name: " + lastName + "</h1>");
        resp.getWriter().println("<h1>Email: " + email + "</h1>");
        resp.getWriter().println("<h1>Password: " + password + "</h1>");
        resp.getWriter().println("<h1>Facebook: " + facebook + "</h1>");
        resp.getWriter().println("<h1>Short Bio: " + shortBio + "</h1>");
    }
}
