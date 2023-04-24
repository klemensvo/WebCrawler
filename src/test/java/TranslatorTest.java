import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TranslatorTest {

    @Test
    void testGetSourceLanguage(){
        Translator translator = new Translator();
        String result = translator.getSourceLanguage("Heute");

        Assertions.assertEquals("de", result);
    }

    @Test
    void testGetTranslatedHeading(){
        Translator translator = new Translator();
        String heading = "Heute ist Sonntag";
        translator.targetLanguageCode="en";
        String result = translator.getTranslatedHeading(heading);
        System.out.println(result);

        Assertions.assertEquals("Today is Sunday", result);
    }

}
