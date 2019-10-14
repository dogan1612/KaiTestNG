package com.Dogan.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;

public class CyberUtils {

    public static void login(WebDriver driver, String username, String password){
        driver.findElement(By.name("username")).sendKeys(ConfigurationReader.getProperty("username"));
        driver.findElement(By.name("password")).sendKeys((ConfigurationReader.getProperty("password")), Keys.ENTER);
        BrowserUtils.waitPlease(2);
        Driver.getDriver().findElement(By.cssSelector("a[class='nav-link']")).click();
        BrowserUtils.waitPlease(1);
    }
    public static void login(){
        Driver.getDriver().findElement(By.name("username")).sendKeys(ConfigurationReader.getProperty("username"));
        Driver.getDriver().findElement(By.name("password")).sendKeys(ConfigurationReader.getProperty("password"));
        Driver.getDriver().findElement(By.id("wooden_spoon")).click();
        Driver.getDriver().findElement(By.cssSelector("a[class='nav-link']")).click();

        //   String username = ConfigurationReader.getProperty("username");
     //   String password = ConfigurationReader.getProperty("password");
     //   login(Driver.getDriver(), username, password);
    }

    public static void navigateToModule(WebDriver driver, String module){
        String moduleLocator = "//a[contains(text(),'"+module+"')]";
        driver.findElement(By.xpath(moduleLocator)).click();
    }
    public static void navigateToModule(String module){
        navigateToModule(Driver.getDriver(), module);
    }

}
