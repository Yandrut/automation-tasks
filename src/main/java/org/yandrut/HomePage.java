package org.yandrut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    public HomePage (WebDriver driver) {
        this.driver = driver;
        driver.get("https://epam.com");
        driver.manage().window().maximize();
    }
    public static void main(String[] args) {
        // invoking methods
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getBackgroundColourAttribute() {
        WebElement colorSwitch = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[1]/header/div/div/section/div"));
        colorSwitch.click();
        WebElement body = driver.findElement(By.xpath("/html/body"));
        return body.getAttribute("class");
    }

    public String getUkrainianTitle() {
        WebElement languageOptions = driver.findElement(By.xpath("//button[@class='location-selector__button']"));
        languageOptions.click();
        WebElement selector = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[1]/header/div/div/ul/li[2]/div/nav/ul/li[6]/a"));
        selector.click();
        return driver.getTitle();
    }
}
