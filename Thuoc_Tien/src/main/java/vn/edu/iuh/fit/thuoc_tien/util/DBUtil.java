package vn.edu.iuh.fit.thuoc_tien.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final boolean USE_SQLSERVER = true;

    // SQL Server Configuration
    private static final String SQLSERVER_URL = "jdbc:sqlserver://localhost:1433;databaseName=MSSV_HoTenSV;encrypt=false";
    private static final String SQLSERVER_USER = "sa";
    private static final String SQLSERVER_PASS = "1";

    // SQLite Configuration
    private static final String SQLITE_URL = "jdbc:sqlite:database/thuoc.db";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (USE_SQLSERVER) {
            return getSQLServerConnection();
        } else {
            return getSQLiteConnection();
        }
    }

    private static Connection getSQLServerConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(SQLSERVER_URL, SQLSERVER_USER, SQLSERVER_PASS);
    }

    private static Connection getSQLiteConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        return DriverManager.getConnection(SQLITE_URL);
    }
}