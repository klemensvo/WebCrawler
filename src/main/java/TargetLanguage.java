public class TargetLanguage {
    String targetLanguage;

    String getTargetLanguageFromUser() {
        String targetLanguage = "German";
        do {

        } while (!isValidTargetLanguage());
        return targetLanguage;
    }

    protected boolean isValidTargetLanguage() {

        return true;
    }

    public String getLanguage() {
        return targetLanguage;
    }
}