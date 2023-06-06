import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CrawlingDispatcher {
    UserData userData;
    WebsiteNode rootNode;
    HashSet<String> crawledUrls = new HashSet<>();

    public CrawlingDispatcher(UserData userData) {
        this.userData = userData;
    }

    public void crawlWeb() {
        long webCrawlingStartTime = System.currentTimeMillis();

        WebCrawler webCrawler = new WebCrawler(userData.startingWebsite);
        Website website = webCrawler.getWebsiteHeadingsAndLinks();
        rootNode = new WebsiteNode();
        rootNode.setWebsite(website);
        crawledUrls.add(userData.startingWebsite);

        if (website != null) {
            crawlRecursively(rootNode, 1);
        }

        long webCrawlingEndTime = System.currentTimeMillis();
        System.out.println("Time to crawl the web: " +
                ((double) (webCrawlingEndTime - webCrawlingStartTime) / 1000) +
                " s");
    }

    private void crawlRecursively(WebsiteNode websiteNode, int currentCrawlingDepth) {
        if (currentCrawlingDepth > userData.maxCrawlingDepth) {
            return;
        }

        ArrayList<String> links = websiteNode.getWebsite().functionalLinks;
        ArrayList<String> headings = websiteNode.getWebsite().headings;


        List<CompletableFuture<WebsiteNode>> linksFutures = links.stream()
                .filter(link -> !crawledUrls.contains(link))
                .map(link -> {
                    crawledUrls.add(link);
                    return CompletableFuture.supplyAsync(() -> {
                        WebCrawler webCrawler = new WebCrawler(link);
                        Website website = webCrawler.getWebsiteHeadingsAndLinks();


                        WebsiteNode childNode = new WebsiteNode();
                        childNode.setWebsite(website);
                        return childNode;
                    });
                }).toList();

        CompletableFuture.allOf(linksFutures.toArray(new CompletableFuture[linksFutures.size()])).join();



        for (CompletableFuture<WebsiteNode> future : linksFutures) {
            WebsiteNode childNode = future.join();
            websiteNode.addChild(childNode);
            crawlRecursively(childNode, currentCrawlingDepth + 1);
        }
    }

    public WebsiteNode getRootNode() {
        return rootNode;
    }
}



/*
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CrawlingDispatcher {
    UserData userData;
    WebsiteNode rootNode;
    HashSet<String> crawledUrls = new HashSet<>();

    public CrawlingDispatcher(UserData userData) {
        this.userData = userData;
    }

    public void crawlWeb() {
        WebCrawler webCrawler = new WebCrawler(userData.startingWebsite);
        Website website = webCrawler.getWebsiteHeadingsAndLinks();
        rootNode = new WebsiteNode();
        rootNode.setWebsite(website);
        crawledUrls.add(userData.startingWebsite);

        if (website != null) {
            crawlRecursively(rootNode, 1);
        }
    }

    private void crawlRecursively(WebsiteNode websiteNode, int currentCrawlingDepth) {

        if (currentCrawlingDepth > userData.maxCrawlingDepth) {
            return;
        }

        ArrayList<String> links = websiteNode.getWebsite().functionalLinks;

        List<CompletableFuture<WebsiteNode>> linksFutures = links.stream()
                .filter(link -> !crawledUrls.contains(link))
                .map(link -> {
                    crawledUrls.add(link);
                    return CompletableFuture.supplyAsync(() -> {
                        WebCrawler webCrawler = new WebCrawler(link);
                        Website website = webCrawler.getWebsiteHeadingsAndLinks();
                        WebsiteNode childNode = new WebsiteNode();
                        childNode.setWebsite(website);
                        return childNode;
                    });
                }).toList();


        // CompletableFuture.allOf(linksFutures.toArray(new CompletableFuture[0])).join();
        CompletableFuture.allOf(linksFutures.toArray(new CompletableFuture[linksFutures.size()])).join();

        for (CompletableFuture<WebsiteNode> future : linksFutures) {
            WebsiteNode childNode = future.join();
            websiteNode.addChild(childNode);
            crawlRecursively(childNode, currentCrawlingDepth + 1);
        }
    }

    public WebsiteNode getRootNode() {
        return rootNode;
    }
} */

/*
import java.util.ArrayList;
import java.util.HashSet;

public class CrawlingDispatcher {
    UserData userData;
    WebsiteNode rootNode;
    HashSet<String> crawledUrls = new HashSet<>();

    public CrawlingDispatcher(UserData userData) {
        this.userData = userData;
    }

    public void crawlWeb() {
        WebCrawler webCrawler = new WebCrawler(userData.startingWebsite);
        Website website = webCrawler.getWebsiteHeadingsAndLinks();
        rootNode = new WebsiteNode();
        rootNode.setWebsite(website);
        crawledUrls.add(userData.startingWebsite);

        if (website != null) {
            crawlRecursively(rootNode, 1);
        }
    }

    private void crawlRecursively(WebsiteNode websiteNode, int currentCrawlingDepth) {

        if (currentCrawlingDepth > userData.maxCrawlingDepth) {
            return;
        }

        ArrayList<String> links = websiteNode.getWebsite().functionalLinks;
        for (String link : links) {
            if (!crawledUrls.contains(link)) {
                crawledUrls.add(link);

                WebCrawler webCrawler = new WebCrawler(link);
                Website website = webCrawler.getWebsiteHeadingsAndLinks();

                WebsiteNode childNode = new WebsiteNode();
                childNode.setWebsite(website);
                websiteNode.addChild(childNode);

                crawlRecursively(childNode, currentCrawlingDepth + 1);
            }
        }
    }

    public WebsiteNode getRootNode() {
        return rootNode;
    }
} */
