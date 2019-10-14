package com.Practice.Select_Class;

import com.Dogan.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectPractice2 {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.tizag.com/htmlT/htmlselect.php");
    }

    @Test
    public void dropDownTest1() throws InterruptedException {
        driver.findElement(By.xpath("//div[4]//select")).sendKeys("Colorado -- CO");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//div[4]//select")).sendKeys("CA");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//div[4]//select")).sendKeys("Connecticut");
    }

    @Test
    public void dropDownTest2(){
        Select select = new Select(driver.findElement(By.xpath("//div[4]//select")));
        System.out.println( select.getFirstSelectedOption().getText() );
        select.selectByValue("CO");
        select.selectByVisibleText("Connecticut -- CN");
        select.selectByIndex(2);
        // select.deselectAll();    ==> UnsupportedOperationException: You may only deselect all options of a multi-select
        select.getOptions();
        List list = select.getOptions();
        int listSize = list.size();
        System.out.println( listSize);
    }

    @Test
    public void dropDownTest3(){
        Select select = new Select(driver.findElement(By.xpath("//div[6]//select")));
        select.selectByIndex(0);
        select.selectByIndex(1);
        select.selectByIndex(2);
        select.deselectAll();
        System.out.println(select.isMultiple());
    }

    @Test
    public void dropDownTest4(){
        WebElement readOnly = driver.findElement(By.xpath("//div[8]//select"));
        System.out.println(readOnly.isEnabled());
        Assert.assertEquals(readOnly.isEnabled(),false, "Selection should be read-only");

        Select select = new Select(driver.findElement(By.xpath("//div[8]//select")));
        select.selectByIndex(1);       // no error but it will not work
        System.out.println(select.getFirstSelectedOption().getText());
    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}









