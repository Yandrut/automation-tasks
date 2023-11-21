package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.DriverWaiter;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getBackgroundColourAttribute() {
        WebElement colorSwitch = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[1]/header/div/div/section/div"));
        DriverWaiter.waitForElementToBeClickable(colorSwitch);
        colorSwitch.click();
        return driver.findElement(By.xpath("/html/body")).getAttribute("class");
    }

    public String getUkrainianTitle() {
        WebElement languageOptions = driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/div[1]/header/div/div/ul/li[2]/div/div/button"));
        DriverWaiter.waitForElementToBeClickable(languageOptions);
        languageOptions.click();
        WebElement selector = driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/div[1]/header/div/div/ul/li[2]/div/nav/ul/li[6]/a"));
        DriverWaiter.waitForElementToBeClickable(selector);
        selector.click();
        return driver.getTitle();
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
            System.out.println(location.getText());
            DriverWaiter.waitForElementToBeClickable(location);
            location.click();
        }
    }

    public boolean isResultPresent() {
        WebElement searchIcon = driver.findElement(By.xpath("//div[@class='header-search-ui header-search-ui-23 header__control']"));
        searchIcon.click();
        WebElement input = driver.findElement(By.xpath("//input[@id='new_form_search']"));
        input.sendKeys("AI", Keys.ENTER);
        WebElement searchResult = driver.findElement(By.xpath("//h2[@tabindex='0']"));

        //if attribute contains "hidden", no results are displayed
        String noResultsPresent = "search-results__counter hidden";
        return (!searchResult.getAttribute("class").equals(noResultsPresent));
    }

    public boolean requiredFieldsValidated() {
        driver.get("https://www.epam.com/about/who-we-are/contact");
        int flag = 0;
        List<WebElement> requiredList = driver.findElements(By.xpath("//input[@aria-required='true']"));

        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));

        DriverWaiter.waitForElementToBeClickable(submit);
        submit.submit();
        for (WebElement input : requiredList) {
            String validator = input.getAttribute("aria-invalid");
            if (validator.equals("true")) {
                flag++;
            }
        }
        return flag == requiredList.size();
    }

    public void openURL (String url) {
        driver.get(url);
    }
    public String getLogoClickUrl() {
        WebElement logo = driver.findElement(By.xpath("//img[@class='header__logo header__logo-placeholder']/.."));
        DriverWaiter.waitForElementToBeClickable(logo);
        logo.click();
        return driver.getCurrentUrl();
    }
}