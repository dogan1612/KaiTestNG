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

    /////////////////////// *** \\\\\\\\\\\\\\\\\\\\\\\

        driver.get("https://www.facebook.com");
        WebElement monthDB = driver.findElement(By.xpath("//select[@aria-label='Month']"));

        Select month = new Select(monthDB);
        month.selectByIndex(5);
                Thread.sleep(1000);
        month.selectByValue("11");
                Thread.sleep(1000);
        month.selectByVisibleText("Sep");

        List<WebElement>  list1 = month.getOptions();
        WebElement september= list1.get(9);
        System.out.println( september.isSelected() );

    /////////////////////// *** \\\\\\\\\\\\\\\\\\\\\\\

        WebElement yearDB =driver.findElement(By.name("birthday_year"));
        Select year = new Select(yearDB);
        year.selectByVisibleText("1909");
            Thread.sleep(1000);
        List<WebElement> list3 =  year.getOptions();
        WebElement Y1909 =null;

        for(WebElement each :list3) {
            if (each.getText().equals("1909")) {
                Y1909 = each;
                break;
            }
        }
        System.out.println( Y1909.isSelected() );
    }
}
