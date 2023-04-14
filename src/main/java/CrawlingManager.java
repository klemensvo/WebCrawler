import java.util.ArrayList;
import java.util.HashSet;

public class CrawlingManager {
    final UserData userData;
    ArrayList<String> crawlingList = new ArrayList<>();
    HashSet<String> crawledSet = new HashSet<>();
    ArrayList<Website> websites = new ArrayList<>();
    WebCrawler webCrawler;

    public CrawlingManager(UserData userData) {
        this.userData = userData;
    }

    public ArrayList<Website> getWebsites() {
        crawlingList.add(userData.startingWebsite);

        while (!crawlingList.isEmpty()) {
            String currentLink = crawlingList.remove(0);
            crawledSet.add(currentLink);
            webCrawler = new WebCrawler(currentLink);

            Website website = webCrawler.getWebsiteHeadingsAndLinks();
            for (String functionalLink : website.functionalLinks) {
                if(!crawledSet.contains(functionalLink)) {
                    crawlingList.add(functionalLink);
                    crawledSet.add(functionalLink);
                }
            }
            websites.add(website);
        }

        return websites;
    }
}
