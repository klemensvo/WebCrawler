public class Main {

    public static void main(String[] args) throws Exception {
        UserData userData;
        WebsiteNode rootNode;

        UserQuery userQuery = new UserQuery();
        userData = userQuery.getUserData();

        CrawlingDispatcher crawlingDispatcher = new CrawlingDispatcher(userData);
        crawlingDispatcher.crawlWeb();
        rootNode = crawlingDispatcher.getRootNode();

        TranslatorCustom translator = new TranslatorCustom(rootNode, userData.targetLanguage);
        translator.translateWebsiteNodes();
        // translatedRootNode = translator.getTranslatedRootNode();

       // todo: change to translatedRootNode as soon as translation works
        ResultProducer resultProducer = new ResultProducer(userData, rootNode);
        String mdString = resultProducer.makeMdString();

        FileGenerator fileGenerator = new FileGenerator();
        String mdFileName = "Web_Crawler_Report.md";
        fileGenerator.createMdFile(mdString, mdFileName);
    }


}