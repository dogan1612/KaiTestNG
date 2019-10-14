package com.Practice;

import com.Dogan.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class TestNGIntro {
    private WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
    }


    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test (priority = 5)
    public void openYahooTest(){
        driver.findElement(By.id("dropdownMenuLink")).click();      // Select a website
        driver.findElement(By.linkText("Yahoo")).click();
        BrowserUtils.waitPlease(2);
        String expectedURL = "https://www.yahoo.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @Test(priority = 3)
    public void openAmazonTest(){
        String currentWindow = driver.getWindowHandle();
        driver.findElement(By.id("dropdownMenuLink")).click();
        driver.findElement(By.linkText("Amazon")).click();
        BrowserUtils.waitPlease(2);
        String expectedURL = "https://www.amazon.com/";
        Set<String> windows = driver.getWindowHandles();
        for(String w: windows){
            if(!currentWindow.equals(w)){
                driver.switchTo().window(w);
            }
        }
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
