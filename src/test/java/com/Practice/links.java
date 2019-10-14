package com.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class links {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com");
    }

    @Test
    public void test() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (int i = 1; i < links.size(); i++) {
            //if it's 5th link, skip it
            if (i == 4) {
                continue;
            }
            links.get(i).click();
            driver.navigate().back();

            //we have to find all elements again, otherwise we will get StaleElementReferenceException
            links = driver.findElements(By.tagName("a"));
            System.out.println(links.get(i).getText());

        }
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}

