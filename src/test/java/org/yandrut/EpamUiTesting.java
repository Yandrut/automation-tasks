package org.yandrut;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import static junit.framework.Assert.*;

public class EpamUiTesting {
    WebDriver driver = DriverFactory.getInstance();
    HomePage page = new HomePage(driver);

    @Test
    public void titleComparison() {
        String actual = page.getTitle();
        String expected = "EPAM | Software Engineering & Product Development Services";
        assertEquals(expected, actual);
    }

    @Test
    public void lightThemeChanged() {
        String expected = "fonts-loaded header--animated dark-mode";
        String actual = page.getBackgroundColourAttribute();
        assertNotSame(expected, actual);
    }

    @Test
    public void languageChanged() {
        String expected = "EPAM Ukraine - найбільша ІТ-компанія в Україні | Вакансії";
        String actual = page.getUkrainianTitle();
        assertEquals(expected, actual);
    }
}
