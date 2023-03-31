import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {

    UserInput userInput;

    @BeforeEach
    void setUp() {
        userInput = new UserInput();

    }

    @AfterEach
    void tearDown() {
        userInput = null;
    }


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
    }

    @Test
    void getCrawlingDepthFromUser() {

    }

    @Test
    void isValidCrawlingDepth() {
        UserInput userInput = new UserInput();
        userInput.crawlingDepth = 1;
        assertTrue(userInput.isValidCrawlingDepth());
        userInput.crawlingDepth = 3;
        assertTrue(userInput.isValidCrawlingDepth());

        userInput.crawlingDepth = 0;
        assertFalse(userInput.isValidCrawlingDepth());
        userInput.crawlingDepth = 4;
        assertFalse(userInput.isValidCrawlingDepth());
        userInput.crawlingDepth = -1;
        assertFalse(userInput.isValidCrawlingDepth());
    }


    @Test
    void getUrlFunctionalTest() {

    }
}