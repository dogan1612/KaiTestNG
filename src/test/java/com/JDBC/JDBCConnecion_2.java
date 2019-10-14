package com.JDBC;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCConnecion_2 {

    String oracleDBUrl = "jdbc:oracle:thin:@ec2-3-83-24-206.compute-1.amazonaws.com:1521:xe";
    String oracleDBPassword = "hr";
    String oracleDBUsername = "hr";

    @Test
    public void jdbcMetaData() throws SQLException {
        Connection connection = DriverManager.getConnection(oracleDBUrl, oracleDBUsername, oracleDBPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        String sql = "select employee_id, last_name, job_id, salary from employees";
        ResultSet resultSet = statement.executeQuery(sql);

        //Database metadata
        DatabaseMetaData dbMetadata = connection.getMetaData();
        System.out.println("User: " + dbMetadata.getUserName());                        // User: HR
        System.out.println("Database type: "+ dbMetadata.getDatabaseProductName());     // Database type: Oracle

        //resultSet metadata
        ResultSetMetaData rsMedata = resultSet.getMetaData();
        System.out.println("Number of columns: "+rsMedata.getColumnCount());          // Number of columns: 4
        System.out.println("Name of columns: "+rsMedata.getColumnName(3));            // Name of columns: JOB_ID

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // THROW RESULTSET INTO A LIST OF MAPS (BOYLE DENIR)
        // FIRST I CREATE A LIST OF MAPS
        // I USE STRING AS A KEY => WHICH IS REPRESENTS THE COLUMN NAME
        // OBJECT BCOS WE CAN BE ANY KIND OF DATA
        List<Map<String, Object>> list = new ArrayList<>();
        ResultSetMetaData rsMetadata = resultSet.getMetaData();
        int c = rsMedata.getColumnCount();

        while(resultSet.next()){
            Map<String, Object> rowMap = new HashMap<>();

            for(int col=1;col<=c; col++){                 // DIKKAT: 1'DEN BASLAR   // her satirdaki hucreleri teker teker map'e atiyoruz
                rowMap.put(rsMedata.getColumnName(col), resultSet.getObject(col));
            }
            list.add(rowMap);
        }

        // print all employee ids from a list of maps
        for (Map<String, Object> e: list){
            System.out.println(e.get("JOB_ID"));
        }

    }
}
