package com.vytrack.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BrowserUtils {

    public static void sleep(int seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Exception happened in sleep method!");
        }
    }


    public static void verifyTitle(WebDriver driver, String expectedTitle) {
        String actualTile = driver.getTitle();
        Assert.assertEquals(actualTile, expectedTitle);
    }

}
