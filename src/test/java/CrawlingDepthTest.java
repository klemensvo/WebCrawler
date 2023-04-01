import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrawlingDepthTest {

    @Test
    void getCrawlingDepthFromUser() {
    }

    @Test
    void isValidCrawlingDepth() {
        // UserInput userInput = new UserInput();
        CrawlingDepth crawlingDepth = new CrawlingDepth();
        crawlingDepth.crawlingDepth = 1;
        assertTrue(crawlingDepth.isValidCrawlingDepth());
        crawlingDepth.crawlingDepth = 3;
        assertTrue(crawlingDepth.isValidCrawlingDepth());

        crawlingDepth.crawlingDepth = 0;
        assertFalse(crawlingDepth.isValidCrawlingDepth());
        crawlingDepth.crawlingDepth = 4;
        assertFalse(crawlingDepth.isValidCrawlingDepth());
        crawlingDepth.crawlingDepth = -1;
        assertFalse(crawlingDepth.isValidCrawlingDepth());
    }
}