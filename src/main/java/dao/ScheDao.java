package dao;


import entity.Sche;
import util.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScheDao {
    //返回一个含有所有排产的所有数据的list
    public static List<Sche> getdata() throws SQLException {

        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "select * from schedule;";
        ArrayList<Sche> result = new ArrayList<>();
        ResultSet set = stmt.executeQuery(sql);
        while(set.next())
        {
            int SID = set.getInt("SID");
            int EID = set.getInt("EID");
            int OID = set.getInt("OID");
            int efficiency = set.getInt("efficiency");
            Sche temp = new Sche(SID,OID,EID,efficiency);
            result.add(temp);
        }


        JDBC.release(connection,stmt,set);



        return result;
    }
    //传入oid，eid，efficiency，新增排产信息
    public static void add(String OID,String EID,String efficiency) throws SQLException {

        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "insert into schedule (OID,EID,efficiency) values("+OID+","+EID+","+efficiency+");";
        stmt.executeUpdate(sql);


        JDBC.release(connection,stmt,null);
    }
    //传入sid，删除该条记录
    public static void deleteBySID(String SID) throws SQLException {
        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "delete from Schedule where SID ="+SID;
        stmt.executeUpdate(sql);


        JDBC.release(connection,stmt,null);
    }
    //传入sid，返回该sid对应的排产的所有信息
    public static Sche findBySID(String SID) throws SQLException {
        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "select * from Schedule where SID ="+SID;
        ResultSet resultSet = stmt.executeQuery(sql);
        Sche temp = null;
        while(resultSet.next())
        {
            int sid = Integer.parseInt(SID);
            int OID = resultSet.getInt("OID");
            int EID = resultSet.getInt("EID");
            int efficiency = resultSet.getInt("efficiency");
            temp= new Sche(sid,OID,EID,efficiency);
        }

        JDBC.release(connection,stmt,resultSet);
        return temp;
    }
    //修改设备信息，sid只读，不可修改
    public static void update(String SID,String OID,String EID,String efficiency) throws SQLException {
        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();

        String sql = "update Schedule set OID = "+OID+",EID = "+EID+",efficiency = "+efficiency+" where SID = "+SID;
        stmt.executeUpdate(sql);

        JDBC.release(connection,stmt,null);
    }


}
