package org.yandrut;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage {
    WebDriver driver;

    public HomePage (WebDriver driver) {
        this.driver = driver;
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
        WebElement languageOptions = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[1]/header/div/div/ul/li[2]/div/div/button"));
        languageOptions.click();
        WebElement selector = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[1]/header/div/div/ul/li[2]/div/nav/ul/li[6]/a"));
        selector.click();
        return driver.getTitle();
    }

    public List<String> getPoliciesList() {
         List <WebElement> policies = driver.findElements(By.xpath("//div[@class='policies']//a"));
        return policies.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getLocationsList() {
        List <WebElement> locations = driver.findElements(By.xpath("//div[@class='tabs-23__ul-wrapper']//a"));
            return locations.stream().map(WebElement::getText).collect(Collectors.toList());
    }
    public void switchLocations() {
        List <WebElement> locations = driver.findElements(By.xpath("//div[@class='tabs-23__title js-tabs-title']"));
        for (WebElement element : locations) {
            System.out.println(element.getText());
            element.click();
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
}