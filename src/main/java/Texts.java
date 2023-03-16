public class Texts {
    public void printWelcomeText() {
        System.out.println("\nWelcome to WebCrawler\n");
        System.out.println("Please kindly enter a website to start,");
        System.out.println("the depth of websites to crawl and");
        System.out.println("the target language:\n");
    }

    public void printPromptStartingWebsite() {
        System.out.print("Please enter a starting website: ");
    }

    public void printPromptCrawlingDepth() {
        System.out.println("Please enter the crawling depth (max. 3): ");
    }
}
