/**
 * @ (#) SinhVienServlet.java      9/14/2025
 * <p>
 * Copyright (c) 2025 IUH. All rights reserved
 */

package vn.edu.iuh.fit.demogk_www.servlet;

/*
 * @description:
 * @author: Tien Minh Tran
 * @date: 9/14/2025
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.demogk_www.dao.SinhVienDao;
import vn.edu.iuh.fit.demogk_www.model.Lop;
import vn.edu.iuh.fit.demogk_www.model.SinhVien;

import java.io.IOException;
import java.util.List;

@WebServlet("/sinhvien")
public class SinhVienServlet extends HttpServlet {

    private final SinhVienDao dao = new SinhVienDao();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {


        String action = req.getParameter("action");
        if("edit".equalsIgnoreCase(action)){
            String mssv = req.getParameter("mssv");
            SinhVien sv = dao.findByMssv(mssv);
            req.setAttribute("sv", sv);
            req.getRequestDispatcher("sinhvien-edit.jsp").forward(req, resp);
        }else{
            List<SinhVien> ds;
            ds = dao.findAll();

            req.setAttribute("sinhviens", ds);
            req.getRequestDispatcher("sinhvien-list.jsp").forward(req, resp);
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if("add".equalsIgnoreCase(action)){
            handlAdd(req, resp);
        } else if("delete".equalsIgnoreCase(action)){
            handlDelete(req, resp);
        } else if ("update".equalsIgnoreCase(action)) {
            handlEdit(req, resp);
        }
        else{
            resp.sendRedirect(req.getContextPath()+"/sinhvien");
        }
    }




    private void handlAdd(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String mssv = req.getParameter("mssv");
        String hoten = req.getParameter("hoten");
        String ngaysinh = req.getParameter("ngaysinh");
        double diem = Double.parseDouble(req.getParameter("diem"));
        String malop = req.getParameter("malop");
        dao.insert(new SinhVien(mssv, hoten, ngaysinh, diem, new Lop(malop, null)));
        res.sendRedirect(req.getContextPath()+"/sinhvien");


    }
    private void handlDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String mssvDel = req.getParameter("mssv");
        dao.delete(mssvDel);
        res.sendRedirect(req.getContextPath()+"/sinhvien");



    }
    private void handlEdit(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String mssv = req.getParameter("mssv");
        String hoten = req.getParameter("hoten");
        String ngaysinh = req.getParameter("ngaysinh");
        double diem = Double.parseDouble(req.getParameter("diem"));
        String malop = req.getParameter("malop");
        dao.update(new SinhVien(mssv, hoten, ngaysinh, diem, new Lop(malop, null)));
        res.sendRedirect(req.getContextPath()+"/sinhvien");


    }

}