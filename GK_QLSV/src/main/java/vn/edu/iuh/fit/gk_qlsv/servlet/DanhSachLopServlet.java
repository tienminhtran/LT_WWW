/**
 * @ (#) DanhSachLopServlet.java      9/8/2025
 * <p>
 * Copyright (c) 2025 IUH. All rights reserved
 */

package vn.edu.iuh.fit.gk_qlsv.servlet;

/*
 * @description:
 * @author: Tien Minh Tran
 * @date: 9/8/2025
 */


import lombok.SneakyThrows;
import vn.edu.iuh.fit.gk_qlsv.dao.LopDAO;
import vn.edu.iuh.fit.gk_qlsv.model.Lop;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/danh-sach-lop")
public class DanhSachLopServlet extends HttpServlet {

    private LopDAO lopDAO = new LopDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Lop> lops = lopDAO.findAll();
        req.setAttribute("lops", lops);

        // Chuyển đến JSP hiển thị danh sách lớp
        req.getRequestDispatcher("danh-sach-lop.jsp").forward(req, resp);
    }
}
