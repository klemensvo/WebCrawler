import com.deepl.api.*;
import java.util.*;

public class DeeplAPIWrapper {

    private final String API_AUTH_KEY = "ecac6743-0147-be5d-5240-0fe60c397b08:fx";

    Translator translator;

    public DeeplAPIWrapper (){
        this.translator=new Translator(API_AUTH_KEY);
    }




    public List <Language> getLanguages (){
        List <Language> languageList = new ArrayList<>();
        try {
             languageList= translator.getTargetLanguages();

        }catch (Exception e){
            e.printStackTrace();
        }
        return languageList;
    }

    //to check if the user´s input language is supported
    public ArrayList<String> getLanguageNamesList (List <Language> languageList){
        ArrayList<String> languageNamesList = new ArrayList<>();
        for(Language language:languageList){
            languageNamesList.add(language.getName());
        }
        return languageNamesList;
    }

    //return the code of the user´s input language
    public String getLanguageCode (String inputLanguage) {
        String languageCode="";
        List <Language> languages = getLanguages();
        for(Language language: languages){
            if(language.getName().equals(inputLanguage)) {
               languageCode= language.getCode();
            }
        }
        return languageCode;
    }

    public String getTranslatedHeading (String heading, String targetLanguageCode) throws Exception {
        String translatedHeading = "";
        try {
            TextResult textResult = translator.translateText(heading, null, targetLanguageCode); //the source language is auto-detected
            translatedHeading = textResult.getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return translatedHeading;
    }


}
