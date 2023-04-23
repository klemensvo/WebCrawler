import java.util.ArrayList;
import java.util.HashSet;

public class CrawlingDispatcher {
    UserData userData;
    String startingWebsite;
    int maxCrawlingDepth;

    // WebsiteNode websiteNode; // = new WebsiteNode();
    // WebsiteNode rootNode;
    HashSet<String> crawledUrls = new HashSet<>();

    public CrawlingDispatcher(UserData userData) {
        this.userData = userData;
        startingWebsite = userData.startingWebsite;
        maxCrawlingDepth = userData.crawlingDepth;
    }

    /*
    public WebsiteNode getRootNode() {

        return rootNode;
    } */
    public WebsiteNode crawlWebAndGetRootNode() {
        WebCrawler webCrawler = new WebCrawler(startingWebsite);
        Website website = webCrawler.getWebsiteHeadingsAndLinks();
        WebsiteNode rootNode = new WebsiteNode();
        rootNode.setWebsite(website);
        crawledUrls.add(startingWebsite);

        if (website != null) {
            crawlRecursively(rootNode, 1);
        }

        return rootNode; // todo: this function does 2 things, change to get rootNode from own function
    }

    private void crawlRecursively(WebsiteNode parentNode, int currentCrawlingDepth) {

        // termination condition of recursion
        if (currentCrawlingDepth > maxCrawlingDepth) {
            return;
        }

        ArrayList<String> functionalLinks = parentNode.getWebsite().functionalLinks;
        for (String url : functionalLinks) {
            if (!crawledUrls.contains(url)) {
                crawledUrls.add(url);
                WebCrawler webCrawler = new WebCrawler(url);
                Website website = webCrawler.getWebsiteHeadingsAndLinks();

                if (website != null) {
                    WebsiteNode childNode = new WebsiteNode();
                    childNode.setWebsite(website);
                    childNode.setParent(parentNode);
                    childNode.addChild(childNode);

                    crawlRecursively(childNode, currentCrawlingDepth + 1);
                }

            }
        }

        /*
        crawledUrls.add(url);
        System.out.println("added website: " + url); // todo: delete later

        Website website = webCrawler.getWebsiteHeadingsAndLinks();
        if (website != null) {
            websiteNode.add(website);
            // need to maka a copy, or else "ConcurrentModificationException"
            ArrayList<String> functionalLinksCopy = new ArrayList<>(website.functionalLinks);

            for (String functionalLink : functionalLinksCopy) {
                crawlRecursively(functionalLink, currentCrawlingDepth + 1,
                        websiteNode, crawledUrls);
            }
        } */
    }
}
