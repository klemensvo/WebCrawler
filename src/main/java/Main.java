import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        UserData userData;
        ArrayList<Website> websites;

        UserQuery userQuery = new UserQuery();
        userData = userQuery.getUserData();

        CrawlingManager crawlingManager = new CrawlingManager(userData);
        websites = crawlingManager.getWebsites();

        // todo: input websites to ResultProducer, then remove this
        System.out.println("\nheadings of websites: \n");
        while (!websites.isEmpty()) {
            for (int i = 0; i < websites.get(0).headings.size(); i++) {
                System.out.println(websites.get(0).headings.get(i));
            }
            websites.remove(0);
        }

    }
}

