import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import TinyWS.TinyWebServer.src.edu.cscc.Config.java;


public class ConfigRunner {

    @Test
    public void main() {
        MyClass tester = new ConfigRunner(); // ConfigRunner is tested

        // assert statements
        assertEquals(0, tester.multiply(10, 0), "10 x 0 must be 0");
        assertEquals(0, tester.multiply(0, 10), "0 x 10 must be 0");
        assertEquals(0, tester.multiply(0, 0), "0 x 0 must be 0");
    }
}