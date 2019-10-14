package com.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTableHandling {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://money.rediff.com/gainers/bse/daily/groupa");


        // TO PRINT ALL THE TABLE
        WebElement table= driver.findElement(By.className("dataTable"));
    //    System.out.println(table.getText());

        // TO PRINT ALL HEADERS
        WebElement header =driver.findElement(By.xpath("//table//thead"));
        System.out.println(header.getText());

        // FIND THE ROW NUMBER

        String rlocater = "table[class='dataTable'] tbody tr";
        List<WebElement> rows = driver.findElements(By.cssSelector(rlocater));
        System.out.println(rows.size());        //279
 //     Assert.assertEquals(rows.size(), 279);


        // DISPLAY SPECIFIC ROW
        System.out.println(rows.get(7).getText());

        // FIND THE COLUMN NUMBER
        String clocator = "table[class='dataTable'] thead th";
        List<WebElement> colums = driver.findElements(By.cssSelector(clocator));
        System.out.println(colums.size());

        // DISPLAY A CELL
        String cell = driver.findElement(By.xpath("//table//tbody//tr[3]//td[4]")).getText();
        System.out.println(cell);
        //Assert.assertEquals(actual, expected);

        // FIND THE SUM OF A COLUMN
        //I want to get the sum of column 3     => 1,046.80

        double sum =0;
        int count = table.findElements(By.xpath("//table[@class='dataTable']//tbody//tr//td[3]")).size();

        for(int i=1; i<=count;i++){
            String value1 = table.findElement(By.xpath("//table[@class='dataTable']//tbody//tr["+i+"]//td[3]")).getText().replace(",","").replace(".","");
            Integer num = Integer.parseInt(value1);
            sum += num;
        }
        System.out.println(sum/100);

        sum=0;
        for(int i=0; i<count; i++){
            String value2 = table.findElements(By.xpath("//table[@class='dataTable']//tbody//tr//td[3]")).get(i).getText().replace(",","").replace(".","");
            Integer num = Integer.parseInt(value2);
            sum += num;
        }
        System.out.println(sum/100);
        driver.quit();
    }
}
