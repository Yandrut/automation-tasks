package org.yandrut;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import selenium.DriverProvider;
import selenium.pages.HomePage;

public class BaseTest {

    @BeforeMethod
    public void openBrowser() {
        WebDriver driver = DriverProvider.getInstance();
        driver.get("https://epam.com");
    }

    @AfterMethod
    public void closeBrowser() {
        DriverProvider.quit();
    }
}
