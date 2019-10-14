package com.Dogan.tests.components.login_navigation;


import com.Dogan.utilities.ExcelUtil;
import com.Dogan.utilities.Pages;
import com.Dogan.utilities.TestBase;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTLoginTests extends TestBase {

    @Test(dataProvider = "credentials_info")
    public void loginTestWithDataProvider(String execute, String username, String password, String firstname, String lastname, String result){
        Pages page = new Pages();
        extentLogger = report.createTest("Data Driver Testing with excel");
        if(execute.equalsIgnoreCase("y")){
            page.loginPage().login(username, password);
            String actualFullName = page.dashboardPage().getUsersFullName();
            String expectedFullName = firstname+" "+lastname;
            Assert.assertEquals(actualFullName, expectedFullName, "Name doesn't match");
            page.dashboardPage().logout();
            extentLogger.pass("Login as "+username+" successful");
        }else{
            throw new SkipException("Test ignored");
        }
    }

    @DataProvider(name="credentials_info")
    public Object[][] credentials(){
        ExcelUtil qa2 = new ExcelUtil("src/test/resources/Vytrack testusers.xlsx", "QA2-short");
        return qa2.getDataArray();
    }
}