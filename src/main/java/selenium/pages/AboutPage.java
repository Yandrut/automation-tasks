package selenium.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static selenium.DriverWaiter.waitForElementToBeClickable;

public class AboutPage {
    private final WebDriver driver;
    private static final Logger logger = LogManager.getLogger(ContactPage.class);

    public AboutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openURL (String url) {
        logger.info("Open URL");
        driver.get(url);
    }

    public void clickOnLogo() {
        WebElement logo = driver.findElement(By.xpath("//img[@class='header__logo header__logo-placeholder']/.."));
        waitForElementToBeClickable(logo);
        logo.click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}