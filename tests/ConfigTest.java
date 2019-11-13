package edu.cscc;

import org.junit.Test;
import org.junit.Before;


import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class ConfigTest {
    private Properties properties = new Propeties();

    @Before
    public void init(){
        InputStream input = new FileInputStream("TinyWS.xml");
        properties.loadFromXML(input);
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
        config.readProperties();
        assertEquals(config.getProperty("port"),properties.getProperty("port"));
        assertEquals(config.getProperty("defaultFolder"),properties.getProperty("defaultFolder"));
        assertEquals(config.getProperty("defaultPage"),properties.getProperty("defaultPage"));
    }
}