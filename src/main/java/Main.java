public class Main {

    public static void main(String[] args) {
        UserQuery userQuery = new UserQuery();
        userQuery.start();

        CrawlingManager crawlingManager = new CrawlingManager();
        crawlingManager.start();
    }
}

