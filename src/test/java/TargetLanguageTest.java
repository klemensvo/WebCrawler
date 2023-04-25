import org.junit.jupiter.api.Test;

class TargetLanguageTest {

    @Test
    void getTargetLanguageFromUser() {
    }

    @Test
    void isValidTargetLanguage() {
    }

    @Test
    void getLanguage() {
    }
}

/* todo: change API and the test accordingly
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;



class TargetLanguageTest {

    @Test
    void getTargetLanguageFromUserOK() {
        InputStream originalSystemInput = System.in;
        String testLanguage = "Ukrainian";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(testLanguage.getBytes());
        System.setIn(byteArrayInputStream);

        TargetLanguage targetLanguage = new TargetLanguage();
        String result = targetLanguage.getTargetLanguageFromUser();

        assertEquals("Ukrainian", result);

        System.setIn(originalSystemInput);
    }

    @Test
    void testIsValidTargetLanguageOK() {
        TargetLanguage targetLanguage = new TargetLanguage();
        targetLanguage.targetLanguage="Polish";
        Assertions.assertTrue(targetLanguage.isValidTargetLanguage());
    }

    @Test
    void testIsValidTargetLanguageFail(){
        TargetLanguage targetLanguage = new TargetLanguage();
        targetLanguage.targetLanguage = "BabyLanguage";
        Assertions.assertFalse(targetLanguage.isValidTargetLanguage());
    }

    @Test
    void testGetUserInputLanguage(){
        InputStream originalSystemInput = System.in;
        String testLanguage = "English";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(testLanguage.getBytes());
        System.setIn(byteArrayInputStream);

        TargetLanguage targetLanguage = new TargetLanguage();
        String result = targetLanguage.getUserInputLanguage();
        assertEquals("English", result);

        System.setIn(originalSystemInput);
    }

    @Test
    void testGetTargetLanguageAsISO639CodeOK(){
        TargetLanguage targetLanguage = new TargetLanguage();
        targetLanguage.targetLanguage = "Spanish";

        assertEquals("es", targetLanguage.getTargetLanguageAsISO639Code());
    }

    @Test
    void testGetTargetLanguageAsISO639Fail(){
        TargetLanguage targetLanguage = new TargetLanguage();
        targetLanguage.targetLanguage = "BabyLanguage";

        assertEquals(null, targetLanguage.getTargetLanguageAsISO639Code());
    }
}
 */