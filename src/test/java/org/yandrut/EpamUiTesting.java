package org.yandrut;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import selenium.DriverProvider;
import selenium.pages.AboutPage;
import selenium.pages.ContactPage;
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
        page.clickOnColourSwitch();

        String expected = "fonts-loaded header--anima148ted dark-mode";
        String actual = page.getBackgroundColourAttribute();
        assertNotSame(expected, actual);
    }

    @Test
    public void languageChanged() {
        HomePage page = new HomePage(DriverProvider.getInstance());
        page.clickOnLanguageOptions();
        page.clickOnLanguageSelector();

        String expected = "EPAM Ukraine - найбільша ІТ-компанія в Україні | Вакансії";
        String actual = page.getTitle();
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
        // not done
        HomePage page = new HomePage(DriverProvider.getInstance());
        Assertions.assertAll(page::switchLocations);
    }

    @Test
    public void searchResultsDisplayed() {
        HomePage page = new HomePage(DriverProvider.getInstance());
        page.clickOnSearchBar();
        page.sendKeysToInput("AI");
        String expected = "search-results__counter hidden";
        String actual = page.getSearchResultAttributeValue();
        assertNotSame(expected, actual);
    }
    
    @Test 
    public void fieldsValidated() {
        ContactPage page = new ContactPage(DriverProvider.getInstance());
        page.openURL("https://www.epam.com/about/who-we-are/contact");
        List <WebElement> required = page.getRequiredList();
        page.submitInputs();
      assertTrue(page.areFieldsValidated(required));
    }

    @Test
    public void logoClickUrlMatches() {
        AboutPage page = new AboutPage(DriverProvider.getInstance());
        page.openURL("https://www.epam.com/about");
        page.clickOnLogo();
      String expected = "https://www.epam.com/";
      String actual = page.getCurrentUrl();
      assertEquals(expected, actual);
    }
}
