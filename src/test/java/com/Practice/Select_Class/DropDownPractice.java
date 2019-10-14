package com.Practice.Select_Class;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownPractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropdownMenu  = driver.findElement(By.id("dropdown"));
        Select dropdownSelect = new Select(dropdownMenu);           // We pass the web element, not the driver

        String expected = "Please select an option";
        String actual = dropdownSelect.getFirstSelectedOption().getText();
        Assert.assertEquals(actual, expected);

        List<WebElement> options = dropdownSelect.getOptions();     // List of options that are present in dropdown
        for(WebElement option: options){
            System.out.println(option.getText());
        }

        WebElement dropdownState = driver.findElement(By.id("state"));
        Select state = new Select(dropdownState);
        state.selectByVisibleText("Virginia");
        Thread.sleep(1000);
        state.selectByValue("PA");

        List<WebElement> states = state.getOptions();
        for(WebElement option:states){
            Thread.sleep(1000);
            state.selectByVisibleText(option.getText());  //select every option by text
        }


    }
}
