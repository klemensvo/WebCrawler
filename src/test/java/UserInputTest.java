import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class UserInputTest {

    @Test
    void start() { // todo: is there a way to test start() ?
    }
    @Test
    void summaryOfUserInputTest() {
        UserInput userInput = new UserInput();
        userInput.url = "https://www.google.com";
        userInput.depth = 1;
        userInput.language = "German";

        assertEquals("\nStarting website: https://www.google.com, crawling depth: 1, " +
                "target language: German", userInput.summaryOfUserInput());
    }


}