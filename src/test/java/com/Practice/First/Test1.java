package com.Practice.First;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement emailInputBox = driver.findElement(By.name("email"));
        WebElement submitButton = driver.findElement(By.id("form_submit"));
     // emailInputBox.sendKeys("email@gmail.com");
        Faker faker = new Faker();
        emailInputBox.sendKeys(faker.internet().emailAddress());

        Thread.sleep(1500);
     // submitButton.submit(); // it work only with buttons. Click method is more flexible.
        submitButton.click();
        Thread.sleep(1500);





        //let's find confirmation message and verify it
        WebElement confirmationMessage = driver.findElement(By.name("confirmation_message"));
        String actualMessage = confirmationMessage.getText(); // how to get text of element
        String expectedMessage = "Your e-mail's been sent!";

        if(actualMessage.equals(expectedMessage)){
            System.out.println("Test passed");
        }else {
            System.out.println("Test failed");
            System.out.println("Expected message: "+expectedMessage);
            System.out.println("Actual message: "+actualMessage);
        }


        driver.close();
    }
}
