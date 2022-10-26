package com.entity.inter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AbstractDao {
    private static Connection conn;

    public static Connection get() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(
                        "jdbc:postgresql://ec2-3-220-207-90.compute-1.amazonaws.com:5432/dgoetfuaviiqk",
                        "fnerjqwfyojtcl",
                        "be7c163971b7a147673a5e14a6c2e842ab706e50e1e209eb9cb3662d41716d80"
                );
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }


    public static Connection getFromUrl() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://fnerjqwfyojtcl" +
                ":be7c163971b7a147673a5e14a6c2e842ab706e50e1e209eb9cb3662d41716d80@ec2-3-220-207-90.compute-1.amazonaws.com:5432/dgoetfuaviiqk");
    }
}
