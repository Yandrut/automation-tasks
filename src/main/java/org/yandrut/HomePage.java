package org.yandrut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Arrays;

public class HomePage {
    WebDriver driver;

    public HomePage (WebDriver driver) {
        this.driver = driver;
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
    public boolean elementsPresent() {
          WebElement investors = driver.findElement(By.xpath("//a[text()='INVESTORS']"));
          WebElement cookiePolicy = driver.findElement(By.xpath("//a[text()='COOKIE POLICY']"));
          WebElement openSource = driver.findElement(By.xpath("//a[text()='OPEN SOURCE']"));
          WebElement privacyNotice = driver.findElement(By.xpath("//a[text()='APPLICANT PRIVACY NOTICE']"));
          WebElement privacyPolicy = driver.findElement(By.xpath("//a[text()='PRIVACY POLICY']"));
          WebElement webAccessibility = driver.findElement(By.xpath("//a[text()='WEB ACCESSIBILITY']"));

          List<WebElement> policyList = Arrays.asList(investors,cookiePolicy,openSource,privacyPolicy,privacyNotice,webAccessibility);
          int flag = 0;
          for (WebElement element : policyList) {
              if (element.isEnabled()) {
                  flag++;
              }
          }
        return flag == policyList.size();
    }

}
