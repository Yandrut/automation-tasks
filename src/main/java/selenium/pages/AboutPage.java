package selenium.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.awaitility.Awaitility;
import org.awaitility.core.ConditionTimeoutException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import static selenium.DriverWaiter.*;

public class AboutPage {
    private final WebDriver driver;
    private static final Logger logger = LogManager.getLogger(ContactPage.class);

    public AboutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openURL(String url) {
        logger.info("Open URL: " + url);
        driver.get(url);
    }

    public void clickOnLogo() {
        logger.info("Click on logo");
        WebElement logo = driver.findElement(By.xpath("//img[@class='header__logo header__logo-placeholder']/.."));
        waitForElementToBeClickable(logo);
        logo.click();
    }

    public String getCurrentUrl() {
        logger.info("Get current URL");
        return driver.getCurrentUrl();
    }

    public void clickOnDownloadButton() {
        logger.info("Click on download button");
        Actions action = new Actions(driver);
        WebElement downloadButton = driver.findElement(By.xpath("//*[@id='main']/div[1]/div[5]/section/div[2]/div/div/div[1]/div/div[3]/div/a"));
        action.moveToElement(downloadButton).perform();
        downloadButton.click();
    }

    public boolean isFileDownloadedWithTimeout(String filePath, Duration duration) {
        logger.info("Wait for file to be downloaded");

        try {
            Awaitility.await("Wait until file is downloaded")
                    .atMost(duration)
                    .pollInterval(Duration.ofSeconds(2))
                    .until(() -> isFileDownloaded(filePath));
            logger.info("File downloaded successfully");
            return true;
        } catch (ConditionTimeoutException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isFileDownloaded(String filePath) {
        Path path = Paths.get(filePath);
        return Files.exists(path);
    }
}