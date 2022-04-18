package dao;



import entity.Fact;
import util.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FactDao {
    //返回一个含有所有工厂的所有数据的list
    public static List<Fact> getdata() throws SQLException {

        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "select * from Factory;";
        ArrayList<Fact> result = new ArrayList<>();
        ResultSet set = stmt.executeQuery(sql);
        while(set.next())
        {
            int UID = set.getInt("UID");
            String fname = set.getString("fname");
            int status = set.getInt("status");
            Fact temp = new Fact(fname,UID,status);
            result.add(temp);
        }


        JDBC.release(connection,stmt,set);



        return result;
    }
    //传入fname，uid,status，在工厂表中新增工厂，注意需要用户表中有该uid代表的用户
    public static void add(String fname,String UID,String status) throws SQLException {

        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "insert into Factory (fname,UID,status) values('"+fname+"',"+UID+","+status+")";
        stmt.executeUpdate(sql);


        JDBC.release(connection,stmt,null);
    }
    //传入fname，删除该条记录
    public static void deleteByfname(String fname) throws SQLException {
        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "delete from Factory where fname ='"+fname+"'";
        stmt.executeUpdate(sql);


        JDBC.release(connection,stmt,null);
    }
    //传入fname，返回该fname对应的工厂的所有信息
    public static Fact findByfname(String fname) throws SQLException {
        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "select * from Factory where fname = '"+fname+"'";
        ResultSet resultSet = stmt.executeQuery(sql);
        Fact temp = null;
        while(resultSet.next())
        {
            String UID = resultSet.getString("UID");
            int uid = Integer.parseInt(UID);
            String Status = resultSet.getString("status");
            int status = Integer.parseInt(Status);
            temp= new Fact(fname,uid,status);
        }

        JDBC.release(connection,stmt,resultSet);
        return temp;
    }
    //修改工厂信息，fname只读，不可修改
    public static void update(String fanme,String UID,String status) throws SQLException {
        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();

        String sql = "update Factory set UID = "+UID+",status = "+status+" where fname = '"+fanme+"'";
        stmt.executeUpdate(sql);

        JDBC.release(connection,stmt,null);
    }

    //根据传入的UID返回fname
    public static String findfnameByUID(String UID) throws SQLException {
        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();

        String sql = "select fname from Factory where UID = "+UID;

        ResultSet resultSet = stmt.executeQuery(sql);
        String fname = null;
        while(resultSet.next())
        {
            fname = resultSet.getString("fname");
        }
        JDBC.release(connection,stmt,null);
        return fname;
    }

}
