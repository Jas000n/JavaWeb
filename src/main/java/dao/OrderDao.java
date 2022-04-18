package dao;

import entity.Equi;
import entity.Order;
import util.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    //返回一个含有所有订单的所有数据的list
    public static List<Order> getdata() throws SQLException {

        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "select * from `Order`";
        ArrayList<Order> result = new ArrayList<>();
        ResultSet set = stmt.executeQuery(sql);
        while(set.next())
        {
            int OID = set.getInt("OID");
            String status = set.getString("status");
            Date duetime = set.getDate("duetime");
            int quantity = set.getInt("quantity");
            int UID = set.getInt("UID");
            int PID = set.getInt("PID");
            Order temp = new Order(OID,status,duetime,quantity,UID,PID);
            result.add(temp);
        }


        JDBC.release(connection,stmt,set);



        return result;
    }
    //传入duetime,quantity,UID,PID，在订单表中新增订单，status默认未no bidding
    public static void add(String duetime,String quantity,String UID,String PID) throws SQLException {

        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "insert into `Order` (status,duetime,quantity,UID,PID) values('no bidding','"+duetime+"',"+quantity+","+UID+","+PID+");";
        stmt.executeUpdate(sql);


        JDBC.release(connection,stmt,null);
    }
    //传入oid，删除该条记录
    public static void deleteByOID(String OID) throws SQLException {
        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "delete from `Order` where OID ="+OID;
        stmt.executeUpdate(sql);


        JDBC.release(connection,stmt,null);
    }
    //传入oid，返回该oid对应的订单的所有信息
    public static Order findByOID(String OID) throws SQLException {
        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "select * from `Order` where OID ="+OID;
        ResultSet resultSet = stmt.executeQuery(sql);
        Order temp = null;
        while(resultSet.next())
        {
            int oid = Integer.parseInt(OID);
            String status = resultSet.getString("status");
            Date duetime = resultSet.getDate("duetime");
            int quantity = resultSet.getInt("quantity");
            int UID = resultSet.getInt("UID");
            int PID = resultSet.getInt("PID");
            temp= new Order(oid,status,duetime,quantity,UID,PID);
        }

        JDBC.release(connection,stmt,resultSet);
        return temp;
    }
    //修改设备信息，oid只读，不可修改
    public static void update(String OID,String status,String duetime,String quantity,String UID,String PID) throws SQLException {
        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();

        String sql = "update `Order` set status = '"+status+"',duetime = '"+duetime+"',quantity = "+quantity+",UID = "+UID+",PID = "+PID+" where OID = "+OID;
        stmt.executeUpdate(sql);

        JDBC.release(connection,stmt,null);
    }
    //修改订单竞标状态
    public static void bidByOID(String OID,String status) throws SQLException {
        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();

        String sql = "update `Order` set status = "+status+" where OID = "+OID;
        stmt.executeUpdate(sql);

        JDBC.release(connection,stmt,null);
    }

}
