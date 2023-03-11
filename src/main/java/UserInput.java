import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class UserInput {
    private String url;
    private int crawlDepth;
    private String targetLanguage;

    public String getUrl() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Please enter a valid website: ");
            url = scanner.nextLine();
        } while (!isValidURL(url));
        // url = addHttpsTo(url); // todo: is this doing more than one thing?
        return url;
    }

    private boolean isValidURL(String urlToBeValidated) {
        /* todo: prepend "https://" if not provided
        if (!urlToBeValidated.startsWith("https://")) {
            urlToBeValidated = "https://" + urlToBeValidated;
        } */
        try {
            URL debatableUrl = new URL(urlToBeValidated);
            debatableUrl.toURI();
            return true;
        } catch (MalformedURLException | URISyntaxException e) {
            return false;
        }
    }

    private String addHttpsTo(String url) { // todo: remove function if not used
        return "https://" + url;
    }
}
