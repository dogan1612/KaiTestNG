package com.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JSExecutor {

    WebDriver driver;

    @BeforeMethod
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void innerText(){
        driver.get("http://practice.cybertekschool.com");
        // get the whole text in a webpage
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String result = js.executeScript("return document.documentElement.innerText;").toString();
        System.out.println(result);
    }

    @Test
    public void AutoIndianBox(){
        driver.get("https://ksrtc.in/oprs-web/guest/home.do");
        driver.findElement(By.id("fromPlaceName")).sendKeys("BENG");    // incomplete input
        driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);

        System.out.println(driver.findElement(By.id("fromPlaceName")).getText());   // Empty ==> It can not read the data

        JavascriptExecutor js = (JavascriptExecutor)driver;
        String script = "return document.getElementById(\"fromPlaceName\").value;";
        String result = (String) js.executeScript(script);
        System.out.println(result);         // BENGALURU DARSHINI
    }


}

/*
https://www.softwaretestingmaterial.com/javascriptexecutor-selenium-webdriver/
 */