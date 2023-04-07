import java.util.ArrayList;

public class CrawlingManager {
    final UserData userData;
    final CrawlingList<Website> crawlingList;
    final String url;
    final int crawlingDepth;
    final String targetLanguage;


    public CrawlingManager(UserData userData) {
        this.userData = userData;
        this.url = userData.startingWebsite;
        this.crawlingDepth = userData.crawlingDepth;
        this.targetLanguage = userData.targetLanguage;

        this.crawlingList = new CrawlingList<>();
    }

    public CrawlingList<Website> getWebsites() {
        WebCrawler webCrawler = new WebCrawler(userData.startingWebsite);
        ArrayList<String> headings = webCrawler.crawlHeadings();
        for (String heading : headings) {
            System.out.println(heading);
            // crawlingList.add(heading);
        }

        return crawlingList;

        /*
        Website website = new Website();
        website.url = startingWebsite;
        crawlingList.add(website);

        WebCrawler webCrawler; // = new WebCrawler(); // todo: use webCrawler to crawl websites
        while (!crawlingList.isEmpty()) {
            website = crawlingList.remove(0);
            webCrawler = new WebCrawler(website.url);

        } */
    }
}
