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

        UserInput userInput = new UserInput();
        String url = userInput.getStartingWebsiteFromUser();
        assertEquals("https://javatpoint.com", url);

        System.setIn(originalSystemInput);
    }

    @Test
    void getInvalidStartingWebsiteFromUser() {
        InputStream originalSystemInput = System.in;
        String testWebsite = "https://javatpoint\n";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(testWebsite.getBytes());
        System.setIn(byteArrayInputStream);

        UserInput userInput = new UserInput();
        String url = userInput.getStartingWebsiteFromUser();
        assertNotEquals("https://javatpoint.com", url);

        System.setIn(originalSystemInput);
    }


    @Test
    void prependHttps() {
    }

    @Test
    void isValidWebsite() {
        StartingWebsite startingWebsite = new StartingWebsite();
        boolean shouldBeValidWebsite = startingWebsite.isValidWebsite("https://www.google.com");
        assertTrue(shouldBeValidWebsite);
    }

    @Test
    void testToString() {
    }
}