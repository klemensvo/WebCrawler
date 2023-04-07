public class UserQuery {
    final StartingWebsite startingWebsite = new StartingWebsite();
    final CrawlingDepth crawlingDepth = new CrawlingDepth();
    final TargetLanguage targetLanguage = new TargetLanguage();
    final UserData userData = new UserData();


    public UserData getUserData() {

        new Text().printWelcome();
        userData.startingWebsite = getStartingWebsiteFromUser();
        userData.crawlingDepth = getCrawlingDepthFromUser();
        userData.targetLanguage = getTargetLanguageFromUser();

        // summaryOfUserInput(); // todo: side-effect, delete later

        return userData;
    }

    public String getStartingWebsiteFromUser() {
        return startingWebsite.getStartingWebsiteFromUser();
    }

    public int getCrawlingDepthFromUser() {
        return crawlingDepth.getCrawlingDepthFromUser();
    }

    public String getTargetLanguageFromUser() {
        return targetLanguage.getTargetLanguageFromUser();
    }

    protected String summaryOfUserInput() {
         return "\nStarting website: " + userData.startingWebsite +
                ", crawling depth: " + userData.crawlingDepth +
                ", target language: " + userData.targetLanguage;
    }
}