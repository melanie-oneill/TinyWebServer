package edu.cscc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Process webserver configuration
 * @author Melanie O'Neill, Christin Goff, Robert Linse
 */
public class Config {
    public static final String PORT = "port";
    public static final String DEFAULTPAGE = "defaultPage";
    public static final String DEFAULTFOLDER = "defaultFolder";

    private static final String CONFIG_FILE = "./TinyWS.xml";
    private static Properties properties;


    public Config() {
    }

    public void readProperties() throws IOException {
        InputStream input = new FileInputStream(CONFIG_FILE);
        properties.loadFromXML(input);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public void dumpProperties() {
        System.out.println(properties.toString());

    }

    public Properties getProperties(){
        return properties;
    }
}
