public class Main {

    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        userInput.start();

        CrawlingManager crawlingManager = new CrawlingManager();
        crawlingManager.start();
    }
}

