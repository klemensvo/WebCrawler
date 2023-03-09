import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldTest {

    private HelloWorld helloWorld;

    @BeforeEach
    void setUp() {
        helloWorld = new HelloWorld();
    }

    @AfterEach
    void tearDown() {
        helloWorld = null;
    }

    @Test
    void sayHelloWorld() {
        String result = helloWorld.sayHello();
        assertEquals("Hello World", result);
    }

    @Test
    void saySomethingElse() {
        String result = helloWorld.sayHello();
        assertNotEquals("Something Else", result);
    }
}