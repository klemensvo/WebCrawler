import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class StartingWebsite {
    String url;

    public String getStartingWebsiteFromUser() {
        Scanner scanner = new Scanner(System.in);
        do {
            printPromptForStartingWebsite();
            url = scanner.nextLine();
            prependHttpsIfNecessary();
        } while (!isValidWebsite(url));
        return url;
    }

    public void printPromptForStartingWebsite() {
        System.out.print("Please enter a starting website: ");
    }

    protected void prependHttpsIfNecessary() {
        if (!url.startsWith("https://")) {
            url = "https://" + url;
        }
    }

    protected boolean isValidWebsite(String urlToBeValidated) {
        try {
            // if the next two lines pass, the URL is valid (todo)
            URL debatableUrl = new URL(urlToBeValidated);
            debatableUrl.toURI();
            return true;
        } catch (MalformedURLException | URISyntaxException e) {
            return false;
        }
    }

    public String getUrl() {
        return url;
    }
}