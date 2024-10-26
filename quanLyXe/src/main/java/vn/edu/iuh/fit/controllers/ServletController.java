/**
 * @ (#) ServletController.java      10/24/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.dtos.XeDTO;
import vn.edu.iuh.fit.services.XeService;
import vn.edu.iuh.fit.services.impl.XeServices;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "ServletController", value = "/controller")
public class ServletController extends HttpServlet {
    private final XeService xeService;

    public ServletController() {
        this.xeService = new XeServices();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        HttpSession session=req.getSession(true);
        if(action.equalsIgnoreCase("dsXe")) {
            List<XeDTO> xeDTOs = xeService.getXeDTOs();
            session.setAttribute("xeDTOs", xeDTOs);
            req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
        } else if(action.equalsIgnoreCase("themXe")) {
            session.setAttribute("hangXeList", xeService.getAllHangXe());
            session.setAttribute("xeDTO", new XeDTO());
            req.getRequestDispatcher("form.jsp").forward(req, resp);
        } else if(action.equalsIgnoreCase("suaXe")) {
            String maXe = req.getParameter("maXe");
            XeDTO xeDTO = xeService.getOne(Long.parseLong(maXe));

            session.setAttribute("hangXeList", xeService.getAllHangXe());
            session.setAttribute("xeDTO", xeDTO);
            req.getRequestDispatcher("form.jsp").forward(req, resp);
        } else if(action.equalsIgnoreCase("xoaXe")) {
            long id = Long.parseLong(req.getParameter("maXe"));
            boolean result = xeService.delete(id);
            if(result)
                resp.sendRedirect("controller?action=dsXe");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        HttpSession session=req.getSession(true);
        long id = Long.parseLong(req.getParameter("maXe"));
        String tenXe = req.getParameter("tenXe");
        String giaXe = req.getParameter("giaXe");
        String namSX = req.getParameter("namSX");
        String hangXe = req.getParameter("hangXe");
        if(action.equalsIgnoreCase("St")) {
            String tenXeTimKiem = req.getParameter("tenTimKiem");
            List<XeDTO> xeDTOs = xeService.getXeDTOByTen(tenXeTimKiem);
            session.setAttribute("xeDTOs", xeDTOs);
            req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
        } else if(action.equalsIgnoreCase("themXe"))
        {
            XeDTO xeDTO = new XeDTO(tenXe, Double.parseDouble(giaXe), Integer.parseInt(namSX), hangXe);
            boolean result= xeService.save(xeDTO);

            if(result)
               resp.sendRedirect("controller?action=dsXe");
        } else if(action.equalsIgnoreCase("suaXe")) {
            XeDTO xeDTO = new XeDTO(id, tenXe, Double.parseDouble(giaXe), Integer.parseInt(namSX), hangXe);
            boolean result= xeService.update(xeDTO);

            if(result)
                resp.sendRedirect("controller?action=dsXe");
        }
    }
}
