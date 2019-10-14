package com.Practice;

import com.Dogan.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class MultipleButtons {

    WebDriver driver;
    //only buttons from 1-5
    String allButtonsLocator = "//button[starts-with(@onclick,'button')]";
    String button3Locator = "//button[starts-with(@id,'button_')]";
    String button6locator = "//*[@id='disappearing_button']";
    String resultLocator = "//p[@id='result']";

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
    }

    @Test
    public void verifyButton3() {
        String expectedMessage = "Clicked on button three!";
        driver.findElement(By.xpath(button3Locator)).click();
        BrowserUtils.waitPlease(2);
        String actualMessage = driver.findElement(By.xpath(resultLocator)).getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void verifyButton6() {
//      If element is not in the DOM, and you are trying to find that element, you will get exception.
//      Example: After we clicked on the button, that button was deleted. isDisplayed() will return false.
//
//      If you need to check if element is gone, not on the page:
//      Assert.assertTrue(driver.findElements(By.xpath(button6locator)).size() == 0);
//      findElements(By.xpath(button6locator)).size() == 0  means 0 elements found based on this locator. No exception will occur.

        String expectedMessage = "Now it's gone!";
        expectedMessage.compareTo(expectedMessage);
        driver.findElement(By.xpath(button6locator)).click();
        BrowserUtils.waitPlease(2);
        String actualMessage = driver.findElement(By.xpath(resultLocator)).getText();
        Assert.assertEquals(actualMessage, expectedMessage);
//      Assert.assertTrue(driver.findElement(By.xpath(button6locator)).isDisplayed()); will fail
        Assert.assertTrue(driver.findElements(By.xpath(button6locator)).size() == 0);
    }

    @Test
    public void clickOnEveryButton() {
        List<WebElement> buttons = driver.findElements(By.xpath(allButtonsLocator));
        for (WebElement button : buttons) {
            button.click();
            BrowserUtils.waitPlease(1);
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

