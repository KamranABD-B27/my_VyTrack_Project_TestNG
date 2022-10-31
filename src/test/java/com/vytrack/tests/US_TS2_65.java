package com.vytrack.tests;

/*
As a user, I want to view columns on the Vehicle models page.(web-table)

T1 --> Manager has access the Vehicle models

1.	Login as store and sales managers
2.	Click the Vehicle Model under the Fleet
3.	Verify managers see 10 columns in the web-table

AC #1: The store manager and sales manager should see 10 columns on the Vehicle Model page.
   MODEL NAME, MAKE, CAN BE REQUESTED, CVVI, CO2 FEE (/MONTH), COST (DEPRECIATED), TOTAL COST (DEPRECIATED), CO2 EMISSIONS, FUEL TYPE, VENDORS

T2 --> Drivers can NOT access the Vehicle models page

1.	Login as store and sales managers
2.	Click the Vehicle Model under the Fleet
3.	Verify the drivers see the error message “You do not have permission to perform this action.”

 AC #2: Drivers should not able to access the Vehicle Model page, users should see “You do not have permission to perform this action.”

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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class US_TS2_65 {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test (priority = 1)
    public void manager_access_VehicleModels_T1() {
        driver.get(ConfigurationReader.getProperty("env"));

        // Login: users are on the homepage
        WebElement userName = driver.findElement(By.id("prependedInput"));
        userName.sendKeys(ConfigurationReader.getProperty("storeManager1"));
        WebElement passwordInfo = driver.findElement(By.xpath("//input[@type='password']"));
        passwordInfo.sendKeys(ConfigurationReader.getProperty("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();
        BrowserUtils.sleep(3);

        //Click the Vehicle Model under the Fleet
        WebElement fleetBtn = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
        fleetBtn.click();
        WebElement vehicleModelBtn = driver.findElement(By.xpath("//span[.='Vehicles Model']"));
        vehicleModelBtn.click();


        //Verify managers see 10 columns in the web-table
        WebElement modelName = driver.findElement(By.xpath("//span[@class='grid-header-cell__label'][normalize-space()='Model Name']"));
        Assert.assertEquals(modelName.getText(), "MODEL NAME", "column name is not matching");
        BrowserUtils.sleep(3);

        WebElement make = driver.findElement(By.xpath("//span[@class='grid-header-cell__label'][normalize-space()='Make']"));
        Assert.assertEquals(make.getText(), "MAKE", "column make is not matching");
        BrowserUtils.sleep(3);

        WebElement canBeRequested = driver.findElement(By.xpath("//span[@class='grid-header-cell__label'][normalize-space()='Can be requested']"));
        Assert.assertEquals(canBeRequested.getText(), "CAN BE REQUESTED", "column can be requested is not matching");
        BrowserUtils.sleep(3);

        WebElement CVVI = driver.findElement(By.xpath("//span[normalize-space()='CVVI']"));
        Assert.assertEquals(CVVI.getText(), "CVVI", "column CVVI is not matching");
        BrowserUtils.sleep(3);

        WebElement CO2_FeePerMonth = driver.findElement(By.xpath("//span[@class='grid-header-cell__label'][normalize-space()='CO2 Fee (/month)']"));
        Assert.assertEquals(CO2_FeePerMonth.getText(), "CO2 FEE (/MONTH)", "column CO2 FEE (/MONTH) is not matching");
        BrowserUtils.sleep(3);

        WebElement CostDepreciated = driver.findElement(By.xpath("//span[@class='grid-header-cell__label'][normalize-space()='Cost (Depreciated)']"));
        Assert.assertEquals(CostDepreciated.getText(), "COST (DEPRECIATED)", "COST (DEPRECIATED) is not matching");
        BrowserUtils.sleep(3);

        WebElement TotalCost_depreciated = driver.findElement(By.xpath("//span[@class='grid-header-cell__label'][normalize-space()='Total Cost (Depreciated)']"));
        Assert.assertEquals(TotalCost_depreciated.getText(), "TOTAL COST (DEPRECIATED)", "TOTAL COST (DEPRECIATED) is not matching");
        BrowserUtils.sleep(3);

        WebElement CO2Emissions = driver.findElement(By.xpath("//span[@class='grid-header-cell__label'][normalize-space()='CO2 Emissions']"));
        Assert.assertEquals(CO2Emissions.getText(), "CO2 EMISSIONS", "CO2 EMISSIONS is not matching");
        BrowserUtils.sleep(3);

        WebElement FuelType = driver.findElement(By.xpath("//span[@class='grid-header-cell__label'][normalize-space()='Fuel Type']"));
        Assert.assertEquals(FuelType.getText(), "FUEL TYPE", "FUEL TYPE is not matching");
        BrowserUtils.sleep(3);

        WebElement Vendors = driver.findElement(By.xpath("//span[@class='grid-header-cell__label'][normalize-space()='Vendors']"));
        Assert.assertEquals(Vendors.getText(), "VENDORS", "VENDORS is not matching");
        BrowserUtils.sleep(3);

    }

    @Test (priority = 2)
    public void driversCantAccess_vehicleModelsPg_T2() {
        driver.get(ConfigurationReader.getProperty("env"));

        // Login: users are on the homepage
        WebElement userName = driver.findElement(By.id("prependedInput"));
        userName.sendKeys(ConfigurationReader.getProperty("salesManager1"));
        WebElement passwordInfo = driver.findElement(By.xpath("//input[@type='password']"));
        passwordInfo.sendKeys(ConfigurationReader.getProperty("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();
        BrowserUtils.sleep(3);

        //Click the Vehicle Model under the Fleet
        WebElement fleetBtn = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
        fleetBtn.click();
        WebElement vehicleModelBtn = driver.findElement(By.xpath("//span[.='Vehicles Model']"));
        vehicleModelBtn.click();

        //Verify the drivers see the error message “You do not have permission to perform this action.”

        Assert.assertEquals(vehicleModelBtn.getText(), "“You do not have permission to perform this action.”");

        //BUG --> Drivers is able to access the Vehicle Model page and see no message - “You do not have permission to perform this action.”

    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();

    }
}

