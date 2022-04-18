package dao;


import entity.Rent;
import util.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RentDao {
    //返回一个含有所有租赁信息的所有数据的list
    public static List<Rent> getdata() throws SQLException {

        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "select * from Rent;";
        ArrayList<Rent> result = new ArrayList<>();
        ResultSet set = stmt.executeQuery(sql);
        while(set.next())
        {
            int RID = set.getInt("RID");
            String fname = set.getString("fname");
            int EID = set.getInt("EID");
            Date expiretime = set.getDate("expiretime");
            Rent temp = new Rent(RID,fname,EID,expiretime);
            result.add(temp);
        }


        JDBC.release(connection,stmt,set);



        return result;
    }
    //传入fname，eid,expiretime，在租用表中新增租用关系，并且把对应设备的租用状态改为1，注意需要eid和fname需存在
    public static void add(String fname,String EID,String expiretime) throws SQLException {

        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "insert into Rent (fname,EID,expiretime) values('"+fname+"',"+EID+",'"+expiretime+"')";
        stmt.executeUpdate(sql);

        EquiDao.rentByEID(EID,"1");

        JDBC.release(connection,stmt,null);
    }
    //传入RID，删除该条记录,并且把对应的设备租用状态改成0
    public static void deleteByRID(String RID) throws SQLException {
        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();

        String EID = null;
        String sql2 = "select EID from Rent where RID ="+RID;
        ResultSet resultSet = stmt.executeQuery(sql2);
        while (resultSet.next())
        {
            EID = resultSet.getString("EID");
        }
        EquiDao.rentByEID(EID,"0");

        String sql = "delete from Rent where RID ="+RID;
        stmt.executeUpdate(sql);


        JDBC.release(connection,stmt,null);
    }
    //传入RID，返回该RID对应的租赁信息的所有信息
    public static Rent findByRID(String RID) throws SQLException {
        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();


        String sql = "select * from Rent where RID = "+RID;
        ResultSet resultSet = stmt.executeQuery(sql);
        Rent temp = null;
        while(resultSet.next())
        {
            String fname = resultSet.getString("fname");
            int EID = resultSet.getInt("EID");
            Date expiretime = resultSet.getDate("expiretime");
            int rid = Integer.parseInt(RID);

            temp= new Rent(rid,fname,EID,expiretime);
        }

        //System.out.println(temp.toString());
        JDBC.release(connection,stmt,resultSet);
        return temp;
    }
    //修改租赁信息，RID只读，不可修改
    public static void update(String RID,String EID,String fname,String expiretime) throws SQLException {
        Connection connection = JDBC.getConnection();
        Statement stmt = connection.createStatement();

        String sql = "update Rent set EID = "+EID+",fname = '"+fname+"', expiretime ='"+expiretime+"' where RID = "+RID;
        stmt.executeUpdate(sql);

        JDBC.release(connection,stmt,null);
    }


}
