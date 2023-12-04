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
        logger.info("Get title");
        return driver.getTitle();
    }

    public void clickOnColourSwitch() {
        logger.info("Click on colour switch");
        WebElement colorSwitch = driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/div[1]/header/div/div/section/div"));
        waitForElementToBeClickable(colorSwitch);
        colorSwitch.click();
    }

    public String getBackgroundColourAttribute() {
        logger.info("Get background colour attribute");
        return driver.findElement(By.xpath("/html/body")).getAttribute("class");
    }

    public void clickOnLanguageOptions() {
        logger.info("Click on language options");
        WebElement languageOptions = driver.findElement(By.xpath("//button[@class='location-selector__button']"));
        waitForElementToBeClickable(languageOptions);
        languageOptions.click();
    }

    public void switchLanguage(String language) {
        logger.info("Switch language to: " + language);
        List <WebElement> languages = driver.findElements(By.xpath("//a[@lang]"));

            for (WebElement element : languages) {
                if (element.getText().equalsIgnoreCase(language)) {
                    logger.info("Text: " + element.getText());
                    waitForElementToBeClickable(element);
                    element.click();
                    break;
                }
            }
        }

    public List<String> getPoliciesList() {
        logger.info("Get policies list");
        List<WebElement> policies = driver.findElements(By.xpath("//div[@class='policies']//a"));
        return policies.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<WebElement> getLocationsList(String cssSelector) {
        logger.info("Get locations list");
        return driver.findElements(By.cssSelector(cssSelector));
    }

    public List<String> getTextOfLocationsList(List<WebElement> locations) {
        logger.info("Get text of locations list");
        return locations.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void switchLocations(List <WebElement> locations) {
        logger.info("Switch locations");

        for (WebElement location : locations) {
            waitForElementToBeClickable(location);
            logger.info("Location: " + location.getText());
            location.click();
        }
    }

    public void clickOnSearchBar() {
        logger.info("Click on search bar");

        driver.findElement(By.xpath("//div[@class='header-search-ui header-search-ui-23 header__control']"))
                .click();
    }

    public void sendKeysToInput(String keysToSend) {
        logger.info("Send keys to input" + keysToSend);

        driver.findElement(By.xpath("//input[@id='new_form_search']"))
                .sendKeys(keysToSend,Keys.ENTER);
    }

    public String getSearchResultAttributeValue() {
        logger.info("Get search result attribute value");
        return driver.findElement(By.xpath("//h2[@tabindex='0']"))
                .getAttribute("class");
    }
}