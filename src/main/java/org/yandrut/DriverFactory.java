package org.yandrut;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static final WebDriver driver = new ChromeDriver();

    public static WebDriver getInstance() {
          if (driver == null) {
            WebDriverManager.chromedriver().setup();
        }
        return driver;
    }
}
