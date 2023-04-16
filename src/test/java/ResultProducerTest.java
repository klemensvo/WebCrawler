import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultProducerTest {

    @Test
    void printTestPage1() {
        UserData userData = new UserData();
        userData.startingWebsite = "https://javatpoint.com";

        Websites websites = new Websites();
        Website website = new Website();
        // website.url = "https://javatpoint.com";
        websites.add(website);
        ResultProducer resultProducer = new ResultProducer(userData, websites);

        assertEquals("# Web Crawler Report\nStarting website: <a>"
                        + userData.startingWebsite + "</a>\n",

                resultProducer.makeMdDocument(websites)); // websites.get(0).url);

    }

}