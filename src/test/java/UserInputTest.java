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
    void prependHttps() {
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