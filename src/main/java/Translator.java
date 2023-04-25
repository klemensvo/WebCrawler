import com.google.cloud.translate.*;

import java.util.ArrayList;

public class Translator {

    WebsiteNode rootNode;
    String targetLanguageCode;

    TargetLanguage targetLanguage = new TargetLanguage();

    public Translator(WebsiteNode rootNode, String targetLanguageName) {
        this.rootNode = rootNode;
        this.targetLanguageCode = targetLanguage.getTargetLanguageAsISO639Code(targetLanguageName);

    }

    public void translateWebsiteNodes() {
        recursiveTranslate(rootNode, 0);
    }

    private void recursiveTranslate(WebsiteNode websiteNode, int depth) {

        // todo: Abbruchkriterium der Rekursion

        if (websiteNode.getWebsite() != null) {
            ArrayList<String> headings = websiteNode.getWebsite().headings;

            for (String heading : headings) {
                String[] headingLevelAndHeading = heading.split(" ", 2);
                // uses only the number of the string "h1 Example Heading", result: '1'
                int headingLevel = Integer.parseInt(headingLevelAndHeading[0].substring(1));

                String headingToTranslate = headingLevelAndHeading[1]; // only heading text
                String translatedHeading = getTranslatedHeading(headingToTranslate);

                websiteNode.getWebsite().tranlatedHeadings.add(headingLevel + " "
                        + translatedHeading);
            }

        }

        // recursive call to children
        for (
                WebsiteNode child : websiteNode.getChildren()) {
            recursiveTranslate(child, depth + 1);
        }
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


    }

