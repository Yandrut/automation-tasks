package org.yandrut;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import selenium.DriverProvider;
import selenium.pages.HomePage;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.*;

public class EpamUiTesting extends BaseTest {


    @Test
    public void titleComparison() {
        HomePage page = new HomePage(DriverProvider.getInstance());
        String actual = page.getTitle();
        String expected = "EPAM | Software Engineering & Product Development Services";
        assertEquals(expected, actual);
    }

    @Test
    public void lightThemeChanged() {
        HomePage page = new HomePage(DriverProvider.getInstance());
        String expected = "fonts-loaded header--anima148ted dark-mode";
        String actual = page.getBackgroundColourAttribute();
        assertNotSame(expected, actual);
    }

    @Test
    public void languageChanged() {
        HomePage page = new HomePage(DriverProvider.getInstance());
        String expected = "EPAM Ukraine - найбільша ІТ-компанія в Україні | Вакансії";
        String actual = page.getUkrainianTitle();
        assertEquals(expected, actual);
    }

    @Test
    public void policiesItemsPresent() {
        HomePage page = new HomePage(DriverProvider.getInstance());
        List<String> expected = Arrays.asList("INVESTORS",
                "OPEN SOURCE", "PRIVACY POLICY", "COOKIE POLICY",
                "APPLICANT PRIVACY NOTICE", "WEB ACCESSIBILITY");
        List<String> actual = page.getPoliciesList();
        assertEquals(expected, actual);
    }

    @Test
    public void locationsItemsPresent() {
        HomePage page = new HomePage(DriverProvider.getInstance());
      List <String> expected = Arrays.asList("AMERICAS", "EMEA", "APAC");
      List <String> actual = page.getLocationsList();
      assertEquals(expected, actual);
    }

    @Test
    public void switchesLocations() {
        HomePage page = new HomePage(DriverProvider.getInstance());
        Assertions.assertAll(page::switchLocations);
    }

    @Test
    public void searchResultsDisplayed() {
        HomePage page = new HomePage(DriverProvider.getInstance());
        assertTrue(page.isResultPresent());
    }
    
    @Test 
    public void fieldsValidated() {
        HomePage page = new HomePage(DriverProvider.getInstance());
      assertTrue(page.requiredFieldsValidated());
    }

    @Test
    public void logoClickUrlMatches() {
        HomePage page = new HomePage(DriverProvider.getInstance());
        page.openURL("https://www.epam.com/about");

      String expected = "https://www.epam.com/";
      String actual = page.getLogoClickUrl();
      assertEquals(expected, actual);
    }
}
