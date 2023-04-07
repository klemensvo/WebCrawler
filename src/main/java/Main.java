public class Main {

    public static void main(String[] args) {
        UserData userData;

        UserQuery userQuery = new UserQuery();
        userData = userQuery.getUserData();

        CrawlingManager crawlingManager = new CrawlingManager(userData);
        crawlingManager.getWebsites();
    }
}

