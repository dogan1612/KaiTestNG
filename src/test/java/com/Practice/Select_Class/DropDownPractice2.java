package com.Practice.Select_Class;

import com.Dogan.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownPractice2 {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void Test1() {
        WebElement element = driver.findElement(By.xpath("//h3[text()='Dropdown List']"));
        BrowserUtils.verifyIsDisplayed(element);
    }

    @Test
    public void Test2(){
        WebElement dropdown1 = driver.findElement(By.id("dropdown"));
        //to work with select elements
        //we need to use Select class
        //don't forget to pass web element of that dropdown that you found into constructor
        Select dropdownSelect = new Select(dropdown1);
        //since dropdown consists of options
        //we can check which one is selected
        //getFirstSelectedOption() return webelement, use getText() method if
        //you want to get a text of this option, Usally, text is a visible part of
        //dropdown. Value or other attributes of drop down, not visible.
        String actual = dropdownSelect.getFirstSelectedOption().getText();
        String expected = "Please select an option";
        BrowserUtils.verifyEquals(expected, actual);
        //we can get list of options that are present in the dropdown
        List<WebElement> options = dropdownSelect.getOptions();
        for(WebElement option: options){
            System.out.println(option.getText());
        }
    }

    @Test
    public void Test3(){
        WebElement dropdownState = driver.findElement(By.id("state"));
        Select dropDownSelect = new Select(dropdownState);
        List<WebElement> states = dropDownSelect.getOptions();
        for (WebElement element: states){
            System.out.println(element.getText());
        }
        //let's select virginia
        //we have to use object of Select class
        dropDownSelect.selectByVisibleText("Virginia");
        BrowserUtils.waitPlease(2);
        dropDownSelect.selectByVisibleText("Texas");
        BrowserUtils.waitPlease(2);
        dropDownSelect.selectByVisibleText("California");
        BrowserUtils.waitPlease(2);
        dropDownSelect.selectByVisibleText("Kansas");
        BrowserUtils.waitPlease(2);
        dropDownSelect.selectByVisibleText("New Jersey");
        BrowserUtils.waitPlease(2);
        dropDownSelect.selectByVisibleText("Florida");
        BrowserUtils.waitPlease(2);
        dropDownSelect.selectByVisibleText("Tennessee");
        BrowserUtils.waitPlease(2);
        dropDownSelect.selectByVisibleText("Ohio");

    }

    @Test
    public void Test4(){
        WebElement dropdownState = driver.findElement(By.id("state"));
        //object of select class
        //it has methods that helps to work with drop downs
        Select dropDownSelect = new Select(dropdownState);
        //we found all options that are available to select
        List<WebElement> states = dropDownSelect.getOptions();
        //we loop through all options
        for(WebElement option: states){
            BrowserUtils.waitPlease(1);
            //and select every option by text
            //<option value="PA">Pennsylvania</option>
            //means find option that has text Pennsylvania and select it
            dropDownSelect.selectByVisibleText(option.getText());
        }
    }
    //select by value
    @Test
    public void Test5(){
        WebElement dropdownState = driver.findElement(By.id("state"));
        Select dropDownSelect = new Select(dropdownState);
        //<option value="PA">Pennsylvania</option>
        //means find option that has value PA and select it
        dropDownSelect.selectByValue("PA");
        BrowserUtils.waitPlease(2);
        String expected = "Pennsylvania";
        //to read option is selected
        String actual = dropDownSelect.getFirstSelectedOption().getText();
        BrowserUtils.verifyEquals(expected, actual);

    }
    //select by index
    @Test
    public void Test6(){
        WebElement dropdownState = driver.findElement(By.id("state"));
        Select dropDownSelect = new Select(dropdownState);
        BrowserUtils.waitPlease(2);
        dropDownSelect.selectByIndex(5);
        BrowserUtils.waitPlease(2);
    }

    //multiple select
    public void test6(){
        WebElement multipleSelectionWebElement = driver.findElement(By.xpath("//select[@name='Languages']"));
        Select multipleSelectionSelect = new Select(multipleSelectionWebElement);

        BrowserUtils.waitPlease(2);
        multipleSelectionSelect.selectByVisibleText("Java");
        BrowserUtils.waitPlease(2);
        multipleSelectionSelect.selectByVisibleText("JavaScript");
        BrowserUtils.waitPlease(2);


    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}









