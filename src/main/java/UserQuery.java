import java.util.ArrayList;

public class UserQuery {
    final StartingWebsite startingWebsite = new StartingWebsite();
    final CrawlingDepth crawlingDepth = new CrawlingDepth();
    final TargetLanguage targetLanguage = new TargetLanguage();
    protected String url;
    protected int depth;
    protected String language;

    public void start() {
        new Text().printWelcome();
        url = getStartingWebsiteFromUser();
        depth = getCrawlingDepthFromUser();
        language = getTargetLanguageFromUser();

        System.out.println(summaryOfUserInput());

        // todo: move the following part to Website, called from CrawlingList
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

    protected String summaryOfUserInput() {
         return "\nStarting website: " + url +
                ", crawling depth: " + depth +
                ", target language: " + language;
    }
}