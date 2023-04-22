import java.util.ArrayList;
import java.util.HashSet;

public class CrawlingDispatcher {
    UserData userData;
    String startingWebsite;
    int maxCrawlingDepth;

    WebsiteList websiteList = new WebsiteList();
    HashSet<String> crawledUrls = new HashSet<>();
    WebCrawler webCrawler;

    public CrawlingDispatcher(UserData userData) {
        this.userData = userData;
        startingWebsite = userData.startingWebsite;
        maxCrawlingDepth = userData.crawlingDepth;
        webCrawler = new WebCrawler(startingWebsite);
    }

    public WebsiteList getWebsiteList() {
        dispatchCrawlRecursively(startingWebsite, 0, websiteList, crawledUrls);
        return websiteList;
    }

    private void dispatchCrawlRecursively(String url, int currentCrawlingDepth,
                                          WebsiteList websiteList, HashSet<String> crawledUrls)
    {
        // termination conditions of recursion
        if (currentCrawlingDepth > maxCrawlingDepth || crawledUrls.contains(url)) {
            return;
        }

        crawledUrls.add(url);
        System.out.println("added website: " + url); // todo: delete later

        Website website = webCrawler.getWebsiteHeadingsAndLinks();
        if (website != null) {
            websiteList.add(website);
            // need to maka a copy, or else "ConcurrentModificationException"
            ArrayList<String> functionalLinksCopy = new ArrayList<>(website.functionalLinks);

            for (String functionalLink : functionalLinksCopy) {
                dispatchCrawlRecursively(functionalLink, currentCrawlingDepth + 1,
                        websiteList, crawledUrls);
            }
        }
    }
}
