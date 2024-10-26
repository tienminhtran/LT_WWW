/*
 * @ {#} CuaHangXeMayabcServlet.java   1.0     24/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.entities.HangXe;
import vn.edu.iuh.fit.entities.Xe;
import vn.edu.iuh.fit.services.HangXeService;
import vn.edu.iuh.fit.services.XeService;
import vn.edu.iuh.fit.services.impl.HangXeServiceImpl;
import vn.edu.iuh.fit.services.impl.XeServiceImpl;

import java.io.IOException;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   24/10/2024
 * @version:    1.0
 */
@WebServlet(name = "CuaHangXeMayabcServlet", urlPatterns = "/controller")
public class CuaHangXeMayabcServlet extends HttpServlet {
    private XeService xeService;
    private HangXeService hangXeService;
    public L{
        xeService = new XeServiceImpl();
        hangXeService = new HangXeServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null|| action.equals("getDsXe")) {
            req.setAttribute("dsXe", xeService.getDsXe());
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else if (action.equals("getXeByName")){
            String tenXe = req.getParameter("searchValue");
            req.setAttribute("dsXe", xeService.findByTenXe(tenXe));
            req.getRequestDispatcher("danhSachXe.jsp").forward(req, resp);
        } else if (action.equals("getDsHangXe")){
            req.setAttribute("dsHangXe", hangXeService.getDsHangXe());
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else if (action.equals("addXe")) {
            req.setAttribute("dsHangXe", hangXeService.getDsHangXe());
            req.getRequestDispatcher("addXe.jsp").forward(req, resp);
        } else if (action.equals("suaXe")) {
            int id = Integer.parseInt(req.getParameter("id"));
            Xe xe = xeService.findByID(id);
            req.setAttribute("xe", xe);
            req.setAttribute("dsHangXe", hangXeService.getDsHangXe());
            req.getRequestDispatcher("addXe.jsp").forward(req, resp);
        } else if (action.equals("xoaXe")) {
            int id = Integer.parseInt(req.getParameter("id"));
            Xe xe = xeService.findByID(id);
            xeService.deleteXe(xe);
            resp.sendRedirect("controller?action=getDsXe");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String tenXe = req.getParameter("tenxe");
        String gia = req.getParameter("giaxe");
        String namSX = req.getParameter("namsanxuat");
        int mahangXe = Integer.parseInt(req.getParameter("mahangxe"));
        if (action.equals("addXe")) {
            HangXe hangXe = hangXeService.findByID(mahangXe);
            Xe xe=new Xe();
            xe.setTenxe(tenXe);
            xe.setGiaxe(Double.parseDouble(gia));
            xe.setNamsanxuat(Integer.parseInt(namSX));
            xe.setMahangxe(hangXe);
            Xe x = xeService.addXe(xe);
            if (x!=null) {
                resp.sendRedirect("controller?action=getDsXe");
            } else {
                req.setAttribute("message", "Thêm xe không thành công");
                req.getRequestDispatcher("addXe.jsp").forward(req, resp);
            }
        }else if (action.equals("suaXe")) {
            String idStr = req.getParameter("id");
            if (idStr != null && !idStr.isEmpty()) {
                int id = Integer.parseInt(idStr);
                Xe xe = xeService.findByID(id);
                xe.setTenxe(tenXe);
                xe.setGiaxe(Double.parseDouble(gia));
                xe.setNamsanxuat(Integer.parseInt(namSX));
                xe.setMahangxe(hangXeService.findByID(mahangXe));
                Xe x = xeService.updateXe(xe);
                if (x != null) {
                    resp.sendRedirect("controller?action=getDsXe");
                } else {
                    req.setAttribute("message", "Sửa xe không thành công");
                    req.getRequestDispatcher("addXe.jsp").forward(req, resp);
                }
            } else {
                req.setAttribute("message", "ID không hợp lệ");
                req.getRequestDispatcher("addXe.jsp").forward(req, resp);
            }
        }
    }
}
