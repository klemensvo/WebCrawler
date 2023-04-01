import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class StartingWebsiteTest {

    @Test
    void getValidStartingWebsiteFromUser() {
        InputStream originalSystemInput = System.in;
        String testWebsite = "https://javatpoint.com\n";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(testWebsite.getBytes());
        System.setIn(byteArrayInputStream);

        StartingWebsite startingWebsite = new StartingWebsite();
        String url = startingWebsite.getStartingWebsiteFromUser();
        assertEquals("https://javatpoint.com", url);

        System.setIn(originalSystemInput);
    }

    @Test
    void getInvalidStartingWebsiteFromUser() {
        InputStream originalSystemInput = System.in;
        String testWebsite = "https://www.google.com\n";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(testWebsite.getBytes());
        System.setIn(byteArrayInputStream);

        StartingWebsite startingWebsite = new StartingWebsite();
        String url = startingWebsite.getStartingWebsiteFromUser();
        assertNotEquals("https://javatpoint.com", url);

        System.setIn(originalSystemInput);
    }

    @Test
    void prependHttpsNecessaryTest() {
        StartingWebsite startingWebsite = new StartingWebsite();
        startingWebsite.url = "www.google.com";
        startingWebsite.prependHttpsIfNecessary();
        assertEquals("https://www.google.com", startingWebsite.getUrl());
    }

    @Test
    void prependHttpsNotNecessaryTest() {
        StartingWebsite startingWebsite = new StartingWebsite();
        startingWebsite.url = "https://www.google.com";
        startingWebsite.prependHttpsIfNecessary();
        assertEquals("https://www.google.com", startingWebsite.getUrl());
    }
    @Test
    void isValidWebsiteTest() {
        StartingWebsite startingWebsite = new StartingWebsite();
        startingWebsite.url = "https://www.google.com";
        boolean shouldBeValidWebsite = startingWebsite.isValidWebsite();
        assertTrue(shouldBeValidWebsite);
    }

    @Test
    void isNotValidWebsiteTest1() {
        StartingWebsite startingWebsite = new StartingWebsite();
        startingWebsite.url = "";
        boolean shouldNotBeValidWebsite = startingWebsite.isValidWebsite();
        assertFalse(shouldNotBeValidWebsite);
    }

    @Test
    void isNotValidWebsiteTest2() {
        StartingWebsite startingWebsite = new StartingWebsite();
        startingWebsite.url = "https://";
        boolean shouldNotBeValidWebsite = startingWebsite.isValidWebsite();
        assertFalse(shouldNotBeValidWebsite);
    }

    @Test
    void isNotValidWebsiteTest3() {
        StartingWebsite startingWebsite = new StartingWebsite();
        startingWebsite.url = "https://hello";
        boolean shouldNotBeValidWebsite = startingWebsite.isValidWebsite();
        assertFalse(shouldNotBeValidWebsite);
    }

    @Test
    void isNotValidWebsiteTest4() {
        StartingWebsite startingWebsite = new StartingWebsite();
        startingWebsite.url = "https://at";
        boolean shouldNotBeValidWebsite = startingWebsite.isValidWebsite();
        assertFalse(shouldNotBeValidWebsite);
    }

    @Test
    void isNotValidWebsiteTest5() {
        StartingWebsite startingWebsite = new StartingWebsite();
        startingWebsite.url = "https://||9";
        boolean shouldNotBeValidWebsite = startingWebsite.isValidWebsite();
        assertFalse(shouldNotBeValidWebsite);
    }

    @Test
    void getUrlFunctionalTest() {

    }
}