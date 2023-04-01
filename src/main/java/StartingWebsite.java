import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class StartingWebsite {

    public String getStartingWebsiteFromUser() {
        String url;
        Scanner scanner = new Scanner(System.in);
        do {
            new Text().printPromptForStartingWebsite();
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

    public String toString() {
        String testWebsite = "https://javatpoint.com";
        return testWebsite;
    }
}
