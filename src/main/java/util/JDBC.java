package util;

import java.sql.*;

public class JDBC {
    private static Connection connection;
    private static String url = "jdbc:mysql://localhost:3306/CloudFactory?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&useSSL=true";
    private static String username = "root";
    private static String pass = "qwertyuiop";
    static {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(url,username,pass);
        return connection;
    }
    public static void release(Connection connection, Statement stmt, ResultSet resultSet) throws SQLException {
        if(connection!=null){
            connection.close();
        }
        if(stmt != null){
            stmt.close();
        }
        if(resultSet!=null){
            resultSet.close();
        }

    }
}
