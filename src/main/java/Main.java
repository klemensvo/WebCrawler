public class Main {
    public static void main(String[] args) {
        new Texts().printWelcomeText();
        String startingWebsite = new UserInput().getStartingWebsiteFromUser();
        int crawlingDepth = new UserInput().getCrawlingDepthFromUser();

        System.out.println(startingWebsite); // todo: delete later
    }
}

