public class Texts {
    public void printWelcome() {
        System.out.println("\nWelcome to WebCrawler\n");
        System.out.println("Please kindly enter a website to start,");
        System.out.println("the depth of websites to crawl and");
        System.out.println("the target language:\n");
    }

    public void printPromptForStartingWebsite() {
        System.out.print("Please enter a starting website: ");
    }

    public void printPromptForCrawlingDepth() {
        System.out.print("Please enter the crawling depth (max. 3): ");
    }
}
