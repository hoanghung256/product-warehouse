package com.app;

import com.app.utils.database.ProductDAO;
import com.google.gson.Gson;

/**
 *
 * @author hoang hung
 */
public class Configuration {
    public static final Gson gson = new Gson();

    private static final String HOST = "localhost";
    private static final String DATABASE = "ProductWarehouse";
    private static final String USER = "SA";
    private static final String PASS = "2562004";
    public static final String CONNECTION_URL = "jdbc:sqlserver://" + HOST + ";database=" + DATABASE + ";user=" + USER + ";password=" + PASS + ";encrypt=true;trustServerCertificate=true;loginTimeout=30;";

    public static ProductDAO products;
}
