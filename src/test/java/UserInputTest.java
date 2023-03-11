import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {

    UserInput userInput;
    Scanner scanner;

    @BeforeEach
    void setUp() {
        userInput = new UserInput();

    }

    @AfterEach
    void tearDown() {
        userInput = null;
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