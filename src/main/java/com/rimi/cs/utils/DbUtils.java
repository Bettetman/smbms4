package com.rimi.cs.utils;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC 工具类
 *
 * @author szf
 */
public class DbUtils {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/smbms";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static Properties properties;

    static {
        properties = new Properties();
        try {
            InputStream stream = DbUtils.class.getResourceAsStream("config/jdbc.properties");
            properties.load(stream);
            stream.close();

            //加载驱动
//            Class.forName(DRIVER);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private DbUtils() {
    }

    /**
     * 获得连接
     *
     * @return
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 关闭连接
     *
     * @param connection
     */
    public static void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
