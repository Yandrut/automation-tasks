package selenium.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static selenium.DriverWaiter.waitForElementToBeClickable;

public class ContactPage {
    private final WebDriver driver;
    private static final Logger logger = LogManager.getLogger(ContactPage.class);

    public ContactPage (WebDriver driver) {
        this.driver = driver;
    }

    public void openURL (String url) {
        logger.info("Open URL: " + url);
        driver.get(url);
    }

    public List<WebElement> getRequiredList() {
        logger.info("Get required list");
        return driver.findElements(By.xpath("//input[@aria-required='true']"));
    }

    public void clickOnSubmitButton() {
        logger.info("Click on submit button");
        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
        waitForElementToBeClickable(submit);
        submit.submit();
    }

    public boolean areFieldsValidated(List<WebElement> requiredFields) {
        logger.info("Are fields validated");
        int flag = 0;
        for (WebElement input : requiredFields) {
            String validator = input.getAttribute("aria-invalid");
            if (validator.equals("true")) {
                flag++;
            }
        }
        logger.info(flag + " fields validated out of " + requiredFields.size());
        return flag == requiredFields.size();
    }
}