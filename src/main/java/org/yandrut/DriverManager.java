package org.yandrut;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    static WebDriver getDriver () {
        System.setProperty("webdriver.chrome.driver", "/home/digital/Завантаження/chromedriver_linux64/chromedriver");
        return new ChromeDriver();
    }
}
