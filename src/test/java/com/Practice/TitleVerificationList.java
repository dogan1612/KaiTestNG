package com.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerificationList {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                                          "http://practice.cybertekschool.com/dropdown",
                                          "http://practice.cybertekschool.com/login");

        String expectedTitle = "Practice";          //expected title for every website
        String expectedURL = "http://practice.cybertekschool.com";

        for(String url: urls){
            driver.get(url);
            if(driver.getTitle().equals(expectedTitle)){
                System.out.println("Passed");
            }else{
                System.out.println("Title incorrect: "+driver.getTitle());
                System.out.println("Failed");
            }
            if(driver.getCurrentUrl().startsWith(expectedURL)){
                System.out.println("Passed");
            }else{
                System.out.println("URL is not correct: "+driver.getCurrentUrl());
                System.out.println("Failed");
            }
        }
        ///////////////////// *** \\\\\\\\\\\\\\\\\\\\

        driver.get("http://www.google.com");

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");        // Enter something to search for
        element.submit();

        System.out.println("Page title is: " + driver.getTitle());

        driver.quit();

    }
}
