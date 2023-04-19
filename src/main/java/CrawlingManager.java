import java.util.ArrayList;
import java.util.HashSet;

public class CrawlingManager {
    final UserData userData;
    ListOfWebsites listOfWebsites = new ListOfWebsites();
    Website website;

    WebCrawler webCrawler;
    ArrayList<String> linksToVisit = new ArrayList<>();
    HashSet<String> linksVisited = new HashSet<>();

    public CrawlingManager(UserData userData) {
        this.userData = userData;
    }

    public ListOfWebsites getWebsites() {
        linksToVisit.add(userData.startingWebsite);
        int crawlingDepth = userData.crawlingDepth;

        while (!linksToVisit.isEmpty()) {
            String currentLink = linksToVisit.remove(0);
            linksVisited.add(currentLink);

            webCrawler = new WebCrawler(currentLink);
            website = webCrawler.setWebsiteHeadingsAndLinks();
            printWebsiteAttributes(website);

            listOfWebsites.add(website);

            addFunctionalLinksToCrawlingListIfNotContained();
        }

        return listOfWebsites;
    }

    private void addFunctionalLinksToCrawlingListIfNotContained() {
        for (String functionalLink : website.functionalLinks) {
            if(!linksVisited.contains(functionalLink)) {
                linksToVisit.add(functionalLink);
            }
        }
    }
    private void printWebsiteAttributes (Website website){
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
    }
}
