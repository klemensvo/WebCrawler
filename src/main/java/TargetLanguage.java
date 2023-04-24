import com.google.cloud.translate.Language;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TargetLanguage {
    String targetLanguage="German";  //causes problems. todo: fix
    String targetLanguageCode;

    String getTargetLanguageFromUser() {
        do {
            printPromptForTargetLanguage();
            targetLanguage = getUserInputLanguage();
        } while (!isValidTargetLanguage());
        return targetLanguage;
    }

    String getUserInputLanguage(){      //example output "English"
        Scanner scanner = new Scanner(System.in);
        String userInputLanguage = scanner.nextLine();
        return userInputLanguage;
    }

    protected String getTargetLanguageAsISO639Code(){
        Iterable<Language> supportedLanguages = getSupportedLanguagesFromTranlateAPI();
        for (Language language: supportedLanguages){
            if(targetLanguage.equals(language.getName())){
                targetLanguageCode=language.getCode();
            }
        }
        return targetLanguageCode;
    }


    Iterable<Language> getSupportedLanguagesFromTranlateAPI(){
        Translate translate = TranslateOptions.getDefaultInstance().getService();
        Iterable<Language> languages = translate.listSupportedLanguages();
        return languages;
    }


    protected boolean isValidTargetLanguage() {
        String languageName;
        List <String> languageNamesList = new ArrayList<>();
        Iterable<Language> apiLanguageList = getSupportedLanguagesFromTranlateAPI();
        for(Language language: apiLanguageList){
            languageName=language.getName();
            languageNamesList.add(languageName);
        }
        if(languageNamesList.contains(targetLanguage)){
            return true;
        }else{
           return false;
        }

    }

    private void printPromptForTargetLanguage(){
        System.out.print("Please enter a target language (for example \"English\"): ");
    }
}