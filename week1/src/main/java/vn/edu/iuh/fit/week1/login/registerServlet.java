package vn.edu.iuh.fit.week1.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week1.dao.impl.loginImpl;
import vn.edu.iuh.fit.week1.dao.loginDao;
import vn.edu.iuh.fit.week1.entity.entityLogin;

import java.io.IOException;

@WebServlet(name = "registerServlet", value = "/register")
public class registerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        {

            String username = req.getParameter("username");
            String password = req.getParameter("password");
            loginDao dao = new loginImpl();
            entityLogin login = new entityLogin(username, password);
            if (dao.insertLogin(login)) {
                resp.getWriter().println("<h1>Register success</h1>");
                resp.getWriter().println("<a href='index.html'>Login</a>");

            } else {
                resp.getWriter().println("<h1>Register failed</h1>");
                resp.getWriter().println("<a href='index.html'>Login</a>");

            }

        }
    }
}