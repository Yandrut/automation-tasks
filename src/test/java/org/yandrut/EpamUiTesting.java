package org.yandrut;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static junit.framework.Assert.*;

public class EpamUiTesting {
    HomePage page;

    @BeforeMethod
    public void openBrowser() {
        WebDriver driver = DriverFactory.getInstance();
        page = new HomePage(driver);
        driver.get("https://epam.com");
        driver.manage().window().maximize();
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

    @AfterMethod
    public void closeAndQuit() {

    }
}