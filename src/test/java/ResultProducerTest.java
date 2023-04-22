import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultProducerTest {

    @Test
    void printTestPage1() {
        UserData userData = new UserData();
        userData.startingWebsite = "https://javatpoint.com";
        userData.crawlingDepth = 2;
        userData.targetLanguage = "German";

        WebsiteList websiteList = new WebsiteList();
        Website website = new Website();
        website.url = "https://google.com";
        // website.headings.add("h1 Test"); // todo: change this line

        // website.functionalLinks
        websiteList.add(website);
        ResultProducer resultProducer = new ResultProducer(userData, websiteList);

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

        assertEquals(testString, resultProducer.makeMdDocument());

    }

}