package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class DriverFactory {
    private static WebDriver driver;

    private DriverFactory() {}

    public static WebDriver getDriver(String driverName) {
        if (driverName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (driverName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (driverName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Invalid name of the driver");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

//
//    public static WebDriver getInstance() {
//          if (driver == null) {
//              System.setProperty("webdriver.chrome.driver",
//                      "/home/digital/Завантаження/chromedriver_linux64/chromedriver");
//              driver = new ChromeDriver();
//        }
//        return driver;
//    }
}