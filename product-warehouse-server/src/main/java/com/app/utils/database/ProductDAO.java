package com.app.utils.database;

import com.app.models.Product;
import com.app.utils.SQLDatabase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hoang hung
 */
public class ProductDAO extends SQLDatabase {
    /**
     * Automatic assign from method DatabaseConnection.setDaoConnection()
     * Separate from DAO's class name(example ProductDAO -> product)
     */
    private String table;

    public ProductDAO(Connection connection) {
        super(connection);
    }

    public List<Product> getAll() {
        List<Product> res = new ArrayList<>();

        try {
            ResultSet rs = executeQueryPreparedStatement("SELECT * FROM " + table);

            while (rs.next()) {
                res.add(new Product(
                        rs.getInt("id"),
                        rs.getNString("name"),
                        rs.getInt("quantity"),
                        rs.getInt("price"),
                        rs.getNString("image")));
            }
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return res;
    }
    
    /**
     * Find product by id
     * @param id id of product when to find
     * @return Product found
     */
    public Product get(int id) {
        Product res = new Product();

        try {
            ResultSet rs = executeQueryPreparedStatement("SELECT * FROM " + table + " WHERE id=?", id);

            while (rs.next()) {
                res.setId(rs.getInt("id"));
                res.setName(rs.getNString("name"));
                res.setQuantity(rs.getInt("quantity"));
                res.setPrice(rs.getInt("price"));
                res.setImagePath(rs.getNString("image"));
            }
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return res;
    }

    public int add(String name, int quantity, int price) {
        return executeUpdatePreparedStatement("INSERT INTO " + table + " (name, quantity, price) VALUES (?, ?, ?)",
                name, quantity, price);
    }

    public int delete(int id) {
        int result = executeUpdatePreparedStatement("DELETE FROM " + table + " WHERE id=?", id);
        System.out.println("rơ afect when delete" + result);
        return result;
    }

    public int update(Product p) {
        return executeUpdatePreparedStatement("UPDATE " + table + " SET "
                + "name = COALESCE(?, name), "
                + "quantity = COALESCE(?, quantity), "
                + "price = COALESCE(?, price) "
                + "WHERE id = ?",
                p.getName(), p.getQuantity(), p.getPrice(), p.getId());
    }
}
