public class Main {
    public static void main(String[] args) {
        String startingWebsite;
        int crawlingDepth;
        String targetLanguage;

        new Texts().printWelcome();

        startingWebsite = new UserInput().getStartingWebsiteFromUser();
        crawlingDepth = new UserInput().getCrawlingDepthFromUser();
        targetLanguage = "German"; // todo: implement prompt for targetLanguage in UserInput

        System.out.println("\nStarting website: " + startingWebsite +
                ", crawling depth: " + crawlingDepth +
                ", target language: " + targetLanguage); // todo: delete later
    }
}

