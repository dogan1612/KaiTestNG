package com.Practice.Select_Class;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectPractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("https://www.wikipedia.org/");
        driver.findElement(By.id("searchLanguage")).sendKeys("TR");

        WebElement dropDown = driver.findElement(By.id("searchLanguage"));
        Select select = new Select(dropDown);
        select.selectByValue("uz");
        Thread.sleep(2000);
        select.selectByVisibleText("Русский");

        List<WebElement> list = select.getOptions();
        int listSize = list.size();

        for(int i =0; i < listSize ; i++){
            String opt = select.getOptions().get(i).getText();	    // Storing the value of the option
            if(opt.equals("Azərbaycanca")){                         // az will not work. az is value. we use text
                select.selectByIndex(i);
                break;
            }
        }

        // <option value="da" lang="da">Dansk</option>
        List<WebElement> values = driver.findElements(By.tagName("option"));     // This is what all options have in common
        System.out.println("Total number of options: " + values.size());
        System.out.println(values.get(7).getText());        // Dansk

        for(int i=0; i<values.size();i++){
            System.out.println(values.get(i).getAttribute("lang"));
        }
    }
}
