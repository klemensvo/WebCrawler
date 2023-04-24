public class Main {

    public static void main(String[] args) {

        UserData userData;
        WebsiteList websiteList;

        UserQuery userQuery = new UserQuery();
        userData = userQuery.getUserData();

        CrawlingDispatcher crawlingDispatcher = new CrawlingDispatcher(userData);
        websiteList = crawlingDispatcher.getWebsiteList();

        ResultProducer resultProducer = new ResultProducer(userData, websiteList);
        resultProducer.makeMdDocument();

        LanguageTest languageTest = new LanguageTest();
        System.out.println(languageTest.getTranslation());

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
        }
    }
}