package com.Practice.ActionClass;

import com.Dogan.utilities.BrowserUtils;
import com.Dogan.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Draggable {

    WebDriver driver = Driver.getDriver();

    @BeforeClass
    public void setup() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/draggable/");
    }

    @Test(priority = 1)
    public void draggable(){
        driver.switchTo().frame(0);
        WebElement dragMe = driver.findElement(By.id("draggable"));
        Actions action = new Actions (driver);
        BrowserUtils.waitPlease(1);
        action.dragAndDropBy(dragMe,180,180).perform(); // koordinat degil, hareketin yonunu ifade ediyor
        BrowserUtils.waitPlease(1);
    }

    @Test (priority = 2)
    public void dragit() {
        WebElement dragMe = driver.findElement(By.id("draggable"));
        Actions action = new Actions(driver);
        for (int i = 1; i < 20; i++) {
            int x = -10;
            int y = -10;
            action.dragAndDropBy(dragMe, x, y).perform();
            x += 10;
            y += 10;
        }
    }

    @Test (priority = 3)
    public void holdMouse(){
        WebElement dragMe = driver.findElement(By.id("draggable"));
        Actions action = new Actions(driver);
        action.clickAndHold(dragMe).moveByOffset(400,0).release().perform();
        BrowserUtils.waitPlease(2);
    }

    @AfterClass
    public void teardown(){
        Driver.closeDriver();
    }
}
