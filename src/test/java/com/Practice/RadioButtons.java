package com.Practice;

import com.Dogan.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RadioButtons {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void Test(){
        driver.get("https://www.facebook.com");
        List<WebElement> allRadioButton = driver.findElements(By.xpath("//input[@type='radio']")); // all radio buttons' webelemnts

        WebElement FemaleRadioButton = allRadioButton.get(0);
        WebElement MaleRadioButton =  allRadioButton.get(1);
        WebElement custom = allRadioButton.get(2);

        FemaleRadioButton.click();
        boolean A =  FemaleRadioButton.isSelected();
        System.out.println(A);
        BrowserUtils.waitPlease(1);

        MaleRadioButton.click();
        boolean B = MaleRadioButton.isSelected();
        System.out.println(B);
        BrowserUtils.waitPlease(1);

        custom.click();
        boolean C = custom.isSelected();
        System.out.println(C);
        BrowserUtils.waitPlease(1);

        // --> //*[contains(text(),'Custom')]   3 matching

        WebElement customText= driver.findElements(By.xpath("//*[contains(text(),'Custom')]")).get(0);
        WebElement femaleText = driver.findElement(By.xpath("//*[contains(text(),'Female')]"));
        WebElement maleText = driver.findElement(By.xpath("//*[contains(text(),'Male')]"));

        femaleText.click();
        boolean D = FemaleRadioButton.isSelected();
        System.out.println(D);
        BrowserUtils.waitPlease(1);

        maleText.click();
        boolean E = MaleRadioButton.isSelected();
        System.out.println(E);
        BrowserUtils.waitPlease(1);

        customText.click();
        boolean F = custom.isSelected();
        System.out.println(F);
        BrowserUtils.waitPlease(1);
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
