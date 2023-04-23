public class Main {

    public static void main(String[] args) {

        UserData userData;
        WebsiteNode rootNode;

        UserQuery userQuery = new UserQuery();
        userData = userQuery.getUserData();

        CrawlingDispatcher crawlingDispatcher = new CrawlingDispatcher(userData);
        rootNode = crawlingDispatcher.crawlWebAndGetRootNode();
        // rootNode = crawlingDispatcher.getRootNode();

        ResultProducer resultProducer = new ResultProducer(userData, rootNode);
        resultProducer.makeMdDocument();

        // todo: send the result on to make a pdf-document


        // todo: input websiteNode to ResultProducer, then remove this
        /*
        for (int i = 0; i < websiteNode.size(); i++) {
            System.out.println("\nheadings of website " + i + ":");
            for (int j = 0; j < websiteNode.get(0).headings.size(); j++) {
                System.out.println("  " + websiteNode.get(0).headings.get(j));
            }

            System.out.println("\nfunctionalLinks of website " + i + ":");
            for (int j = 0; j < websiteNode.get(0).functionalLinks.size(); j++) {
                System.out.println("  " + websiteNode.get(0).functionalLinks.get(j));
            }

            System.out.println("\nbrokenLinks of website " + i + ":");
            for (int j = 0; j < websiteNode.get(0).brokenLinks.size(); j++) {
                System.out.println("  " + websiteNode.get(0).brokenLinks.get(j));
            }
            websiteNode.remove(0);
        } */
    }
}