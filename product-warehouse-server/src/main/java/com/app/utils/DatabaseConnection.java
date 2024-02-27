package com.app.utils;

import com.app.Configuration;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hoang hung
 */
public class DatabaseConnection {

    private static Connection conn;

    private static Connection generateConnection() {
        try {
            Class<?> clazz = Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            DriverManager.registerDriver((Driver) clazz.getDeclaredConstructor().newInstance());
            String url = Configuration.CONNECTION_URL;
            return DriverManager.getConnection(url);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | SQLException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void setDaoConnection() throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
        conn = generateConnection();

        Field[] fields = Configuration.class.getDeclaredFields();
        for (Field field : fields) {
            if (field.getType().getSuperclass().equals(SQLDatabase.class)) {
                Class<?> clazz = field.getType();
                Constructor<?> con = clazz.getConstructor(Connection.class);

                Object obj = con.newInstance(conn);
                field.set(null, obj);

                Field tableName = clazz.getDeclaredField("table");
                tableName.setAccessible(true);

                String table = clazz.getName();
                table = table.substring(table.lastIndexOf('.') + 1);
                table = table.replaceAll("DAO", "");
                table = table.substring(0, 1).toLowerCase() + table.substring(1);
                tableName.set(obj, table);
                tableName.setAccessible(false);
            }
        }
    }

    public static void closeConnection() throws SQLException {
        conn.close();
    }
}
