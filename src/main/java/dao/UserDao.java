package dao;


import entity.User;
import util.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    //返回一个含有所有用户的所有数据的list
    public static List<User> getdata() throws SQLException {

        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "select * from User;";
        ArrayList<User> result = new ArrayList<>();
        ResultSet set = stmt.executeQuery(sql);
        while(set.next())
        {
            int UID = set.getInt("UID");
            String password = set.getString("password");
            String address = set.getString("address");
            String phonenumber = set.getString("phonenumber");
            String actor = set.getString("actor");
            User temp = new User(UID,password,address,phonenumber,actor);
            result.add(temp);
        }


        JDBC.release(connection,stmt,set);



        return result;
    }
    //传入密码，住址，联系方式，手机号，用户类型，在用户表中新增用户
    public static void add(String password,String address,String phonenumber,String actor) throws SQLException {

        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "insert into User (password,address,phonenumber,actor) values('"+password+"','"+address+"','"+phonenumber+"','"+actor+"')";
        stmt.executeUpdate(sql);


        JDBC.release(connection,stmt,null);
    }
    //传入UID，删除该条记录
    public static void deleteByUID(String UID) throws SQLException {
        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "delete from User where UID ="+UID;
        stmt.executeUpdate(sql);


        JDBC.release(connection,stmt,null);
    }
    //传入UID，返回该UID对应的用户的所有信息
    public static User findByUID(String UID) throws SQLException {
        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "select * from User where UID = "+UID;
        ResultSet resultSet = stmt.executeQuery(sql);
        User temp = null;
        while(resultSet.next())
        {
            int uid = Integer.parseInt(UID);
            String password = resultSet.getString("password");
            String address = resultSet.getString("address");
            String phonenumber = resultSet.getString("phonenumber");
            String actor = resultSet.getString("actor");
            temp= new User(uid,password,address,phonenumber,actor);
        }

        JDBC.release(connection,stmt,resultSet);
        return temp;
    }
    //修改用户信息，UID只读，不可修改
    public static void update(String UID,String password,String address,String phonenumber,String actor) throws SQLException {
        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();

        String sql = "update User set password = '"+password+"',address = '"+address+"',phonenumber = '"+phonenumber+"',actor = '"+actor+"' where UID = "+UID;
        stmt.executeUpdate(sql);

        JDBC.release(connection,stmt,null);
    }
    //根据UID判断用户权限
    public static String getActor(String UID) throws SQLException {
        String actor = null;
        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "select actor from User where UID = "+UID;
        ResultSet resultSet = stmt.executeQuery(sql);

        while(resultSet.next())
        {
           actor = resultSet.getString("actor");
        }

        JDBC.release(connection,stmt,resultSet);
        return actor;

    }
    //根据UID和password判断用户存在不存在
    public static boolean login(String UID,String password) throws SQLException {
        boolean flag = false;
        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "select * from User where UID = "+UID +"&& password = "+password;
        ResultSet resultSet = stmt.executeQuery(sql);

        while(resultSet.next())
        {
           flag = true;
        }

        JDBC.release(connection,stmt,resultSet);
        return flag;
    }
}
