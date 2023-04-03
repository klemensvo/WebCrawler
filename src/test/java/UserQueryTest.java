import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class UserQueryTest {

    @Test
    void start() { // todo: is there a way to test start() ?
    }
    @Test
    void summaryOfUserInputTest() {
        UserQuery userQuery = new UserQuery();
        userQuery.url = "https://www.google.com";
        userQuery.depth = 1;
        userQuery.language = "German";

        assertEquals("\nStarting website: https://www.google.com, crawling depth: 1, " +
                "target language: German", userQuery.summaryOfUserInput());
    }


}