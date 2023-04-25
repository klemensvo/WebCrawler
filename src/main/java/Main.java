public class Main {

    public static void main(String[] args) {
        UserData userData;
        WebsiteNode rootNode;

        UserQuery userQuery = new UserQuery();
        userData = userQuery.getUserData();

        CrawlingDispatcher crawlingDispatcher = new CrawlingDispatcher(userData);
        crawlingDispatcher.crawlWeb();
        rootNode = crawlingDispatcher.getRootNode();


        // Translator translator = new Translator(rootNode, userData.targetLanguage);
        // translator.translateWebsiteNodes();
        // translatedRootNode = translator.getTranslatedRootNode(); */

        ResultProducer resultProducer = new ResultProducer(userData, rootNode); // todo: change to translatedRootNode
        String result = resultProducer.makeMdDocument();

        System.out.println(result);
        // todo: send the result on to make a pdf-document
    }
}