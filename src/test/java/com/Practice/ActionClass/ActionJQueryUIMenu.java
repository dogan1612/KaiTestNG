package com.Practice.ActionClass;

import com.Dogan.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionJQueryUIMenu {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    // JQuery UI Menus are a challenge since it requires mouse operations and synchronization between them.
    // üzerlerine mouse ile gelince açılan menüler

    @Test
    public void jqueryMenu(){
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        Actions action = new Actions(driver);
        WebElement enabledElement = driver.findElement(By.id("ui-id-3"));
        WebElement downloadsElement = driver.findElement(By.id("ui-id-4"));     // 3'un uzerine gelince 4 beliriyor
        WebElement pdfElement = driver.findElement(By.id("ui-id-5"));           // 4'un uzerine gelince 5 beliriyor

        action.moveToElement(enabledElement).
                pause(1000).moveToElement(downloadsElement).
                pause(1000).moveToElement(pdfElement).
                click().
                build().
                perform();
        BrowserUtils.waitPlease(2);//JUST FOR DEMO
    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}