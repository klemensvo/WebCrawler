import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class UserInput {
    // private String url;
    private int crawlDepth;
    private String targetLanguage;

    public String getStartingWebsiteFromUser() {
        String url;
        Scanner scanner = new Scanner(System.in);
        do {
            new Texts().printPromptStartingWebsite();
            url = scanner.nextLine();
            if (!url.startsWith("https://")) {
                url = prependHttps(url);
            }
        } while (!isValidWebsite(url));
        return url;
    }

    private String prependHttps(String url) {
        return "https://" + url;
    }

    private boolean isValidWebsite(String urlToBeValidated) { // todo: make tests
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
        int crawlingDepth;
        Scanner scanner = new Scanner(System.in);
        do {
            new Texts().printPromptCrawlingDepth();
            crawlingDepth = scanner.nextInt();
        } while (!isValidCrawlingDepth(crawlingDepth));
        return 0;
    }

    private boolean isValidCrawlingDepth(int crawlingDepth) {
        if (crawlingDepth < 1 || crawlingDepth > 3) {
            return false;
        }
        return true;
    }
}
