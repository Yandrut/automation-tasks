package org.yandrut;


import org.junit.Test;

import static junit.framework.Assert.*;


public class EpamUiTesting {

    @Test
    public void taskOnePointOne () {
        HomePage page = new HomePage();
        String actual = page.getTitle();
        String expected = "EPAM | Software Engineering & Product Development Services";
        assertTrue(expected.equals(actual));
    }
}
