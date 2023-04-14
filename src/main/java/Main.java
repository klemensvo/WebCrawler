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

        for (int i = 0; i < websites.size(); i++) {
            System.out.println("\nheadings of website " + i + ":");
            for (int j = 0; j < websites.get(0).headings.size(); j++) {
                System.out.println("  " + websites.get(0).headings.get(j));
            }

            System.out.println("\nfunctionalLinks of website " + i + ":");
            for (int j = 0; j < websites.get(0).functionalLinks.size(); j++) {
                System.out.println("  " + websites.get(0).functionalLinks.get(j));
            }

            System.out.println("\nbrokenLinks of website " + i + ":");
            for (int j = 0; j < websites.get(0).brokenLinks.size(); j++) {
                System.out.println("  " + websites.get(0).brokenLinks.get(j));
            }
            websites.remove(0);
        }
    }
}

