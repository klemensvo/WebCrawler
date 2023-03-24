import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class UserInput {
    protected String url;
    protected int crawlingDepth;
    protected String targetLanguage;

    public String getStartingWebsiteFromUser() {
        String url;
        Scanner scanner = new Scanner(System.in);
        do {
            new Texts().printPromptForStartingWebsite();
            url = scanner.nextLine();
            /* todo: prepend https:// if necessary
            if (!url.startsWith("https://")) {
                url = prependHttps(url);
            } */
        } while (!isValidWebsite(url));
        return url;
    }

    protected String prependHttps(String url) {
        return "https://" + url;
    }

    protected boolean isValidWebsite(String urlToBeValidated) {
        try {
            // if the next two lines pass, the URL is valid
            URL debatableUrl = new URL(urlToBeValidated);
            debatableUrl.toURI();
            return true;
        } catch (MalformedURLException | URISyntaxException e) {
            return false;
        }
    }

    public int getCrawlingDepthFromUser() {
        // int crawlingDepth;
        Scanner scanner = new Scanner(System.in);
        do {
            new Texts().printPromptForCrawlingDepth();
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
