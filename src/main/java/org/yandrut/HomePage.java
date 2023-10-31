package org.yandrut;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver = DriverManager.getDriver();


    public static void main(String[] args) {
        HomePage page = new HomePage();
        page.changeToLightTheme();
    }

    public String getTitle () {
        driver.get("https://epam.com");
        return driver.getTitle();
    }

    public  void changeToLightTheme () {
        driver.get("https://epam.com");
        WebElement themeSwitch = driver.findElement(By.xpath("//div[@class='theme-switcher']"));
        themeSwitch.click();
    }
}
