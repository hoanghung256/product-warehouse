package com.app.controllers;

import com.app.Configuration;
import com.app.models.Product;
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
@WebServlet(name = "ProductController", urlPatterns = {"/api/products"})
public class ProductController extends  HttpServlet {
    public static final ProductDAO dbContext = Configuration.products;

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String deletId = req.getParameter("id");
        if (dbContext.delete(deletId)) {
            out.print("delete success");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            int price = Integer.parseInt(req.getParameter("price"));
            
            dbContext.add(name, quantity, price);
        } catch (NumberFormatException e) {
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
        Product p = new Product();
        try {
            p.setId(Integer.parseInt(req.getParameter("id")));

            String[] parameters = {"name", "quantity", "price", "image"};
            for (String parameter : parameters) {
                String value = req.getParameter(parameter);
                if (value != null) {
                    switch (parameter) {
                        case "name":
                            p.setName(value);
                            break;
                        case "quantity":
                            p.setQuantity(Integer.parseInt(value));
                            break;
                        case "price":
                            p.setPrice(Integer.parseInt(value));
                            break;
                    }
                }
            }

            dbContext.update(p);
        } catch (NumberFormatException e) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
