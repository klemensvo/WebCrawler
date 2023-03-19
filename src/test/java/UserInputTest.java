import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {

    UserInput userInput;
    // Scanner scanner;

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
        /*
        String google = "https://google.com\n";
        scanner = new Scanner(google);
        String result = scanner.nextLine();
        assertEquals(result, userInput.getUrl()); // todo: continue here, see chatGPT
         */
    }
}