import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

class CrawlingDispatcherTest {

    @Test
    void crawlingDispatcherTest() {
        WebCrawler mockWebCrawler = Mockito.mock(WebCrawler.class);

        Website mockWebsite = new Website();
        mockWebsite.url = "https://javatpoint.com";
        // mockWebsite.headings.add("Test Heading"); // todo: change this back
        mockWebsite.functionalLinks.add("https://example.com/functionalLink");
        Mockito.when(mockWebCrawler.getWebsiteHeadingsAndLinks()).thenReturn(mockWebsite);

        UserData userData = new UserData();
        userData.startingWebsite = "https://example.com";
        userData.crawlingDepth = 1;
        userData.targetLanguage = "German";

        CrawlingDispatcher crawlingDispatcher = new CrawlingDispatcher(userData);
        crawlingDispatcher.webCrawler = mockWebCrawler;
        WebsiteList websiteList = crawlingDispatcher.getWebsiteList();

        assertEquals(2, websiteList.size()); // todo: why 2? (should rather be 1)
        assertEquals(mockWebsite.url, websiteList.get(0).url);
        assertEquals(mockWebsite.headings.get(0), websiteList.get(0).headings.get(0));
        assertEquals(mockWebsite.functionalLinks.get(0), websiteList.get(0).functionalLinks.get(0));
    }
}