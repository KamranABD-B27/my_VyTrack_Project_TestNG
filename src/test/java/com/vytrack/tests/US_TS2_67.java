package com.vytrack.tests;

// As a user, I should be to select any vehicle from the Vehicle page(web-table)

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


public class US_TS2_67 {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void all_checkboxes_unchecked_T1 () throws InterruptedException {
        driver.get(ConfigurationReader.getProperty("env"));

        // Login: users are on the homepage
        WebElement userName = driver.findElement(By.id("prependedInput"));
        userName.sendKeys(ConfigurationReader.getProperty("storeManager1"));
        WebElement passwordInfo = driver.findElement(By.xpath("//input[@type='password']"));
        passwordInfo.sendKeys(ConfigurationReader.getProperty("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();
        BrowserUtils.sleep(3);

        // Click the Vehicle button under the Fleet module
        WebElement fleetBtn = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]"));
        fleetBtn.click();
        BrowserUtils.sleep(3);
        WebElement vehicleBtn = driver.findElement(By.xpath("//span[.='Vehicles']"));
        vehicleBtn.click();
        BrowserUtils.sleep(3);

        // Verify if all the checkboxes are unchecked once the user launched to the Vehicle page
        WebElement allCheckboxBtn = driver.findElement(By.xpath("//button[@class='btn btn-default btn-small dropdown-toggle']/input"));
        Thread.sleep(3000);
        Assert.assertFalse(allCheckboxBtn.isSelected(), "all checkboxes are not unchecked");
        BrowserUtils.sleep(5);
    }

    @Test
    public void check_firstCheckbox_checkAllCars_T2 () {
        driver.get(ConfigurationReader.getProperty("env"));

        // Login: users are on the homepage
        WebElement userName = driver.findElement(By.id("prependedInput"));
        userName.sendKeys(ConfigurationReader.getProperty("storeManager1"));
        WebElement passwordInfo = driver.findElement(By.xpath("//input[@type='password']"));
        passwordInfo.sendKeys(ConfigurationReader.getProperty("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();
        BrowserUtils.sleep(3);

        // Click the Vehicle button under the Fleet module
        WebElement fleetBtn = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]"));
        fleetBtn.click();
        BrowserUtils.sleep(3);
        WebElement vehicleBtn = driver.findElement(By.xpath("//span[.='Vehicles']"));
        vehicleBtn.click();
        BrowserUtils.sleep(3);

        //Verify if users can check the first checkbox to check all the cars
        WebElement firstCheckboxBtn = driver.findElement(By.xpath("(//table//tbody//input[@type='checkbox'])[1]"));
        firstCheckboxBtn.click();

        for (int i = 1; i <=25; i++) {
            WebElement eachCheckboxBtn = driver.findElement(By.xpath("(//table//tbody//input)"));
            Assert.assertTrue(eachCheckboxBtn.isSelected());
            BrowserUtils.sleep(3);
        }

    }

    @Test
    public void check_anyCarsCheckbox_T3 () {
        driver.get(ConfigurationReader.getProperty("env"));

        // Login: users are on the homepage
        WebElement userName = driver.findElement(By.id("prependedInput"));
        userName.sendKeys(ConfigurationReader.getProperty("storeManager1"));
        WebElement passwordInfo = driver.findElement(By.xpath("//input[@type='password']"));
        passwordInfo.sendKeys(ConfigurationReader.getProperty("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();
        BrowserUtils.sleep(3);

        // Click the Vehicle button under the Fleet module
        WebElement fleetBtn = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]"));
        fleetBtn.click();
        BrowserUtils.sleep(3);
        WebElement vehicleBtn = driver.findElement(By.xpath("//span[.='Vehicles']"));
        vehicleBtn.click();
        BrowserUtils.sleep(3);

        //Verify if users can check any car’s checkbox
        WebElement anyCarCheckboxBtn = driver.findElement(By.xpath("(//input[@tabindex='-1'])[6]"));
        anyCarCheckboxBtn.click();
        Assert.assertTrue(anyCarCheckboxBtn.isSelected(), "any check box is not checked");
        BrowserUtils.sleep(3);

    }

    @Test
    public void all_checkboxes_unchecked_T4 () throws InterruptedException {
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
        WebElement vehicleBtn = driver.findElement(By.xpath("//span[.='Vehicles']"));
        vehicleBtn.click();
        BrowserUtils.sleep(3);

        // Verify if all the checkboxes are unchecked once the user launched to the Vehicle page
        WebElement allCheckboxBtn = driver.findElement(By.xpath("//button[@class='btn btn-default btn-small dropdown-toggle']/input"));
        Thread.sleep(3000);
        Assert.assertFalse(allCheckboxBtn.isSelected(), "all checkboxes are not unchecked");
        BrowserUtils.sleep(5);
    }

    @Test
    public void check_firstCheckbox_checkAllCars_T5 () {
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
        WebElement vehicleBtn = driver.findElement(By.xpath("//span[.='Vehicles']"));
        vehicleBtn.click();
        BrowserUtils.sleep(3);

        //Verify if users can check the first checkbox to check all the cars
        WebElement firstCheckboxBtn = driver.findElement(By.xpath("(//table//tbody//input[@type='checkbox'])[1]"));
        firstCheckboxBtn.click();

        for (int i = 1; i <=25; i++) {
            WebElement eachCheckboxBtn = driver.findElement(By.xpath("(//table//tbody//input)"));
            Assert.assertTrue(eachCheckboxBtn.isSelected());
            BrowserUtils.sleep(3);
        }

    }

    @Test
    public void check_anyCarsCheckbox_T6 () {
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
        WebElement vehicleBtn = driver.findElement(By.xpath("//span[.='Vehicles']"));
        vehicleBtn.click();
        BrowserUtils.sleep(3);

        //Verify if users can check any car’s checkbox
        WebElement anyCarCheckboxBtn = driver.findElement(By.xpath("(//input[@tabindex='-1'])[6]"));
        anyCarCheckboxBtn.click();
        Assert.assertTrue(anyCarCheckboxBtn.isSelected(), "any check box is not checked");
        BrowserUtils.sleep(3);

    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();

    }
}