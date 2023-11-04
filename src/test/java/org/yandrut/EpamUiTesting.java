package org.yandrut;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import static junit.framework.Assert.*;

public class EpamUiTesting {
    HomePage page = new HomePage();

    @Test
    public void titleComparison() {
        String actual = page.getTitle();
        String expected = "EPAM | Software Engineering & Product Development Services";
        assertEquals(expected, actual);
    }

    @Test
    public void lightThemeChange() {
        assertAll(() -> page.changeToLightTheme());
    }

    @Test
    public void languageChanged() {
        assertAll(() -> page.changeLanguageToUA());
    }
}
