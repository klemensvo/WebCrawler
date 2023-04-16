import java.util.ArrayList;
import java.util.HashSet;

public class CrawlingManager {
    final UserData userData;
    Websites websites = new Websites();
    Website website;

    WebCrawler webCrawler;
    ArrayList<String> crawlingList = new ArrayList<>();
    HashSet<String> crawledSet = new HashSet<>();

    public CrawlingManager(UserData userData) {
        this.userData = userData;
    }

    public Websites getWebsites() {
        crawlingList.add(userData.startingWebsite);
        int crawlingDepth = userData.crawlingDepth;

        while (!crawlingList.isEmpty()) {
            String currentLink = crawlingList.remove(0);
            crawledSet.add(currentLink);

            webCrawler = new WebCrawler(currentLink);
            website = webCrawler.getWebsiteHeadingsAndLinks();

            websites.add(website);

            addFunctionalLinksToCrawlingListIfNotContained();
        }

        return websites;
    }

    private void addFunctionalLinksToCrawlingListIfNotContained() {
        for (String functionalLink : website.functionalLinks) {
            if(!crawledSet.contains(functionalLink)) {
                crawlingList.add(functionalLink);
            }
        }
    }
}
