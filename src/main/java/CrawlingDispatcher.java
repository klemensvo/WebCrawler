import java.util.ArrayList;
import java.util.HashSet;

public class CrawlingDispatcher {
    UserData userData;
    String startingWebsite;
    int maxCrawlingDepth;
    WebsiteNode rootNode;
    HashSet<String> crawledUrls = new HashSet<>();

    public CrawlingDispatcher(UserData userData) {
        this.userData = userData;
        startingWebsite = userData.startingWebsite;
        maxCrawlingDepth = userData.crawlingDepth;
    }

    public void crawlWeb() {
        WebCrawler webCrawler = new WebCrawler(startingWebsite);
        Website website = webCrawler.getWebsiteHeadingsAndLinks();
        rootNode = new WebsiteNode();
        rootNode.setWebsite(website);
        crawledUrls.add(startingWebsite);

        if (website != null) {
            crawlRecursively(rootNode, 1);
        }
    }

    private void crawlRecursively(WebsiteNode parentNode, int currentCrawlingDepth) {
        // termination condition of recursion
        if (currentCrawlingDepth > maxCrawlingDepth) {
            return;
        }

        // todo: make subroutines to have less indentation
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
                    parentNode.addChild(childNode);

                    crawlRecursively(childNode, currentCrawlingDepth + 1);
                }

            }
        }
    }

    public WebsiteNode getRootNode() {
        return rootNode;
    }
}
