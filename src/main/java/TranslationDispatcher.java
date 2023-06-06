import java.util.ArrayList;

public class TranslationDispatcher {

    DeeplAPIWrapper deeplAPIWrapper;
    WebsiteNode rootNode;
    String targetLanguage;



    public TranslationDispatcher(WebsiteNode rootNode, String targetLanguage) {
        this.rootNode = rootNode;
        this.targetLanguage = targetLanguage;
        this.deeplAPIWrapper=new DeeplAPIWrapper();
    }

    public void translateWebsiteNodes() throws Exception {
        try {
            recursiveTranslate(rootNode, 0);
        }catch (Exception e){
            ExceptionLogger.log(e);
        }
    }

    private String getTargetLanguageCode(){
        return deeplAPIWrapper.getLanguageCode(targetLanguage);
    }

    private void recursiveTranslate(WebsiteNode websiteNode, int depth) throws Exception {

        if (websiteNode.getWebsite() == null) { //Abbruchbedingung für Rekursion
            return;
        }
            ArrayList<String> headings = websiteNode.getWebsite().headings;

            for (String heading : headings) {
                if(!heading.isEmpty()) {
                    String[] headingLevelAndHeading = heading.split(" ", 2);
                    // uses only the number of the string "h1 Example Heading", result: '1'
                    int headingLevel = Integer.parseInt(headingLevelAndHeading[0].substring(1));

                    String headingToTranslate = headingLevelAndHeading[1]; // heading


                    String translatedHeading = deeplAPIWrapper.getTranslatedHeading(headingToTranslate, getTargetLanguageCode());

                    websiteNode.getWebsite().translatedHeadings.add(headingLevel + " "
                            + translatedHeading);
                }
            }

        // recursive call to children
        for (WebsiteNode child : websiteNode.getChildren()) {
            recursiveTranslate(child, depth + 1);
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