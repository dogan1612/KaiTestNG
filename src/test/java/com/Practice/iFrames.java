package com.Practice;

import com.Dogan.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class iFrames {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");
    }

    @Test
    public void dropIt(){
        System.out.println(driver.findElements(By.tagName("iframe")).size());       // 1 (There is only 1 iframe on the website)
        System.out.println(driver.findElement(By.tagName("iframe")).getSize());     // (552, 420)

        driver.switchTo().frame(0);     // // we have to switch to the frame and then we can use xpath.

        Actions action = new Actions (driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        action.dragAndDrop(source, target).perform();
        BrowserUtils.waitPlease(2);

        driver.switchTo().defaultContent();     // if you want to get back to the main frame,
        // driver.switchTo().parentFrame();     // To move back to the parent frame
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}

