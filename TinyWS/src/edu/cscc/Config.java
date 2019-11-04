package edu.cscc;

import java.io.IOException;
import java.util.Properties;

/**
 * Process webserver configuration
 * @author student name
 */
public class Config {
    public static final String PORT = "port";
    public static final String DEFAULTPAGE = "defaultPage";
    public static final String DEFAULTFOLDER = "defaultFolder";

    private static final String CONFIG_FILE = "./TinyWS.xml";
    private static Properties properties;

    public Config() {
        // TODO code here
    }

    public void readProperties() throws IOException {
        // TODO code here
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public void dumpProperties() {
        // TODO code here
    }
}
