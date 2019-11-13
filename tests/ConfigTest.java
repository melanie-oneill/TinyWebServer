import edu.cscc.Config;
import org.junit.Test;
import org.junit.Before;

import org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@RunWith(JUnit4.class)
public class ConfigTest {
    private static Properties properties = new Properties();

    @Before
    public void init() {
        InputStream input = new FileInputStream("TinyWS.xml");
        try {
            properties.loadFromXML(input);
        }
        catch (IOException e) {
            System.out.println("There was an issue with Loading the XML");
            e.printStackTrace();
        }
    }

    @Test
    public void readProperties() {
        Config config = new Config();
        config.readProperties();
        assertEquals(config.getProperties(),properties);
    }

    @Test
    public void getProperty() {
        Config config = new Config();
        try {
            config.readProperties();
        } catch (IOException e) {
            System.out.println("There was an issue reading the config properties file.");
            e.printStackTrace();
        }
        assertEquals(config.getProperty("port"),properties.getProperty("port"));
        assertEquals(config.getProperty("defaultFolder"),properties.getProperty("defaultFolder"));
        assertEquals(config.getProperty("defaultPage"),properties.getProperty("defaultPage"));
    }
}