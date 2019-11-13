package edu.cscc;

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
    public void init() {

        try {
            InputStream input = new FileInputStream("TinyWebServer/resources/TinyWS.xml");
            properties.loadFromXML(input);
        }
        catch (IOException e) {
            System.out.println("There was an issue with Loading the XML");
            e.printStackTrace();
        }
    }

    @Test
    public void readProperties() {
        try {
            Config config = new Config();
            config.readProperties();
            assertEquals(config.getProperties(),properties);
        }
        catch (IOException e) {
            System.out.println("There was an issue reading the properties");
            e.printStackTrace();
        }
    }

    @Test
    public void getProperty() {
        try {
            Config config = new Config();
            config.readProperties();
            assertEquals(config.getProperty("port"),properties.getProperty("port"));
            assertEquals(config.getProperty("defaultFolder"),properties.getProperty("defaultFolder"));
            assertEquals(config.getProperty("defaultPage"),properties.getProperty("defaultPage"));
        } catch (IOException e) {
            System.out.println("There was an issue reading the config properties file.");
            e.printStackTrace();
        }
    }
}