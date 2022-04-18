package dao;

import entity.Equi;
import util.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquiDao {
    //返回一个含有所有设备的所有数据的list
    public static List<Equi> getdata() throws SQLException {

        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "select * from equipment;";
        ArrayList<Equi> result = new ArrayList<>();
        ResultSet set = stmt.executeQuery(sql);
        while(set.next())
        {
            int EID = set.getInt("EID");
            int runstatus = set.getInt("runstatus");
            int rentstatus = set.getInt("rentstatus");
            String type = set.getString("type");
            Equi temp = new Equi(EID,runstatus,rentstatus,type);
            result.add(temp);
        }


        JDBC.release(connection,stmt,set);



        return result;
    }
    //传入rentstatus和runstatus以及设备类型，在设备表中新增设备
    public static void add(String rentstatus,String runstatus,String type) throws SQLException {

        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "insert into equipment (rentstatus,runstatus,type) values("+rentstatus+","+runstatus+",'"+type+"')";
        stmt.executeUpdate(sql);


        JDBC.release(connection,stmt,null);
    }
    //传入eid，删除该条记录
    public static void deleteByEID(String EID) throws SQLException {
        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "delete from Equipment where EID ="+EID;
        stmt.executeUpdate(sql);


        JDBC.release(connection,stmt,null);
    }
    //传入eid，返回该eid对应的设备的所有信息
    public static Equi findByEID(String EID) throws SQLException {
        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "select * from Equipment where EID ="+EID;
        ResultSet resultSet = stmt.executeQuery(sql);
        Equi temp = null;
        while(resultSet.next())
        {
            int eid = Integer.parseInt(EID);
            int runstatus = resultSet.getInt("runstatus");
            int rentstatus = resultSet.getInt("rentstatus");
            String type = resultSet.getString("type");
            temp= new Equi(eid,runstatus,rentstatus,type);
        }

        JDBC.release(connection,stmt,resultSet);
        return temp;
    }
    //修改设备信息，eid只读，不可修改
    public static void update(String EID,String rentstatus,String runstatus,String type) throws SQLException {
        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();

        String sql = "update Equipment set rentstatus = "+rentstatus+",runstatus = "+runstatus+",type = '"+type+"' where EID = "+EID;
        stmt.executeUpdate(sql);

        JDBC.release(connection,stmt,null);
    }
    //修改设备租赁状态
    public static void rentByEID(String EID,String rentstatus) throws SQLException {
        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();

        String sql = "update Equipment set rentstatus = "+rentstatus+" where EID = "+EID;
        stmt.executeUpdate(sql);

        JDBC.release(connection,stmt,null);
    }

}
