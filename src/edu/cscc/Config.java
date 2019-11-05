package edu.cscc;

import java.io.IOException;
import java.util.Properties;

/**
 * Process webserver configuration
 * @author Chrsitin Goff, Robert Linse, Melanie O'Neill
 */
public class Config {
    public static final String PORT = 80;
    public static final String DEFAULTPAGE = "html/index.html";
    public static final String DEFAULTFOLDER = "html/";

    private static final String CONFIG_FILE = "resources/TinyWS.xml";
    private static Properties properties;

    public Config() {
        // TODO code here
        // This is your constructor
        this.PORT = PORT;
        this.DEFAULTFOLDER = DEFAULTPAGE;
        this.DEFAULTPAGE = DEFAULTPAGE;
        this.CONFIG_FILE = CONFIG_FILE;
        this.properties = properties;
    }

    public void readProperties() throws IOException {
        try {
            File file = new File CONFIG_FILE;
            FileInputStream fileInput = new FileInputStream(file);


        }catch (FileNotFoundException e){
            e.printStackTrace{};
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public void dumpProperties() {
        // TODO code here
    }
}
