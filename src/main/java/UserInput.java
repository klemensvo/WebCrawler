import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class UserInput {
    StartingWebsite startingWebsite = new StartingWebsite();

    protected String url; // todo: change url to StartingWebsite later?
    protected int crawlingDepth;
    protected String targetLanguage;

    public String getStartingWebsiteFromUser() { // todo: change as soon as UserInteraction is deleted
        return startingWebsite.getStartingWebsiteFromUser();
    }

    public int getCrawlingDepthFromUser() {
        Scanner scanner = new Scanner(System.in);
        do {
            new Text().printPromptForCrawlingDepth();
            crawlingDepth = scanner.nextInt(); // todo: change to .nextLine() and convert it (?)
        } while (!isValidCrawlingDepth());
        return crawlingDepth;
    }

    @SuppressWarnings("RedundantIfStatement")
    protected boolean isValidCrawlingDepth() {
        if (crawlingDepth >= 1 && crawlingDepth <= 3) {
            return true;
        }
        return false;
    }

    String getTargetLanguageFromUser() {
        String targetLanguage = "German";
        do {

        } while (!isValidTargetLanguage());
        return targetLanguage;
    }
    protected boolean isValidTargetLanguage() {

        return true;
    }

}
