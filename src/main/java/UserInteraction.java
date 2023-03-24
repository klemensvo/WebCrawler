import java.util.ArrayList;

public class UserInteraction {
    protected String startingWebsite;
    protected int crawlingDepth;
    protected String targetLanguage;


    public void start() {

        new Text().printWelcome();

        startingWebsite = new UserInput().getStartingWebsiteFromUser();
        crawlingDepth = new UserInput().getCrawlingDepthFromUser();
        targetLanguage = "German"; // todo: implement prompt for targetLanguage in UserInput

        printSummaryOfUserInput();

        System.out.println("\nHeadings from " + startingWebsite + ":\n");
        WebCrawler webCrawler = new WebCrawler(startingWebsite);
        ArrayList<String> headings = webCrawler.crawlHeadings();
        for (String heading: headings) {
            System.out.println(heading);
        }
    }

    private void printSummaryOfUserInput() {
        System.out.println("\nStarting website: " + startingWebsite +
                ", crawling depth: " + crawlingDepth +
                ", target language: " + targetLanguage);
    }

    public String getStartingWebsite() {
        return startingWebsite;
    }

    public int getCrawlingDepth() {
        return crawlingDepth;
    }

    public String getTargetLanguage() {
        return targetLanguage;
    }
}
