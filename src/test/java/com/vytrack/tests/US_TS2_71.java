package com.vytrack.tests;

//As a user, I want to view car odometer info on the Vehicles Odometers page
/*
Test cases #1
manager can NOT access the Vehicle Odometer
Steps:
1.	Log in as store or sales managers
2.	Click the “Vehicle Odometers” under the Fleet
3.	Verify the managers see “You do not have permission to perform this action.”
//AC1: Store and Sales managers should see an error message “You do not have permission to perform this action.” when they click the “Vehicle Odometer” module.

Test cases #2
Description:  Drivers should see the default page number as 1
Steps:
1.	Log in as drivers
2.	Click the “Vehicle Odometers” under the Fleet
3.	Verify the default page number is 1
//AC2: Drivers should see the default page as 1.

Test cases #3
Description:   Divers should see the View Per Page is 25 by default.
Steps:
1.	Log in as drivers
2.	Click the “Vehicle Odometers” under the Fleet
3.	Verify the default view per page is 25
//AC3: Divers should see the View Per Page is 25 by default.
 */


import com.google.common.base.Verify;
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

import javax.swing.text.View;
import java.util.concurrent.TimeUnit;

public class US_TS2_71 {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void managers_see_errorMsg_T1() {
        driver.get(ConfigurationReader.getProperty("env"));

        //Log in as store or sales managers
        WebElement userName = driver.findElement(By.id("prependedInput"));
        userName.sendKeys(ConfigurationReader.getProperty("storeManager1"));
        WebElement passwordInfo = driver.findElement(By.xpath("//input[@type='password']"));
        passwordInfo.sendKeys(ConfigurationReader.getProperty("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();
        BrowserUtils.sleep(3);


        WebElement fleetBtn = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
        fleetBtn.click();
        //Click the “Vehicle Odometers” under the Fleet
        WebElement odometerBtn = driver.findElement(By.xpath("//span[.='Vehicle Odometer']"));
        BrowserUtils.sleep(3);
        odometerBtn.click();

        //Verify the managers see Error message
        WebElement errorMsg = driver.findElement(By.xpath("//div[.='You do not have permission to perform this action.']"));
        BrowserUtils.sleep(3);
        Assert.assertTrue(errorMsg.isDisplayed(), "You do not have permission to perform this action.”");

    }

    @Test(priority = 2)
    public void drivers_see_defaultPageAs1_T2() {
        driver.get(ConfigurationReader.getProperty("env"));

        //Log in as drivers
        WebElement userName = driver.findElement(By.id("prependedInput"));
        userName.sendKeys(ConfigurationReader.getProperty("driver1"));
        WebElement passwordInfo = driver.findElement(By.xpath("//input[@type='password']"));
        passwordInfo.sendKeys(ConfigurationReader.getProperty("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();
        BrowserUtils.sleep(3);

        //Click the “Vehicle Odometers” under the Fleet
        WebElement fleetBtn = driver.findElement(By.xpath("//span[@class='title title-level-1'][normalize-space()='Fleet']"));
        fleetBtn.click();
        WebElement odometerBtn = driver.findElement(By.xpath("//span[.='Vehicle Odometer']"));
        BrowserUtils.sleep(3);
        odometerBtn.click();

        //Drivers should see the default page as 1
        WebElement defaultPage1 = driver.findElement(By.xpath("//input[@value='1']"));
        BrowserUtils.sleep(3);

        Assert.assertTrue(defaultPage1.isDisplayed(), "the default page is not displayed");
    }

    @Test(priority = 3)
    public void drivers_see_ViewPerPg25ByDefault_T3() {
        driver.get(ConfigurationReader.getProperty("env"));

        //Log in as drivers
        WebElement userName = driver.findElement(By.id("prependedInput"));
        userName.sendKeys(ConfigurationReader.getProperty("driver1"));
        WebElement passwordInfo = driver.findElement(By.xpath("//input[@type='password']"));
        passwordInfo.sendKeys(ConfigurationReader.getProperty("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();
        BrowserUtils.sleep(3);

        //Click the “Vehicle Odometers” under the Fleet
        WebElement fleetBtn = driver.findElement(By.xpath("//span[@class='title title-level-1'][normalize-space()='Fleet']"));
        fleetBtn.click();
        WebElement odometerBtn = driver.findElement(By.xpath("//span[.='Vehicle Odometer']"));
        BrowserUtils.sleep(3);
        odometerBtn.click();

        //Divers should see the View Per Page is 25 by default.
        WebElement viewPg25ByDefault = driver.findElement(By.xpath("//button[contains(@class,'btn dropdown-toggle')]"));

        Assert.assertTrue(viewPg25ByDefault.isDisplayed(), "the view page 25 is not displayed by default");

    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();

    }
}