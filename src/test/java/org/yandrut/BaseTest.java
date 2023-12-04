package org.yandrut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import selenium.DriverProvider;

public class BaseTest {

    @BeforeMethod
    public void openBrowser() {
        WebDriver driver = DriverProvider.getInstance();
        driver.get("https://epam.com");
        // click on accept cookies button
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    @AfterMethod
    public void closeBrowser() {
        DriverProvider.quit();
    }
}
