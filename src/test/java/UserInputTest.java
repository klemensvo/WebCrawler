import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void getStartingWebsiteFromUser() {
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

        assertTrue(userInput.isValidCrawlingDepth(1));
        assertTrue(userInput.isValidCrawlingDepth(2));
        assertTrue(userInput.isValidCrawlingDepth(3));

        assertFalse(userInput.isValidCrawlingDepth(0));
        assertFalse(userInput.isValidCrawlingDepth(4));
        assertFalse(userInput.isValidCrawlingDepth(-1));

        // userInput = null;
    }



    @Test
    void getUrlFunctionalTest() {

    }
}