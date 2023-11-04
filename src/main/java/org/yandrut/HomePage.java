package org.yandrut;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    public HomePage() {
        driver = DriverFactory.getInstance();
    }

    public static void main(String[] args) {
        HomePage page = new HomePage();
        page.changeToLightTheme();
        page.changeLanguageToUA();
    }

    public String getTitle() {
        driver.manage().window().maximize();
        driver.get("https://epam.com");
        return driver.getTitle();
    }

    public void changeToLightTheme() {
        driver.manage().window().maximize();
        driver.get("https://epam.com");
        WebElement colorSwitch = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[1]/header/div/div/section/div"));
        colorSwitch.click();
    }

    public void changeLanguageToUA() {
        driver.manage().window().maximize();
        driver.get("https://epam.com");
        WebElement languageOptions = driver.findElement(By.xpath("//button[@class='location-selector__button']"));
        languageOptions.click();
        WebElement selector = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[1]/header/div/div/ul/li[2]/div/nav/ul/li[6]/a"));
        selector.sendKeys(Keys.ENTER);
    }
}
