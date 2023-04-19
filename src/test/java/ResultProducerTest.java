import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultProducerTest {

    @Test
    void printTestPage1() {
        UserData userData = new UserData();
        userData.startingWebsite = "https://javatpoint.com";
        userData.crawlingDepth = 2;
        userData.targetLanguage = "German";

        Websites websites = new Websites();
        Website website = new Website();
        website.url = "https://google.com";
        website.headings.add("h1 Test");
        // website.functionalLinks
        websites.add(website);
        ResultProducer resultProducer = new ResultProducer(userData, websites);

        String testString
                = "# Web Crawler Report"
                + "\nStarting Website: <a>"
                + userData.startingWebsite + "</a>"
                + "\nCrawling Depth: "
                + userData.crawlingDepth
                + "\nTarget Language: "
                + userData.targetLanguage
                + "\n\n"
                + website.url
                + "\n"
                + website.headings.get(0)
                + "\n";

        assertEquals(testString, resultProducer.makeMdDocument(websites));

    }

}