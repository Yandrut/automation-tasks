package org.yandrut;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getInstance() {
          if (driver == null) {
              System.setProperty("webdriver.chrome.driver",
                      "/home/digital/Завантаження/chromedriver_linux64/chromedriver");
              driver = new ChromeDriver();
        }
        return driver;
    }

    public static void closeBrowser() {
        driver.quit();
    }
}