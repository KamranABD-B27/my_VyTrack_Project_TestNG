package com.vytrack.tests;
/*
As a user, I want to learn how to use the pinbar

AC1: when users click click the “Learn how to use this space” link on the homepage, users should see:
“How To Use Pinbar”  and
“Use the pin icon on the right top corner of the page to create fast access link in the pinbar.”

TC1: Verify user can see and click the pinbar successfully

1.	Users are on the homepage
2.	Click the Learn how to use this space message
3.	Verify the users see 2 messages:
“How To Use Pinbar”  and
“Use the pin icon on the right top corner of the page to create fast access link in the pinbar.”


AC2: users should see an image on the page.
[in automation testing,  just verify the image source.]
Expected source:
/bundles/oronavigation/images/pinbar-location.jpg

TC2: Verify users can create the pinbar successfully

1.	Users are on the homepage
2.	Click the Learn how to use this space message
3.	Verify users see an image
(manual testing - screenshot proof
Automation testing - verify image source)

 */

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US_TS2_63 {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void see_TwoMessages_T1 () {
        driver.get(ConfigurationReader.getProperty("env"));

        // Login: users are on the homepage

        WebElement userName = driver.findElement(By.id("prependedInput"));
        userName.sendKeys(ConfigurationReader.getProperty("driver1"));
        WebElement passwordInfo = driver.findElement(By.xpath("//input[@type='password']"));
        passwordInfo.sendKeys(ConfigurationReader.getProperty("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();

        //Click the Learn how to use this space message
        WebElement learnLinkMessage = driver.findElement(By.xpath("//div[@class='pin-bar-empty']/a"));
        BrowserUtils.sleep(3);
        learnLinkMessage.click();

        //Verify the users see 2 messages:
        WebElement message1 = driver.findElement(By.xpath("//div[@class='clearfix']//h3"));
        Assert.assertEquals(message1.getText(), "How To Use Pinbar");
        WebElement message2 = driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/p[1]"));
        Assert.assertEquals(message2.getText(), "Use the pin icon on the right top corner of the page to create fast access link in the pinbar.");

        // T1 - BUG FOUND!:
        // Expected:Use the pin icon on the right top corner of the page to create fast access link in the pinbar.
        // Actual:Use pin icon on the right top corner of page to create fast access link in the pinbar.

    }
    @Test
    public void seeAnImage_T2 () {
        driver.get(ConfigurationReader.getProperty("env"));

        // Login: users are on the homepage
        WebElement userName = driver.findElement(By.id("prependedInput"));
        userName.sendKeys(ConfigurationReader.getProperty("driver1"));
        WebElement passwordInfo = driver.findElement(By.xpath("//input[@type='password']"));
        passwordInfo.sendKeys(ConfigurationReader.getProperty("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();

        //Click the Learn how to use this space message
        WebElement learnLinkMessage = driver.findElement(By.xpath("//div[@class='pin-bar-empty']/a"));
        BrowserUtils.sleep(3);
        learnLinkMessage.click();

        //Verify users see an image
        WebElement image = driver.findElement(By.xpath("//div[@class='container-fluid']//p[2]/img"));
        String actualImageText = image.getAttribute("src");
        String expectedImageText = "/bundles/oronavigation/images/pinbar-location.jpg";
        BrowserUtils.sleep(3);
        Assert.assertTrue(actualImageText.contains(expectedImageText));
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();

    }
}

