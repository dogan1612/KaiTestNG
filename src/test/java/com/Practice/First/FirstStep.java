package com.Practice.First;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstStep {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/dogan/Documents/Selenium Dependencies/Drivers/chromedriver");

        /*
        == FIREFOX ==
        System.setProperty("webdriver.gecko.driver","/Users/dogan/Documents/Selenium Dependencies/Drivers/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://google.com");
*/

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        System.out.println(driver.getCurrentUrl());
        driver.navigate().to("https://amazon.com");
        driver.navigate( ).back();
        driver.navigate( ).refresh( );

        String pageSource = driver.getPageSource(); // it reads html code of web page
        System.out.println(pageSource);

        driver.quit();

        // story: At work, I had to use Internet Explorer for testing. There was one page,
        // where I had to click and modal dialog was displayed.
        // I couldn't read that modal dialog with chrome or any other browser to inspect and create locators.
        // So in order to read the source of code of that page, I used method getPageSource() then I was able to


        /*
        driver.navigate().to();
        driver.navigate().back();           // onceki sayfaya git
        driver.navigate().forward();        // sonraki sayfaya git
        driver.navigate().refresh();        // refresh current page
        driver.close();                     // close browser at the end of
        */
    }
}
