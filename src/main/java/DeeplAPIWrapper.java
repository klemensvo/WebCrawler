import com.deepl.api.*;



import java.util.*;

public class DeeplAPIWrapper {

    private final String API_AUTH_KEY = "ecac6743-0147-be5d-5240-0fe60c397b08:fx";

    Translator translator;

    public DeeplAPIWrapper (){
        this.translator=new Translator(API_AUTH_KEY);
    }


    //todo: replace with a Hashmap
    public List <Language> getLanguages () throws Exception{
        List <Language> languageList = new ArrayList<>();
        try {
             languageList= translator.getTargetLanguages();


        }catch (Exception e){
            e.printStackTrace();
        }
        return languageList;
    }


    /*public ArrayList <String> getLanguageName () {
        ArrayList <Language> languageList = getLanguages();
        ArrayList <String> languageNamesList = new ArrayList<String>();
        String name;

        for(Language language: languageList){
            name = language.getName();
            languageNamesList.add(name);
        }
        return languageNamesList;
    }
    */











}
