package com.tw.core.util;

import java.sql.*;

/**
 * Created by marry on 7/8/15.
 */
public class DBConnectionHelper {
    private static final String  url = "jdbc:mysql://localhost/adduser";
    private static final String username = "root";
    private static final String userpwd = "root";
    public Connection dbConnection(){
        try {
            //加载驱动，这一句也可写为：Class.forName("com.mysql.jdbc.Driver");
            // Class.forName("com.mysql.jdbc.Driver").newInstance();
            //建立到MySQL的连接
            Connection conn = DriverManager.getConnection(url, username, userpwd);
            return conn;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void dbClose(PreparedStatement statement, ResultSet resultset, Connection connection){
        try {
            statement.close();
            resultset.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
