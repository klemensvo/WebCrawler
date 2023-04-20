import java.util.HashSet;

public class CrawlingDispatcher {
    UserData userData;
    String startingWebsite;
    int maxCrawlingDepth;

    WebsiteList websiteList;
    HashSet<String> crawledUrls;

    WebCrawler webCrawler;


    public CrawlingDispatcher(UserData userData) {
        this.userData = userData;
        startingWebsite = userData.startingWebsite;
        maxCrawlingDepth = userData.crawlingDepth;
        webCrawler = new WebCrawler(startingWebsite);
    }

    public WebsiteList getWebsiteList() {
        websiteList = new WebsiteList();
        crawledUrls = new HashSet<>();

        dispatchCrawlRecursively(startingWebsite, 0, websiteList, crawledUrls);

        return websiteList;
    }

    private void dispatchCrawlRecursively(String url, int currentCrawlingDepth,
                                          WebsiteList websiteList, HashSet<String> crawledUrls) {

        // termination conditions of recursion
        if (currentCrawlingDepth > maxCrawlingDepth || crawledUrls.contains(url)) {
            return;
        }

        crawledUrls.add(url);

        Website website = webCrawler.getWebsiteHeadingsAndLinks();
        if (website != null) {
            websiteList.add(website);
            for (String functionalLink : website.functionalLinks) {
                dispatchCrawlRecursively(functionalLink, currentCrawlingDepth + 1,
                        websiteList, crawledUrls);
            }
        }
    }


    /*
    public WebsiteList getWebsites() {
        crawlingList.add(userData.startingWebsite);
        int crawlingDepth = userData.crawlingDepth;

        while (!crawlingList.isEmpty()) {
            String currentLink = crawlingList.remove(0);
            crawledSet.add(currentLink);

            webCrawler = new WebCrawler(currentLink);
            website = webCrawler.getWebsiteHeadingsAndLinks();

            websiteList.add(website);

            addFunctionalLinksToCrawlingList();
        }

        return websiteList;
    } */

    /*
    private void addFunctionalLinksToCrawlingList() {
        for (String functionalLink : website.functionalLinks) {
            if(!crawledSet.contains(functionalLink)) {
                crawlingList.add(functionalLink);
            }
        }
    } */
}
