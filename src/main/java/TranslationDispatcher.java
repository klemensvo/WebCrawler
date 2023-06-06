import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class TranslationDispatcher {

    DeeplAPIWrapper deeplAPIWrapper;
    WebsiteNode rootNode;
    String targetLanguage;

    public TranslationDispatcher(WebsiteNode rootNode, String targetLanguage) {
        this.rootNode = rootNode;
        this.targetLanguage = targetLanguage;
        this.deeplAPIWrapper = new DeeplAPIWrapper();
    }

    public void translateWebsiteNodes() throws Exception {
        try {
            recursiveTranslate(rootNode);
        } catch (Exception e) {
            ExceptionLogger.log(e);
        }
    }

    private String getTargetLanguageCode() {
        return deeplAPIWrapper.getLanguageCode(targetLanguage);
    }

    private void recursiveTranslate(WebsiteNode websiteNode) throws Exception {
        if (websiteNode.getWebsite() == null) {
            return;
        }

        ArrayList<String> headings = websiteNode.getWebsite().headings;

        List<CompletableFuture<Void>> translationFutures = headings.parallelStream()
                .filter(heading -> !heading.isEmpty())
                .map(heading -> {
                    String[] headingLevelAndHeading = heading.split(" ", 2);
                    int headingLevel = Integer.parseInt(headingLevelAndHeading[0].substring(1));
                    String headingToTranslate = headingLevelAndHeading[1];

                    CompletableFuture<String> translationFuture = CompletableFuture.supplyAsync(() -> {
                        try {
                            return deeplAPIWrapper.getTranslatedHeading(headingToTranslate, getTargetLanguageCode());
                        } catch (Exception e) {
                            ExceptionLogger.log(e);
                            return null;
                        }
                    });

                    return translationFuture.thenAcceptAsync(translatedHeading -> {
                        if (translatedHeading != null) {
                            websiteNode.getWebsite().translatedHeadings.add(headingLevel + " " + translatedHeading);
                        }
                    });
                })
                .collect(Collectors.toList());

        CompletableFuture.allOf(translationFutures.toArray(new CompletableFuture[0])).join();

        // recursive call to children
        for (WebsiteNode child : websiteNode.getChildren()) {
            recursiveTranslate(child);
        }
    }
}


/*
import com.google.cloud.translate.*;
import com.google.gson.internal.bind.util.ISO8601Utils;

import java.util.ArrayList;

public class Translator {

    TargetLanguage targetLanguage = new TargetLanguage();
    String targetLanguageCode = targetLanguage.getTargetLanguageAsISO639Code();

    protected ArrayList<String> getTranslatedListOfHeadings(ArrayList<String> headings){
        String translation;
        ArrayList<String> translatedHeadings = new ArrayList<>();

        for(String heading: headings){
            translation=getTranslatedHeading(heading);
            translatedHeadings.add(translation);
        }

        return translatedHeadings;
    }

    protected String getTranslatedHeading(String heading){
        String sourceLanguage = getSourceLanguage(heading);

        Translate translate = TranslateOptions.getDefaultInstance().getService();
        Translation translation = translate.translate(heading, Translate.TranslateOption.sourceLanguage(sourceLanguage),
                Translate.TranslateOption.targetLanguage(targetLanguageCode));

        String translatedHeading = translation.getTranslatedText();

        return translatedHeading;
    }

    protected String getSourceLanguage(String heading){
        String sourceLanguageCode="";
        try {
            Translate translate = TranslateOptions.getDefaultInstance().getService();
            Detection detection = translate.detect(heading);
            sourceLanguageCode = detection.getLanguage();
        }catch (TranslateException e){
            System.out.println("The text language cannot be detected.");
        }

        return sourceLanguageCode;
    }
} */
