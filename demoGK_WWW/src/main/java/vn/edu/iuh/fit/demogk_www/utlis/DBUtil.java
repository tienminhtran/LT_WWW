/**
 * @ (#) DBUtil.java      9/14/2025
 * <p>
 * Copyright (c) 2025 IUH. All rights reserved
 */

package vn.edu.iuh.fit.demogk_www.utlis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * @description:
 * @author: Tien Minh Tran
 * @date: 9/14/2025
 */
public class DBUtil {

    private static final String URL = "jdbc:mariadb://localhost:3306/demoqlsv?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    static {
        try{
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}