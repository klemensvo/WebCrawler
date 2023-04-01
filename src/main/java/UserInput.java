import java.util.ArrayList;

public class UserInput {
    StartingWebsite startingWebsite = new StartingWebsite();
    CrawlingDepth crawlingDepth = new CrawlingDepth();
    TargetLanguage targetLanguage = new TargetLanguage();
    String url;
    int depth;
    String language;

    public void start() {
        new Text().printWelcome();
        url = getStartingWebsiteFromUser();
        depth = getCrawlingDepthFromUser();
        language = getTargetLanguageFromUser();

        printSummaryOfUserInput();

        // todo: move the following part to CrawlingList
        System.out.println("\nHeadings from " + url + ":\n");
        WebCrawler webCrawler = new WebCrawler(startingWebsite.getUrl());
        ArrayList<String> headings = webCrawler.crawlHeadings();
        for (String heading : headings) {
            System.out.println(heading);
        }
    }

    public String getStartingWebsiteFromUser() {
        return startingWebsite.getStartingWebsiteFromUser();
    }

    public int getCrawlingDepthFromUser() {
        return crawlingDepth.getCrawlingDepthFromUser();
    }

    public String getTargetLanguageFromUser() {
        return targetLanguage.getTargetLanguageFromUser();
    }

    private void printSummaryOfUserInput() {
        System.out.println("\nStarting website: " + url +
                ", crawling depth: " + depth +
                ", target language: " + language);
    }
}