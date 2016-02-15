package com.training.chapter2;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import  org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;



/**
 * Created by gurpreet on 4/1/16.
 */
public class SeleniumMethods {

    WebDriver driver = new FirefoxDriver();
    // URL Methods


    @Test
    public void getURl() {
        driver.get("http://www.google.com");
        driver.close();
    }

    @Test
    public void Navigate() {
        driver.navigate().to("http://www.google.com");
        driver.close();
    }

    @Test
    public void navigateForward() {
        driver.navigate().to("");
        driver.navigate().forward();
        driver.navigate().back();
        driver.navigate().refresh();
    }

    @Test
    public void enterText() {
        driver.findElement(By.id("")).sendKeys();
    }

    @Test
    public void clearText() {
        driver.findElement(By.id("")).clear();
    }

    @Test
    public void clickButton() {
        driver.findElement(By.id("")).click();
    }

    @Test
    public void elementEnabledOrNot() {
        driver.findElement(By.id("")).isEnabled();
    }

    @Test
    public void handlingAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
       // alert.dismiss();

    }

    @Test
    public void DragAndDrop() {
        Actions builder=new Actions(driver);
    WebElement source=driver.findElement(By.id(""));
    WebElement target=driver.findElement(By.id(""));
       // DragAndDrop(source,target);


    }
}