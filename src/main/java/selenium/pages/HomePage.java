package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.logging.log4j.*;

import java.util.List;
import java.util.stream.Collectors;

import static selenium.DriverWaiter.waitForElementToBeClickable;

public class HomePage {
    private static final Logger logger = LogManager.getLogger(HomePage.class);
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        logger.info("Title of website: " + driver.getTitle());
        return driver.getTitle();
    }

    public void clickOnColourSwitch() {
        WebElement colorSwitch = driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/div[1]/header/div/div/section/div"));
        logger.info("color switch founded");
        waitForElementToBeClickable(colorSwitch);
        colorSwitch.click();
    }

    public String getBackgroundColourAttribute() {
        return driver.findElement(By.xpath("/html/body")).getAttribute("class");
    }

    public void clickOnLanguageOptions() {
        WebElement languageOptions = driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/div[1]/header/div/div/ul/li[2]/div/div/button"));
        waitForElementToBeClickable(languageOptions);
        languageOptions.click();
    }

    public void clickOnLanguageSelector() {
        WebElement selector = driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/div[1]/header/div/div/ul/li[2]/div/nav/ul/li[6]/a"));
        waitForElementToBeClickable(selector);
        selector.click();
    }

    public List<String> getPoliciesList() {
        List<WebElement> policies = driver.findElements(By.xpath("//div[@class='policies']//a"));
        return policies.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getLocationsList() {
        List<WebElement> locations = driver.findElements(By.xpath("//div[@class='tabs-23__ul-wrapper']//a"));
        return locations.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void switchLocations() {
        List<WebElement> locations = driver.findElements(By.cssSelector(".tabs-23__link.js-tabs-link:not(.active)"));

        for (WebElement location : locations) {
            waitForElementToBeClickable(location);
            logger.info("Location: " + location.getText());
            location.click();
        }
    }

    public void clickOnSearchBar () {
        driver.findElement(By.xpath("//div[@class='header-search-ui header-search-ui-23 header__control']"))
                .click();
        logger.info("Search bar");
    }

    public void sendKeysToInput(String keysToSend) {
        driver.findElement(By.xpath("//input[@id='new_form_search']"))
                .sendKeys(keysToSend,Keys.ENTER);
        logger.info("Keys sent: " + keysToSend);
    }

    public String getSearchResultAttributeValue() {
        return driver.findElement(By.xpath("//h2[@tabindex='0']"))
                .getAttribute("class");
    }
}