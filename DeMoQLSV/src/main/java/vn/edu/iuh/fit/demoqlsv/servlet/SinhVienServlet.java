/**
 * @ (#) SinhVienServlet.java      9/13/2025
 * <p>
 * Copyright (c) 2025 IUH. All rights reserved
 */

package vn.edu.iuh.fit.demoqlsv.servlet;

/*
 * @description:
 * @author: Tien Minh Tran
 * @date: 9/13/2025
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.demoqlsv.dao.LopDao;
import vn.edu.iuh.fit.demoqlsv.dao.SinhVienDao;
import vn.edu.iuh.fit.demoqlsv.model.Lop;
import vn.edu.iuh.fit.demoqlsv.model.SinhVien;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "SinhVienServlet", value = "/sinhvien")
public class SinhVienServlet extends HttpServlet {

    private final SinhVienDao dao = new SinhVienDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("edit".equalsIgnoreCase(action)) {
            String mssv = req.getParameter("mssv");
            SinhVien sv = dao.findById(mssv);
            req.setAttribute("sv", sv);
            req.getRequestDispatcher("sinhvien-edit.jsp").forward(req, resp);

        } else if ("find".equalsIgnoreCase(action)) {
            String mssv = req.getParameter("mssv");
            String name = req.getParameter("name");

            if (mssv != null && !mssv.isEmpty()) {
                SinhVien sv = dao.findById(mssv);
                if (sv != null) {
                    req.setAttribute("sv", sv);
                } else {
                    req.setAttribute("error", "Không tìm thấy MSSV: " + mssv);
                }
            } else if (name != null && !name.isEmpty()) {
                List<SinhVien> ds = dao.findByName(name);
                if (!ds.isEmpty()) {
                    req.setAttribute("sinhviens", ds);
                } else {
                    req.setAttribute("error", "Không tìm thấy tên: " + name);
                }
            }
            req.getRequestDispatcher("sinhvien-list.jsp").forward(req, resp);
        } else if ("findByDiem".equalsIgnoreCase(action)) {
            String minStr = req.getParameter("min");
            String maxStr = req.getParameter("max");

            if (minStr != null && maxStr != null) {
                try {
                    double min = Double.parseDouble(minStr);
                    double max = Double.parseDouble(maxStr);
                    List<SinhVien> ds = dao.findByDiemRange(min, max);

                    if (!ds.isEmpty()) {
                        req.setAttribute("sinhviens", ds);
                    } else {
                        req.setAttribute("error", "Không có sinh viên nào trong khoảng điểm [" + min + ", " + max + "]");
                    }
                } catch (NumberFormatException e) {
                    req.setAttribute("error", "Giá trị điểm không hợp lệ!");
                }
            }

            req.getRequestDispatcher("sinhvien-list.jsp").forward(req, resp);
        }
        else {
            List<SinhVien> ds = dao.findAll();
            req.setAttribute("sinhviens", ds);



            req.getRequestDispatcher("sinhvien-list.jsp").forward(req, resp);
        }

    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        String action = req.getParameter("action");
        if ("add".equalsIgnoreCase(action)) {
            handleAdd(req, resp);
        } else if ("delete".equalsIgnoreCase(action)) {
            handlDelete(req, resp);
        } else if ("update".equalsIgnoreCase(action)) {
            handleUpdate(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/sinhvien");
        }
    }


    // xu ly them
    private void handleAdd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String mssv = req.getParameter("mssv");
        String hoten = req.getParameter("hoten");
        String ngaysinh = req.getParameter("ngaysinh");
        double diem = Double.parseDouble(req.getParameter("diem"));
        String malop = req.getParameter("malop");
        dao.insert(new SinhVien( mssv, hoten, ngaysinh, diem, new Lop(malop, null)));
        resp.sendRedirect(req.getContextPath() + "/sinhvien");
    }

    private void handlDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String mssvDel = req.getParameter("mssv");
        dao.delete(mssvDel);
        resp.sendRedirect(req.getContextPath() + "/sinhvien");
    }

    // Cập nhật sv
    private void handleUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String mssv = req.getParameter("mssv");
        String hoten = req.getParameter("hoten");
        String ngaysinh = req.getParameter("ngaysinh");
        double diem = Double.parseDouble(req.getParameter("diem"));
        String malop = req.getParameter("malop");

        dao.update(new SinhVien(mssv, hoten, ngaysinh, diem, new Lop(malop, null)));
        resp.sendRedirect(req.getContextPath() + "/sinhvien");
    }

}