import java.util.ArrayList;

public class CrawlingManager {
    UserData userData;
    ArrayList<Website> crawlingList;


    public CrawlingManager(UserData userData) {
        this.userData = userData;
        this.crawlingList = new ArrayList<>();
    }

    public void getWebsites() {
        WebCrawler webCrawler = new WebCrawler(userData.startingWebsite);
        ArrayList<String> headings = webCrawler.crawlHeadings();
        for (String heading : headings) {
            System.out.println(heading);
        }

        // System.out.println("The starting website is: " + userData.startingWebsite);

        /*
        Website website = new Website();
        website.url = startingWebsite;
        crawlingList.add(website);

        WebCrawler webCrawler; // = new WebCrawler(); // todo: use webCrawler to crawl websites
        while (!crawlingList.isEmpty()) {
            website = crawlingList.remove(0);
            webCrawler = new WebCrawler(website.url);

        } */

        /*
        crawlingList = new CrawlingList(); // .next(), .hasNext(), .add()
        crawlingList.add(startingWebsite);

        webCrawler = new WebCrawler(startingWebsite);
        ArrayList<String> headings = webCrawler.crawlHeadings();
        for (String heading : headings) {
            System.out.println(heading);
        } */

        /*
        while (crawlingList.hasNext()) {

        } */

    }
}
