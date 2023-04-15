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

            Website website = webCrawler.setWebsiteHeadingsAndLinks();

            System.out.println("URL: "+website.url);  //todo: delete

            int i=1;                                  //todo: delete
            System.out.println("Headings: ");
            for(String heading: website.headings){
                System.out.println(heading+" "+i);
                i++;
            }

            int j=1;                                  //todo: delete
            System.out.println("Functional links: ");
            for(String link: website.functionalLinks){
                System.out.println(link+" "+j);
                j++;
            }

            int k = 1;                                  //todo: delete
            System.out.println("Broken links: ");
            for(String link: website.brokenLinks){
                System.out.println(link+" "+k);
                k++;
            }

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
