package com.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class sendKeys {

    WebDriver driver;

    @BeforeMethod
    public void Setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void kolayMenu() {
        driver.get("http://hotels.com");
        driver.findElement(By.cssSelector("select[id$=occupancy]")).sendKeys("1 room, 1 adult");
    }
    @Test
    public void eksikMetin() {
        driver.get("https://ksrtc.in/oprs-web/guest/home.do");
        driver.findElement(By.className("init-close")).click();
        driver.findElement(By.id("fromPlaceName")).sendKeys("Beng");    // tam metin degil
        driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);            // sıralanan seçeneklerden ilerliyoruz
        driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
        System.out.println(driver.findElement(By.id("fromPlaceName")).getText());
    }

    @Test (enabled = false)
    public void login_logout(){
        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.id("wooden_spoon")).click();

        // Assert.assertEquals("You logged into a secure area!",driver.findElement(By.id("flash")).getText() );

        driver.findElement(By.linkText("Logout")).click();
        SoftAssert soft = new SoftAssert();
        soft.assertEquals("Practice", driver.getTitle());
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
