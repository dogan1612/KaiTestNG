package com.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertClassPopUp {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void dismiss(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        //Trigger the javaScript alert
        WebElement triggerMethod = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        triggerMethod.click();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        WebElement actMessage = driver.findElement(By.xpath("//p[@id='result']"));
        String actualText = actMessage.getText();
        String expectedText = "You clicked: Cancel";

    }
}