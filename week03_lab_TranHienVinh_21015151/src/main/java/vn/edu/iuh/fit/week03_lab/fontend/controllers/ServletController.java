/*
 * @ {#} ServletController.java   1.0     02/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.week03_lab.fontend.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week03_lab.backend.dtos.ProductDTO;
import vn.edu.iuh.fit.week03_lab.backend.repositories.entities.Product;
import vn.edu.iuh.fit.week03_lab.fontend.models.ProductModel;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "ServletController", value = "/controller")
public class ServletController extends HttpServlet {
    @Inject
    private ProductModel productModel;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null && action.equals("search")) {
            int productId = Integer.parseInt(req.getParameter("id"));
            ProductDTO productDTO = productModel.getProductById(productId);
            if (productDTO==null){
                req.setAttribute("error","Không tìm thấy");
            }
            req.setAttribute("product", productDTO);
            req.getRequestDispatcher("listProduct.jsp").forward(req, resp);
            return;
        }
        List<ProductDTO> productDTOSs = productModel.getAllProducts();
        req.setAttribute("products", productDTOSs);
        req.getRequestDispatcher("listProduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("add")) {
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            String img_path = req.getParameter("img");

            Product product = new Product(name, description, img_path);
            productModel.createProduct(product);
            resp.sendRedirect("index.jsp");
        }
    }
}
