public class Main {

    public static void main(String[] args) {

        // testWebCrawlerFromMain();

        // WebCrawler webCrawler = new WebCrawler("https://javatpoint.com");
        WebCrawler webCrawler = new WebCrawler("https://w3schools.com");

        Website website = webCrawler.getWebsiteHeadingsAndLinks();
        System.out.println("Website: " + website.url);
        System.out.println("\nHeadings: ");
        for (String heading : website.headings) {
            System.out.println(heading);
        }
        System.out.println("\nFunctional Links:");
        for (String functionalLink : website.functionalLinks) {
            System.out.println(functionalLink);
        }
        System.out.println("\nBroken Links:");
        for (String brokenLink : website.brokenLinks) {
            System.out.println(brokenLink);
        }

        /*
        UserData userData;
        WebsiteList websiteList;

        UserQuery userQuery = new UserQuery();
        userData = userQuery.getUserData();

        CrawlingDispatcher crawlingDispatcher = new CrawlingDispatcher(userData);
        websiteList = crawlingDispatcher.getWebsiteList();

        ResultProducer resultProducer = new ResultProducer(userData, websiteList);
        resultProducer.makeMdDocument();

        // todo: send the result on to make a pdf-document


        // todo: input websiteList to ResultProducer, then remove this

        for (int i = 0; i < websiteList.size(); i++) {
            System.out.println("\nheadings of website " + i + ":");
            for (int j = 0; j < websiteList.get(0).headings.size(); j++) {
                System.out.println("  " + websiteList.get(0).headings.get(j));
            }

            System.out.println("\nfunctionalLinks of website " + i + ":");
            for (int j = 0; j < websiteList.get(0).functionalLinks.size(); j++) {
                System.out.println("  " + websiteList.get(0).functionalLinks.get(j));
            }

            System.out.println("\nbrokenLinks of website " + i + ":");
            for (int j = 0; j < websiteList.get(0).brokenLinks.size(); j++) {
                System.out.println("  " + websiteList.get(0).brokenLinks.get(j));
            }
            websiteList.remove(0);
        } */
    }

    static void testWebCrawlerFromMain() {
        WebCrawler webCrawler = new WebCrawler("https://javatpoint.com");
        // WebCrawler webCrawler = new WebCrawler("https://w3schools.com");

        Website website = webCrawler.getWebsiteHeadingsAndLinks();
        System.out.println("Website: " + website.url);
        System.out.println("\nHeadings: ");
        for (String heading : website.headings) {
            System.out.println(heading);
        }
        System.out.println("\nFunctional Links:");
        for (String functionalLink : website.functionalLinks) {
            System.out.println(functionalLink);
        }
        System.out.println("\nBroken Links:");
        for (String brokenLink : website.brokenLinks) {
            System.out.println(brokenLink);
        }
    }
}

