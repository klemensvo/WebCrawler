import com.deepl.api.*;
import com.sun.java.accessibility.util.Translator;

import javax.security.auth.callback.LanguageCallback;
import java.util.*;

public class DeeplAPIWrapper {

    private final String API_AUTH_KEY = "ecac6743-0147-be5d-5240-0fe60c397b08:fx";

    Translator translator;

    public DeeplAPIWrapper (){
        this.translator=new Translator(API_AUTH_KEY);
    }

    public List <Language> getLanguages () throws Exception{
        List<Language> languageList = new List<Language>();

        try {
             languageList= translator.getSourceLanguages();
        }catch (Exception e){
            e.printStackTrace();
        }
        return languageList;
    }










}
