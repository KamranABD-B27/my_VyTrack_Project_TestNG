package com.vytrack.tests;
/*
As a user, I want to access to Vehicle contracts pageAs a user, I want to access to Vehicle contracts page

AC1: Store managers and Sales managers access the Vehicle contracts page.
Expected URL: https://qa2.vytrack.com/entity/Extend_Entity_VehicleContract
Expected title: All - Vehicle Contract - Entities - System - Car - Entities - System

1.	Login as store or salesmanager
2.	Click the Vehicle contracts under the Fleet
3.	Verify managers can access the Vehicle contracts page


AC2: Drivers should NOT able to access the Vehicle contracts page, the app should display “You do not have permission to perform this action.”

1.	Login as drivers
2.	Click the Vehicle contracts under the Fleet
3.	Verify users see an error message: “You do not have permission to perform this action.”

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

public class US_TS2_64 {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void managers_access_vehicleContractsPg_T1 () {
        driver.get(ConfigurationReader.getProperty("env"));

        // Login: users are on the homepage
        WebElement userName = driver.findElement(By.id("prependedInput"));
        userName.sendKeys(ConfigurationReader.getProperty("salesManager1"));
        WebElement passwordInfo = driver.findElement(By.xpath("//input[@type='password']"));
        passwordInfo.sendKeys(ConfigurationReader.getProperty("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();
        BrowserUtils.sleep(3);
        // Click the Vehicle button under the Fleet module
        WebElement fleetBtn = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]"));
        fleetBtn.click();
        BrowserUtils.sleep(3);

        //Click the Vehicle contracts under the Fleet
        WebElement vehicleContracts = driver.findElement(By.xpath("(//ul[@class='dropdown-menu dropdown-menu-level-1 menu menu-level-1'])[2]/li[6]/a/span"));
        BrowserUtils.sleep(5);
        vehicleContracts.click();

        BrowserUtils.sleep(5);

        //Verify managers can access the Vehicle contracts page
        String actualVcTitlePg = driver.getTitle();
        BrowserUtils.sleep(3);
        Assert.assertEquals(actualVcTitlePg, "All - Vehicle Contract - Entities - System - Car - Entities - System");
    }

    @Test
    public void users_see_errorMessage_T2 () {

        driver.get(ConfigurationReader.getProperty("env"));

        // Login: users are on the homepage
        WebElement userName = driver.findElement(By.id("prependedInput"));
        userName.sendKeys(ConfigurationReader.getProperty("driver1"));
        WebElement passwordInfo = driver.findElement(By.xpath("//input[@type='password']"));
        passwordInfo.sendKeys(ConfigurationReader.getProperty("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();
        BrowserUtils.sleep(3);
        // Click the Vehicle button under the Fleet module
        WebElement fleetBtn = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]"));
        fleetBtn.click();
        BrowserUtils.sleep(3);

        //Click the Vehicle contracts under the Fleet
        WebElement vehicleContracts = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span"));
        BrowserUtils.sleep(5);
        vehicleContracts.click();

        BrowserUtils.sleep(5);

        //Verify users see an error message: “You do not have permission to perform this action.”
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"flash-messages\"]/div/div/div[2]/div"));

        String actualMessage = errorMessage.getText();
        Assert.assertEquals(actualMessage, "You do not have permission to perform this action.");

    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }
}
