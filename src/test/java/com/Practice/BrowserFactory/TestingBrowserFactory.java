package com.Practice.BrowserFactory;

import org.openqa.selenium.WebDriver;

public class TestingBrowserFactory {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
        Thread.sleep(2000);
        driver.get("http://practice.cybertekschool.com");
        try{
            Thread.sleep(3000); // needs to be handled: try-catch or throws InterruptedException
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        String actualTitle= driver.getTitle();
        String expectedTitle = "Practice";
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
            System.out.println("Expected title is: " +expectedTitle);
            System.out.println("But actual title is: " +actualTitle);
        }
        driver.quit();
    }
}
//in order to call static members
// we use class name not object name

//Webdriver is an interface.
//ChromeDriver implement this interface

// we can put either InterruptedException or Exception for Thread.sleep() catch statement,
// because  InterruptedException class extends Exception class. Also, we can use Throwable.
// class InterruptedException extends Exception {

// Interview story: When I joined my current project, our framework had a lot of thread.sleep()
// me as super hero changed all these hard coded wait to explicit waits.
// BY DOING THIS WE REDUCED Execution time twice