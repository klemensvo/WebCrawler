import com.deepl.api.Language;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TargetLanguage {

    String targetLanguage;


    protected static String getTargetLanguageFromUser() {
        String targetLanguage;
        do {
            printPromptForTargetLanguage();

            String userInput = getUserInputLanguage();//original user input

            String formatedUserInput = getFormattedInputLanguage(userInput); //brings the string f.e. "CHInESE" to form "Chinese"

            String normalizedLanguageVariant = getNationalLanguageFormat(formatedUserInput);// converts to an API specific form f.e. "Chinese (simplified)"

            targetLanguage = normalizedLanguageVariant.trim();

        } while (!isValidTargetLanguage(targetLanguage));

        return targetLanguage;
    }

    //todo: add functionality to check if the chosen API supports the user defined target language
    protected static boolean isValidTargetLanguage(String targetLanguage) {
        DeeplAPIWrapper deeplAPIWrapper = new DeeplAPIWrapper();
        List<Language> supportedAPILanguages = deeplAPIWrapper.getSupportedLanguages();
        ArrayList <String> supportedLanguages = deeplAPIWrapper.getSupportedLanguageNamesList(supportedAPILanguages);

        if(!supportedLanguages.contains(targetLanguage)){
            return false;
        }
        return true;
    }

    private static void printPromptForTargetLanguage(){
        System.out.print("Please enter a target language: ");
    }

    protected static String getUserInputLanguage(){      //example output "English"
        Scanner scanner = new Scanner(System.in);
        String userInputLanguage = scanner.nextLine();
        return userInputLanguage;
    }

    public static String getFormattedInputLanguage (String language){
        String formattedInputLanguage = language.substring(0,1).toUpperCase()+language.substring(1).toLowerCase();
        return formattedInputLanguage;
    }

    //convertion is required by Deepl API
    protected static String getNationalLanguageFormat (String inputLanguageString){
        String formattedLanguageString;
        if(inputLanguageString.equals("English")){
            formattedLanguageString = "English "+"(British)";
        }else if(inputLanguageString.equals("Portuguese")){
            formattedLanguageString = "Portuguese "+"(European)";
        }else if(inputLanguageString.equals("Chinese")){
            formattedLanguageString = "Chinese "+"(simplified)";
        }else{
            formattedLanguageString = inputLanguageString;
        }
        return formattedLanguageString;
    }


}

/* todo: change API
import com.google.cloud.translate.Language;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TargetLanguage {

    String targetLanguage;  //causes problems. todo: fix
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

    protected String getTargetLanguageAsISO639Code(String targetLanguageName){ //todo: should have a parameter String, accepts targetLanguage from UserData
        Iterable<Language> supportedLanguages = getSupportedLanguagesFromTranlateAPI();
        for (Language language: supportedLanguages){
            if(targetLanguageName.equals(language.getName())){
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
} */