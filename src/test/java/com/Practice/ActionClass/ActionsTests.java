package com.Practice.ActionClass;

import com.Dogan.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionsTests {
    WebDriver driver;

    //simple hover example with images
    String user1TextLocator = "//a[@href='/users/1']/preceding-sibling::h5";
    String firstImageLocator = "(//img)[1]";
    //drag and drop
    String MoonLocator = "draggable";
    String EarthLocator = "droptarget";

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    // 3 resmin uzerine mouse'u kaydırıyor ve textler beliriyor
    // Hover on element  ==> We can call the moveToElement() method by passing the web element
        @Test
    public void hoverTest1(){
        driver.get("http://practice.cybertekschool.com/hovers");
        Actions action = new Actions(driver);       // We are creating an instance of the Actions class
        action.moveToElement(driver.findElement(By.xpath(firstImageLocator))).perform();

        String expectedText = "name: user1";
        String actualText = driver.findElement(By.xpath(user1TextLocator)).getText();
        Assert.assertEquals(actualText, expectedText);

        //verify that after hover event text is visible
        Assert.assertTrue(driver.findElement(By.xpath(user1TextLocator)).isDisplayed());
    }

    @Test
    public void hoverTest2(){
        driver.get("http://practice.cybertekschool.com/hovers");
        Actions action = new Actions(driver);       //DIKKAT ACTIONSSSSSSS

        List<WebElement> images = driver.findElements(By.xpath("//img"));
        // 1
        for (WebElement image: images){
            BrowserUtils.waitPlease(2);
            action.moveToElement(image).perform();
        }
        // 2
        int j=1;
        for(int i=0; i<images.size();i++){
            action.moveToElement(images.get(i)).perform();
            Assert.assertTrue(driver.findElement(By.xpath("//a[@href='/users/"+j+"']/preceding-sibling::h5")).isDisplayed());
            j++;
        }
    }

    @Test
    public void dragAndDropTest1(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Actions action = new Actions(driver);
        WebElement moon = driver.findElement(By.id(MoonLocator));   //source
        WebElement earth = driver.findElement(By.id(EarthLocator)); //target

        action.dragAndDrop(moon, earth).perform();

        //once we completed drag and drop operation, we expect to see this message
        String expectedMessage = "You did great!";
        String actualMessage = earth.getText();
        Assert.assertEquals(actualMessage, expectedMessage);

        BrowserUtils.waitPlease(2);// FOR DEMO

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}