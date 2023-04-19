import java.util.ArrayList;
import java.util.HashSet;

public class CrawlingManager {
    final UserData userData;
    WebsiteList websiteList = new WebsiteList();
    Website website;

    WebCrawler webCrawler;
    ArrayList<String> crawlingList = new ArrayList<>();
    HashSet<String> crawledSet = new HashSet<>();

    public CrawlingManager(UserData userData) {
        this.userData = userData;
    }

    public WebsiteList getWebsites() {
        crawlingList.add(userData.startingWebsite);
        int crawlingDepth = userData.crawlingDepth;

        while (!crawlingList.isEmpty()) {
            String currentLink = crawlingList.remove(0);
            crawledSet.add(currentLink);

            webCrawler = new WebCrawler(currentLink);
            website = webCrawler.getWebsiteHeadingsAndLinks();

            websiteList.add(website);

            addFunctionalLinksToCrawlingListIfNotContained();
        }

        return websiteList;
    }

    private void addFunctionalLinksToCrawlingListIfNotContained() {
        for (String functionalLink : website.functionalLinks) {
            if(!crawledSet.contains(functionalLink)) {
                crawlingList.add(functionalLink);
            }
        }
    }
}
