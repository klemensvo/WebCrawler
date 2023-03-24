import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        UserInteraction userInteraction = new UserInteraction();
        userInteraction.start();

        WebCrawler webCrawler = new WebCrawler(userInteraction.getStartingWebsite());
        ArrayList<String> headings = webCrawler.crawlHeadings();
        for (String heading : headings) {
            System.out.println(heading);
        }

    }

}

