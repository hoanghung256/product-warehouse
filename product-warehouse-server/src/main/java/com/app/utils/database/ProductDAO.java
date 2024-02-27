package com.app.utils.database;

import com.app.models.Product;
import com.app.utils.SQLDatabase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hoang hung
 */
public class ProductDAO extends SQLDatabase {
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
                        rs.getNString("image")
                    )
                );
            }
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        } 
        
        return res;
    }
    
    public void add(String name, int quantity, int price) {
        executePreparedStatement("INSERT INTO " + table + " (name, quantity, price) VALUES (?, ?, ?)", 
                name, quantity, price);
    }
    
    public boolean delete(String id) {
        executePreparedStatement("DELETE FROM " + table + " WHERE id=?", id);
        return true;
    }
    
    public void update(Product p) {
        executePreparedStatement("UPDATE " + table + " SET "
                + "name = COALESCE(?, name), "
                + "quantity = COALESCE(?, quantity), "
                + "price = COALESCE(?, price) "
                + "WHERE id = ?",
                p.getName(), p.getQuantity(), p.getPrice(), p.getId());
    }
}
