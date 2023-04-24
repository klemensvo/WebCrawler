import com.google.cloud.translate.*;

import java.util.ArrayList;

public class Translator {

    UserData userData = new UserData();
    String targetLanguage = userData.targetLanguage;


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
        String translatedHeading;
        String sourceLanguage = getSourceLanguage(heading);
        String targetLanguageCode = getTargetLanguageAsISO639Code();

        Translate translate = TranslateOptions.getDefaultInstance().getService();
        Translation translation = translate.translate(heading, Translate.TranslateOption.sourceLanguage(sourceLanguage),
                Translate.TranslateOption.targetLanguage(targetLanguageCode));
        translatedHeading = translation.getTranslatedText();

        return translatedHeading;
    }

    protected String getSourceLanguage(String heading){
        String sourceLanguageCode ="";
        Translate translate = TranslateOptions.getDefaultInstance().getService();
        Detection detection = translate.detect(heading);
        sourceLanguageCode = detection.getLanguage();

        return sourceLanguageCode;
    }

    protected String getTargetLanguageAsISO639Code(){
        String languageCodeISO639="";
        Iterable<Language> supportedLanguages = getSupportedLanguagesWithCodeFromTranlateAPI();
        for (Language language: supportedLanguages){
            if(targetLanguage==language.getName()){
                languageCodeISO639=language.getCode();
            }
        }
        return languageCodeISO639;
    }

    Iterable<Language> getSupportedLanguagesWithCodeFromTranlateAPI(){
        Translate translate = TranslateOptions.getDefaultInstance().getService();
        Iterable<Language> languages = translate.listSupportedLanguages();
        return languages;
    }
}

