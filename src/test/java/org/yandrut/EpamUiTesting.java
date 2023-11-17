package org.yandrut;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.*;

public class EpamUiTesting {
    public HomePage page;
    public WebDriver driver;

          // invoking methods
  @BeforeMethod
    public void openBrowser() {
        driver = DriverFactory.getInstance();
        page = new HomePage(driver);
        driver.get("https://epam.com");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeBrowser() {
        DriverFactory.closeBrowser();
    }

    @Test
    public void titleComparison() {
        String actual = page.getTitle();
        String expected = "EPAM | Software Engineering & Product Development Services";
        assertEquals(expected, actual);
    }

    @Test
    public void lightThemeChanged() {
        String expected = "fonts-loaded header--anima148ted dark-mode";
        String actual = page.getBackgroundColourAttribute();
        assertNotSame(expected, actual);
    }

    @Test
    public void languageChanged() {
        String expected = "EPAM Ukraine - найбільша ІТ-компанія в Україні | Вакансії";
        String actual = page.getUkrainianTitle();
        assertEquals(expected, actual);
    }

    @Test
    public void policiesItemsPresent() {
        List<String> expected = Arrays.asList("INVESTORS",
                "OPEN SOURCE", "PRIVACY POLICY", "COOKIE POLICY",
                "APPLICANT PRIVACY NOTICE", "WEB ACCESSIBILITY");
        List<String> actual = page.getPoliciesList();
        assertEquals(expected, actual);
    }

    @Test
    public void locationsItemsPresent() {
      List <String> expected = Arrays.asList("AMERICAS", "EMEA", "APAC");
      List <String> actual = page.getLocationsList();
      assertEquals(expected, actual);
    }

    @Test
    public void switchesLocations() {
      Assertions.assertAll(() -> page.switchLocations());
    }

    @Test
    public void searchResultsDisplayed() {
      assertTrue(page.isResultPresent());
    }
    
    @Test 
    public void fieldsValidated() {
      assertTrue(page.requiredFieldsValidated());
    }

    @Test
    public void logoClickUrlMatches() {
      String expected = "https://www.epam.com/";
      String actual = page.getLogoClickUrl();
      assertEquals(expected, actual);
    }
}
