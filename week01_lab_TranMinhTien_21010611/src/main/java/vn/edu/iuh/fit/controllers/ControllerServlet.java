package vn.edu.iuh.fit.controllers;


import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.services.AccountServices;
import vn.edu.iuh.fit.services.RoleServices;
import vn.edu.iuh.fit.entities.Role;

import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.System.out;

@WebServlet(name = "ControllerServlet", value = "/login")
public class ControllerServlet extends HttpServlet {
    private AccountServices accountServices;

    private RoleServices roleServices;

    @Override
    public void init() throws ServletException {
        super.init();
        this.accountServices = new AccountServices();
        this.roleServices = new RoleServices();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        if (action.equalsIgnoreCase("login")) {
            // kiểm tra tài khoản và mật khẩu
            String account_id = req.getParameter("accountid");
            String password = req.getParameter("password");

            Role role = roleServices.getRoleByIdAccount(account_id);

            if (accountServices.checkAccount(account_id, password) ) {
                if(role.getRole_id().equals("admin")) {
                    resp.sendRedirect("dashboard.jsp");
                } else {
                    // trả ve thong tin 1 tai khoan
                    Account account = accountServices.findOneAccountById(account_id);
//                    String html = "<html><head><title>Account Information</title></head><body >" +
//                            "<a href='login.jsp'>Log out</a >" +
//                            "<h1>Account Information</h1 >" +
//                            "<p>Account ID: " + account.getAccount_id() + "</p >" +
//                            "<p>Full Name: " + account.getFull_name() + "</p >" +
//                            "<p>Email: " + account.getEmail() + "</p >" +
//                            "<p>Phone: " + account.getPhone() + "</p >" +
//                            "<p>Status: " + account.getStatus() + "</p >" +
//                            "</body></html >";
//                    out.println(html);

                    String html = "<html>" +
                            "<head>" +
                            "<title>Account Information</title>" +
                            "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC' crossorigin='anonymous'>" +
                            "</head>" +
                            "<body class='bg-light'>" +
                            "<nav class='navbar navbar-expand-lg navbar-light bg-white shadow-sm'>" +
                            "<div class='container'>" +
                            "<a class='navbar-brand' href='#'>Account Management</a>" +
                            "<button class='btn btn-outline-danger' onclick=\"window.location.href='login.jsp'\">Log out</button>" +
                            "</div>" +
                            "</nav>" +
                            "<div class='container mt-5'>" +
                            "<h2 class='mb-4'>Account Information</h2>" +
                            "<table class='table table-bordered'>" +
                            "<tbody>" +
                            "<tr>" +
                            "<th>Account ID</th>" +
                            "<td>" + account.getAccount_id() + "</td>" +
                            "</tr>" +
                            "<tr>" +
                            "<th>Full Name</th>" +
                            "<td>" + account.getFull_name() + "</td>" +
                            "</tr>" +
                            "<tr>" +
                            "<th>Email</th>" +
                            "<td>" + account.getEmail() + "</td>" +
                            "</tr>" +
                            "<tr>" +
                            "<th>Phone</th>" +
                            "<td>" + account.getPhone() + "</td>" +
                            "</tr>" +
                            "<tr>" +
                            "<th>Status</th>" +
                            "<td>" + account.getStatus() + "</td>" +
                            "</tr>" +
                            "</tbody>" +
                            "</table>" +
                            "<button class='btn btn-primary mt-4' onclick=\"window.location.href='editAccount.jsp'\">Edit Account</button>" +
                            "</div>" +
                            "<script src='https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js' integrity='sha384-IQsoLXlAH+e+4YyT7RX6QjoG0FjS05A6F/It2lO3y9S/QD/yRqgXQ56P3to7bo1Dh' crossorigin='anonymous'></script>" +
                            "<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js' integrity='sha384-cVKIphndgHknpmLMsD6KAO8XKzWm1R9j9QT4K00RPI6xljV+n/tzj5M0iDhbXhQp8' crossorigin='anonymous'></script>" +
                            "</body>" +
                            "</html>";

                    out.println(html);

                }
            } else {
                req.setAttribute("error", "Login failed!!");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        }else if (action.equalsIgnoreCase("add")) {
            String accountID = req.getParameter("account_id");
            String fullName = req.getParameter("full_name");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            String password = req.getParameter("password");
            String status = req.getParameter("status");
            Account account = new Account(accountID, fullName, password, email, phone, Integer.parseInt(status));

            if (accountServices.insertAccount(account)) {
                resp.sendRedirect("dashboard.jsp");
            } else {
                req.setAttribute("error", "Thêm thành công!!");
                req.getRequestDispatcher("formthem.jsp").forward(req, resp);
            }
        } else if(action.equalsIgnoreCase("edit")) {
            String accountID = req.getParameter("account_id");
            String fullName = req.getParameter("full_name");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            String password = req.getParameter("password");
            String status = req.getParameter("status");
            Account account = new Account(accountID, fullName, password, email, phone, Integer.parseInt(status));

            if (accountServices.updateAccount(account)) {
                resp.sendRedirect("dashboard.jsp");
            } else {
                req.setAttribute("error", "cap nhat khong thanh cong!!");
                req.getRequestDispatcher("formthem.jsp").forward(req, resp);
            }
        }else if (action.equalsIgnoreCase("delete")) {
            String account_id = req.getParameter("id");
            Account account = accountServices.getInfor(account_id);
            accountServices.deleteAccount(account);
            resp.sendRedirect("dashboard.jsp");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        HttpSession session = req.getSession(true);
        if (action.equalsIgnoreCase("add")) {
            session.setAttribute("account", new Account());
            req.getRequestDispatcher("formthem.jsp").forward(req, resp);

        }else if (action.equalsIgnoreCase("edit")) {
            String account_id = req.getParameter("id");

            Account account = accountServices.getInfor(account_id);
            session.setAttribute("account", account);
            req.getRequestDispatcher("formthem.jsp").forward(req, resp);
        }else if (action.equalsIgnoreCase("delete")) {
            String account_id = req.getParameter("id");
            Account account = accountServices.getInfor(account_id);
            accountServices.deleteAccount(account);
            resp.sendRedirect("dashboard.jsp");
        }
    }
}
