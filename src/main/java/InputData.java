public class InputData {
    private String startingWebsite;
    private int crawlingDepth;
    private String targetLanguage;

    public String getStartingWebsite() {
        return startingWebsite;
    }

    public void setStartingWebsite(String startingWebsite) {
        this.startingWebsite = startingWebsite;
    }

    public int getCrawlingDepth() {
        return crawlingDepth;
    }

    public void setCrawlingDepth(int crawlingDepth) {
        this.crawlingDepth = crawlingDepth;
    }

    public String getTargetLanguage() {
        return targetLanguage;
    }

    public void setTargetLanguage(String targetLanguage) {
        this.targetLanguage = targetLanguage;
    }
}
