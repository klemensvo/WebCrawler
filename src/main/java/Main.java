public class Main {

    public static void main(String[] args) {
        UserData userData;
        CrawlingList<Website> crawlingList;

        UserQuery userQuery = new UserQuery();
        userData = userQuery.getUserData();

        CrawlingManager crawlingManager = new CrawlingManager(userData);
        crawlingList = crawlingManager.getWebsites();

        // todo: input crawlingList to ResultProducer
        System.out.println("\nheadings of crawlingList: \n" + crawlingList);

    }
}

