package com.app.controllers;

import com.app.Configuration;
import com.app.models.Product;
import com.app.models.StatusDto;
import com.app.utils.database.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hoang hung
 */
@WebServlet(name = "ProductController", urlPatterns = { "/api/products" })
public class ProductController extends HttpServlet {
    private static final ProductDAO dbContext = Configuration.products;

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        int deleteId = Integer.parseInt(req.getParameter("id"));
        if (dbContext.delete(deleteId) == 1) {
            out.print(new StatusDto(0, "Delete successfully!"));
        } else {
            out.print(new StatusDto(1, "Delete failed!"));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        try {
            String name = req.getParameter("name");
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            int price = Integer.parseInt(req.getParameter("price"));

            if (dbContext.add(name, quantity, price) == 1) {
                out.print(new StatusDto(0, "Add product successfully!"));
            } else {
                out.print(new StatusDto(1, "Add product failed!"));
            }
        } catch (NumberFormatException e) {
            out.print(new StatusDto(1, "Add product failed!"));
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        out.print(dbContext.getAll());
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            int price = Integer.parseInt(req.getParameter("price"));
            Product p = new Product(id, name, quantity, price);

            if (dbContext.update(p) == 1) {
                out.print(new StatusDto(0, "Update product successfully!"));
            } else {
                out.print(new StatusDto(1, "Update product failed!"));
            }
        } catch (NumberFormatException e) {
            out.print(new StatusDto(1, "Update product failed!"));
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
