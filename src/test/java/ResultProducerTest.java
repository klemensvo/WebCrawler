import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultProducerTest {

    @Test
    void printTestPage1() {
        UserData userData = new UserData();
        userData.startingWebsite = "https://javatpoint.com";
        userData.crawlingDepth = 2;
        userData.targetLanguage = "German";

        WebsiteNode websiteNode = new WebsiteNode();
        Website website = new Website();
        website.url = "https://google.com";
        website.headings.add("h1 Test");

        // website.functionalLinks
        // websiteNode.add(website); // todo: change reading from tree-structure
        ResultProducer resultProducer = new ResultProducer(userData, websiteNode);

        String testString
                = "# Web Crawler Report"
                + "\nStarting Website: <a>"
                + userData.startingWebsite + "</a>"
                + "\nCrawling Depth: "
                + userData.crawlingDepth
                + "\nTarget Language: "
                + userData.targetLanguage
                + "\n\n";
                /*
                + website.url
                + "\n"
                + website.headings.get(0)
                + "\n"; */

        assertEquals(testString, resultProducer.makeMdDocument());

    }

}