/**
 * @ (#) ServletController.java      9/19/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week2_phantiensinh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.week2_phantiensinh.enums.EmployeeStatus;
import vn.edu.iuh.fit.week2_phantiensinh.models.Employee;
import vn.edu.iuh.fit.week2_phantiensinh.services.EmployeeService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 9/19/2024
 */
@WebServlet(name = "ServletController", value = "/servlet-controller")
public class ServletController extends HttpServlet {
    private EmployeeService employeeService;

    public ServletController() {
        employeeService = new EmployeeService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        HttpSession session = req.getSession(true);
        if (action.equals("add")) {
            session.setAttribute("employee", new Employee());
            req.getRequestDispatcher("formEmployee.jsp").forward(req, resp);
        } else if (action.equals("edit")) {
            long id = Long.parseLong(req.getParameter("id"));
            Employee e = employeeService.findById(id);
            session.setAttribute("employee", e);
            req.getRequestDispatcher("formEmployee.jsp").forward(req, resp);
        } else if (action.equals("delete")) {
            long id = Long.parseLong(req.getParameter("id"));
            if(employeeService.deleteEmploy(id)) {
                resp.sendRedirect("Employee.jsp");
            } else{
                req.setAttribute("error", "Delete fail");   // set attribute error
                req.getRequestDispatcher("Employee.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        if (action.equals("add")) {
            String name = req.getParameter("name_emp");
            LocalDateTime dob = LocalDateTime.parse(req.getParameter("dob"),formatter);
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            String address = req.getParameter("address");
            int status = Integer.parseInt(req.getParameter("status"));

            EmployeeStatus employeeStatus = EmployeeStatus.convertEnum(status);

            Employee e = new Employee(dob, email, address, employeeStatus,phone, name);
            if(employeeService.insertEmploy(e)) {
                resp.sendRedirect("Employee.jsp");
            } else{
                req.setAttribute("error", "Insert fail");   // set attribute error
                req.getRequestDispatcher("formEmployee.jsp").forward(req, resp);
            }

        } else if (action.equals("edit")) {
            long id = Long.parseLong(req.getParameter("emp_id"));
            String name = req.getParameter("name_emp");
            LocalDateTime dob = LocalDateTime.parse(req.getParameter("dob"),formatter);
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            String address = req.getParameter("address");
            int status = Integer.parseInt(req.getParameter("status"));

            EmployeeStatus employeeStatus = EmployeeStatus.convertEnum(status);

            Employee e = new Employee(id,dob, email, address, employeeStatus, phone, name);
            if(employeeService.updateEmploy(e)) {
                resp.sendRedirect("Employee.jsp");
            } else{
                req.setAttribute("error", "Update fail");   // set attribute error
                req.getRequestDispatcher("formEmployee.jsp").forward(req, resp);
            }
        }
    }
}
