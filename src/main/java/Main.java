public class Main {

    public static void main(String[] args) {
        UserData userData;
        WebsiteNode rootNode;

        UserQuery userQuery = new UserQuery();
        userData = userQuery.getUserData();

        CrawlingDispatcher crawlingDispatcher = new CrawlingDispatcher(userData);
        crawlingDispatcher.crawlWeb();
        rootNode = crawlingDispatcher.getRootNode();

        // todo: Translator: change API
        // Translator translator = new Translator(rootNode, userData.targetLanguage);
        // translator.translateWebsiteNodes();
        // translatedRootNode = translator.getTranslatedRootNode(); */

        // todo: change to translatedRootNode as soon as translation works
        ResultProducer resultProducer = new ResultProducer(userData, rootNode);
        String mdString = resultProducer.makeMdString();

        FileGenerator fileGenerator = new FileGenerator();
        String mdFileName = "Web_Crawler_Report.md";
        fileGenerator.createMdFile(mdString, mdFileName);
    }
}