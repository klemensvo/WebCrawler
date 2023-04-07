import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartingWebsite {
    protected String startingUrl;

    public String getStartingWebsiteFromUser() {
        Scanner scanner = new Scanner(System.in);
        do {
            printPromptForStartingWebsite();
            startingUrl = scanner.nextLine();
            prependHttpsIfNecessary();
        } while (!isValidWebsite());
        return startingUrl;
    }

    private void printPromptForStartingWebsite() {
        System.out.print("Please enter a starting website: ");
    }

    protected void prependHttpsIfNecessary() {
        if (!startingUrl.startsWith("https://")) {
            startingUrl = "https://" + startingUrl;
        }
    }

    protected boolean isValidWebsite() {
        // regular expression tests for valid URL
        String regex = "^(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(startingUrl);

        if (matcher.matches()) {
            try {
                new URL(startingUrl);
                return true;
            } catch (MalformedURLException e) {
                return false;
            }
        } else {
            return false;
        }
    }

    public String getUrl() {
        return startingUrl;
    }
}