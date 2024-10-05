package vn.edu.iuh.fit.week1.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week1.beans.LoginBean;
import vn.edu.iuh.fit.week1.dao.loginDao;
import vn.edu.iuh.fit.week1.dao.impl.loginImpl;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        loginDao dao = new loginImpl();

//        if (dao.checkLogin(username, password)){
//            resp.getWriter().println("<h1>Login success</h1>");
//        } else {
//            resp.getWriter().println("<h1>Login failed</h1>");
//
//        }

//        LoginBean dao = new LoginBean();
        if (dao.checkLogin(username, password)){
            resp.getWriter().println("<h1>Login success</h1>");
            resp.getWriter().println("<a href='index.html'>Login</a>");

        } else {
            resp.getWriter().println("<h1>Login failed</h1>");
            resp.getWriter().println("<a href='index.html'>Login</a>");

        }
    }

}