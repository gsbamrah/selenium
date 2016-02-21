package com.training.chapter2;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import  org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;


/**
 * Created by gurpreet on 4/1/16.
 * If you don't mention the priority, it will take all the test cases as "priority=0"
 * Elements Gets Cached Always Clear Cookie Before Executing the test  case
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
        driver.navigate().to("http://gsbamrah.github.io");
        driver.findElement(By.id("prac-form"));
        driver.navigate().back();
        driver.navigate().forward();

        driver.navigate().refresh();
    }

    @Test(priority=2)
    public void enterText() {
        WebElement namefirst=driver.findElement(By.name("firstname"));
       namefirst.sendKeys("gurpreet");
        WebElement namelast=driver.findElement(By.name("lastname"));
        namelast.sendKeys("singh");
    }

    @Test
    public void clearText() {
        driver.findElement(By.id("")).clear();
    }

    @Test(priority=1)
    public void clickButton()
    {
        driver.manage().window().maximize();
        driver.get("http://gsbamrah.github.io");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement Element=driver.findElement(By.id("prac-form"));
        Element.click();
        WebElement Element2=driver.findElement(By.linkText("Forms"));
        Element2.click();
        String verifyurl=driver.getCurrentUrl();
        Assert.assertTrue(verifyurl.contains("form.html"));
        enterText();
        selectfromDropDown();
        playwithcheck();
        SelectMultipleCheckbox();
        driver.close();

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
        Actions builder = new Actions(driver);
        WebElement source = driver.findElement(By.id(""));
        WebElement target = driver.findElement(By.id(""));
        // DragAndDrop(source,target);
    }

        @Test
            public  void moveToElement() {
            driver.get("http://gsbamrah.github.io");
            WebElement Element = driver.findElement(By.id("prac-form"));
            Actions builder = new Actions(driver);
            builder.moveToElement(Element).perform();
        }

        @Test
                public void MaximizeWindow()
        {
                driver.manage().window().maximize();
            }

    @Test
    public void selectfromDropDown() {
        WebElement element = driver.findElement(By.name("Country"));
        Select sl = new Select(element);
          sl.selectByValue("Australlia");
    }
        /*
        List<WebElement> options=driver.findElements(By.tagName("Country"));

        for(WebElement option:options)
        {
       option.click();
    }
*/

    @Test
    public void playwithcheck()
    {
        WebElement element =driver.findElement(By.xpath("//input[@name='vehicle1']"));
        element.click();

    }

    @Test
    public void SelectMultipleCheckbox()
    {
        List<WebElement> els = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for ( WebElement el : els ) {
            if ( !el.isSelected() ) {
                el.click();
            }
        }
    }
    }
