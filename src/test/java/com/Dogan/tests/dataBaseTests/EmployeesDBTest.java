package com.Dogan.tests.dataBaseTests;

import com.Dogan.utilities.DBType;
import com.Dogan.utilities.DBUtility;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class EmployeesDBTest {

    @BeforeClass
    public void setUp() throws SQLException {
        DBUtility.establishConnection(DBType.ORACLE);
    }
    @AfterClass
    public void tearDown(){
        DBUtility.closeConnections();
    }

    // connect to oracle datatbase
    // run following sql
    // select * from employees where job_id='IT_PROG'
    // MORE THAN 0 RECORDS SHOULD BE RETURNED

    @Test
    public void countTest() throws SQLException {
        DBUtility.establishConnection(DBType.ORACLE);

        int rowsCount=DBUtility.getRowsCount("select * from employees where job_id='IT_PROG'");
        assertTrue(rowsCount>0);
    }

    // Connect to Oracle Database
    // Employees full name with Employee id 105 should be David Austin

    @Test
    public void nameTestByID() throws SQLException {
        List<Map<String, Object>> list = DBUtility.runSQLQuery("SELECT FIRST_NAME ||' '|| LAST_NAME FROM EMPLOYEES WHERE employee_id=105");

        // Remove spaces inside get method
        Assert.assertEquals(list.get(0).get("FIRST_NAME||''||LAST_NAME"),"David Austin");
    }
}
