package dao;

import entity.Equi;
import entity.Prod;
import util.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdDao {
    //返回一个含有所有产品的所有数据的list
    public static List<Prod> getdata() throws SQLException {

        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "select * from Product;";
        ArrayList<Prod> result = new ArrayList<>();
        ResultSet set = stmt.executeQuery(sql);
        while(set.next())
        {
            int PID = set.getInt("PID");
            String type = set.getString("type");
            Prod temp = new Prod(PID,type);
            result.add(temp);
        }


        JDBC.release(connection,stmt,set);



        return result;
    }
    //传入产品描述，在产品表中新增产品
    public static void add(String type) throws SQLException {

        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "insert into Product (type) values('"+type+"')";
        stmt.executeUpdate(sql);


        JDBC.release(connection,stmt,null);
    }
    //传入pid，删除该条记录
    public static void deleteByPID(String PID) throws SQLException {
        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "delete from Product where PID ="+PID;
        stmt.executeUpdate(sql);


        JDBC.release(connection,stmt,null);
    }
    //传入eid，返回该pid对应的产品的所有信息
    public static Prod findByPID(String PID) throws SQLException {
        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "select * from Product where PID ="+PID;
        ResultSet resultSet = stmt.executeQuery(sql);
        Prod temp = null;
        while(resultSet.next())
        {
            int pid = Integer.parseInt(PID);
            String type = resultSet.getString("type");
            temp = new Prod(pid,type);
        }

        JDBC.release(connection,stmt,resultSet);
        return temp;
    }
    //修改产品信息，pid只读，不可修改
    public static void update(String PID,String type) throws SQLException {
        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "update Product set type = '"+type+"' where PID = "+PID;
        stmt.executeUpdate(sql);

        JDBC.release(connection,stmt,null);
    }


}
