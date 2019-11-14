package edu.cscc;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

/**
 * Process webserver configuration
 * @author Melanie O'Neill, Christin Goff, Robert Linse
 * @date November 2019
 *
 */
public class Config {
    public static final String PORT = "port";
    public static final String DEFAULTPAGE = "defaultPage";
    public static final String DEFAULTFOLDER = "defaultFolder";

    private static final String CONFIG_FILE = "TinyWebServer/resources/TinyWS.xml";
    private static Properties properties = new Properties();


    /**
     * @description: This constructor instantiates the Config class.
     */
    public Config() {
        readProperties();
        dumpProperties();
    }

    /**
     * @description: This method reads the configuration file.
     * @throws IOException
     * @returns void
     */
    public void readProperties() {
        try {
            InputStream input = new FileInputStream(CONFIG_FILE);
            properties.loadFromXML(input);
            input.close();
        }
        catch (IOException i) {
            System.out.println("The Input Stream failed.");
        }
        catch (Exception e) {
            System.out.println("The loadFromXML function failed.");
        }
    }

    /**
     * @description: This method returns the individual property when
     * given a key value.
     * @param key
     * @return String
     */
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    /**
     * @description: This method outputs the properties into the console.
     * @return void
     */
    public void dumpProperties() {
        System.out.println(properties.toString());
    }

    /**
     * @description: This method returns the properties of the config file.
     * @return Properties
     */
    public Properties getProperties(){
        return properties;
    }
}
