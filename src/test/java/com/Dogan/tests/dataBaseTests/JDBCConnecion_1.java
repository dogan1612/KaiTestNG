package com.Dogan.tests.dataBaseTests;

import org.testng.annotations.Test;

import java.sql.*;

public class JDBCConnecion_1 {

    String oracleDBUrl = "jdbc:oracle:thin:@ec2-3-83-24-206.compute-1.amazonaws.com:1521:xe";
    String oracleDBPassword = "hr";
    String oracleDBUsername = "hr";

    @Test
    public void oracleJDBC() throws SQLException {
        Connection connection = DriverManager.getConnection(oracleDBUrl, oracleDBUsername, oracleDBPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("Select * from countries");

        resultSet.next();
        System.out.println(resultSet.getString("country_name"));    // Argentina
        System.out.println(resultSet.getInt("region_id"));          // 2
        System.out.println(resultSet.getString(1));                 // AR
        System.out.println(resultSet.getString(2));                 // Argentina
        resultSet.next();
        System.out.println(resultSet.getString("country_name"));    // Australia

        resultSet.close();      // we can also close them
        statement.close();
        connection.close();
    }

    @Test
    public void oracleJDBC1() throws SQLException {
        Connection connection = DriverManager.getConnection(oracleDBUrl, oracleDBUsername, oracleDBPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("Select * from countries");

        while (resultSet.next()) {
            System.out.println(resultSet.getString(1)+ "-"+resultSet.getString("country_name")+"-"+resultSet.getString("region_id"));
        }
    }

    @Test
    public void oracleJDBC2() throws SQLException {
        Connection connection = DriverManager.getConnection(oracleDBUrl, oracleDBUsername, oracleDBPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("Select * from countries");

        resultSet.next();
        System.out.println(resultSet.getRow());   // 1

        resultSet.previous();

        resultSet.last();
        System.out.println(resultSet.getRow());   // 25

        resultSet.previous();
        System.out.println(resultSet.getRow());   // 24

        resultSet.first();
        System.out.println(resultSet.getRow());   // 1

        //Find out how many records in the resultset
        resultSet.last();
        int rowsCount = resultSet.getRow();   // 25

        //1.satir ile ilgili islem yapabilmek icin once basa donmek lazim
        resultSet.beforeFirst();        // bunu yazmazsak 2.den baslar
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1)+ "-"+resultSet.getString("country_name")+"-"+resultSet.getString("region_id"));
        }


    }


}
/*
    @Test
    public void nameTestByID(){
//Test if EmployeeId=105 has full name David Austin DBUtility.establishConnection(DBType.ORACLE);

        List<Map<String,Object>> list=DBUtility.runSQLQuery("select first_name||last_name from employees where employee_id=105");


        Assert.assertTrue(list.get(0).get("FIRST_NAME||LAST_NAME").equals("DavidAustin"));

//System.out.println(list.get(0).get("FIRST_NAME||LAST_NAME")); DBUtility.closeConnections();
    }

 */


