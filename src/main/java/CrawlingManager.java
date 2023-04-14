import java.util.ArrayList;

public class CrawlingManager {
    final UserData userData;
    ArrayList<String> crawlingList = new ArrayList<>();
    ArrayList<Website> websites = new ArrayList<>();
    WebCrawler webCrawler;

    public CrawlingManager(UserData userData) {
        this.userData = userData;
    }

    public ArrayList<Website> getWebsites() {
        crawlingList.add(userData.startingWebsite);
        while (!crawlingList.isEmpty()) {
            webCrawler = new WebCrawler(crawlingList.remove(0));
            Website website = new Website();
            website.headings = webCrawler.crawlHeadings();
            websites.add(website);
        }

        return websites;
    }
}
