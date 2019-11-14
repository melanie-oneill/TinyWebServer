package edu.cscc;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnit4.class)

public class ConfigTest {
    private static Properties properties = new Properties();

    @Before
    public void setUp() {
            try {
                InputStream input = new FileInputStream("TinyWebServer/resources/TinyWS.xml");
                properties.loadFromXML(input);
            }
            catch (Exception e) {
                System.out.println("Something went wrong in the initialization of properties");
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
            config.readProperties();
            assertEquals(config.getProperty("port"),properties.getProperty("port"));
            assertEquals(config.getProperty("defaultFolder"),properties.getProperty("defaultFolder"));
            assertEquals(config.getProperty("defaultPage"),properties.getProperty("defaultPage"));
    }
}