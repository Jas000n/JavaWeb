package dao;

import entity.Bid;
import util.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BidDao {
    //返回一个含有所有竞标的所有数据的list
    public static List<Bid> getdata() throws SQLException {

        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "select * from Bid;";
        ArrayList<Bid> result = new ArrayList<>();
        ResultSet set = stmt.executeQuery(sql);
        while(set.next())
        {
            int BID = set.getInt("BID");
            String fname = set.getString("fname");
            int OID = set.getInt("OID");
            int status = set.getInt("status");
            int price = set.getInt("price");

            Bid temp = new Bid(BID,fname,OID,status,price);
            result.add(temp);
        }


        JDBC.release(connection,stmt,set);



        return result;
    }
    //传入fname,OID,price，在竞标表中新增竞标，status默认生成为0
    public static void add(String fname,String OID,String price) throws SQLException {

        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "insert into BID (fname,OID,status,price) values('"+fname+"',"+OID+", 0,"+price+")";
        stmt.executeUpdate(sql);


        JDBC.release(connection,stmt,null);
    }
    //传入bid，删除该条记录
    public static void deleteByBID(String BID) throws SQLException {
        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "delete from BID where BID ="+BID;
        stmt.executeUpdate(sql);


        JDBC.release(connection,stmt,null);
    }
    //传入bid，返回该bid对应的设备的所有信息
    public static Bid findByBID(String BID) throws SQLException {
        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "select * from Bid where BID ="+BID;
        ResultSet resultSet = stmt.executeQuery(sql);
        Bid temp = null;
        while(resultSet.next())
        {
            int bid = Integer.parseInt(BID);
            int status = resultSet.getInt("status");
            String fname = resultSet.getString("fname");
            int OID = resultSet.getInt("OID");
            int price = resultSet.getInt("price");

            temp= new Bid(bid,fname,OID,status,price);
        }

        JDBC.release(connection,stmt,resultSet);
        return temp;
    }
    //修改竞标状态，bid只读，不可修改
    public static void update(String BID, String fname,String OID,String status,String price) throws SQLException {
        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();

        String sql = "update Bid set fname = '"+fname+"',OID = "+OID+",status = "+status+",price = "+price+" where BID = "+BID;
        stmt.executeUpdate(sql);

        JDBC.release(connection,stmt,null);
    }
    //修改竞标状态，使bid中标
    public static void selectByBID(String BID) throws SQLException {
        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();

        String sql = "update Bid set status = 1 where BID = "+BID;
        stmt.executeUpdate(sql);

        JDBC.release(connection,stmt,null);
    }

}
