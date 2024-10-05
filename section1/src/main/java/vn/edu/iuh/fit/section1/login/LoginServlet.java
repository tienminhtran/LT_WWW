package vn.edu.iuh.fit.section1.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.section1.beans.LoginBean;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("us");
        String password = req.getParameter("ps");

        LoginBean loginBean = new LoginBean(username, password);
        if(loginBean.validate()){
            resp.getWriter().println("<h1>"+"Login success"+"</h1>");
        }else{
            resp.getWriter().println("Login failed");
        }





    }
}
