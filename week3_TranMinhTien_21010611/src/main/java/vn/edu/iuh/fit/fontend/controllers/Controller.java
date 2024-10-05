package vn.edu.iuh.fit.fontend.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.backend.repositories.entities.Product;
import vn.edu.iuh.fit.fontend.models.ProductModel;

import java.io.IOException;

@WebServlet(name = "Controller",value ="/controller" )
public class Controller extends HttpServlet {

    @Inject
    ProductModel productModel;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action.equals("add")){
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            String img_path = req.getParameter("img");

            Product product = new Product(name, description, img_path);
            productModel.addProduct(product);
            resp.sendRedirect("index.jsp");
        }
    }
}
