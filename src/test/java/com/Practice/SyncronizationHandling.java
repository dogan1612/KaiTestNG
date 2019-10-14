package com.Practice;

import com.Dogan.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class SyncronizationHandling {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://gmail.com");
    }

    @Test
    public void LoginWithExplicitWait(){
        driver.findElement(By.id("identifierId")).sendKeys("kudogan@gmail.com");
        driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
    //  driver.findElement(By.xpath("//input[@type='password']")).sendKeys("abcd");     // ElementNotInteractableException

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']"))).sendKeys("abcd");

    }
    @Test
    public void LoginWithFluentWait(){
        driver.findElement(By.id("identifierId")).sendKeys("kudogan@gmail.com");
        driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))          // sets how long to wait
                .pollingEvery(Duration.ofSeconds(1))          // will check the condition every 5 seconds
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']"))).sendKeys("abcd");

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}






