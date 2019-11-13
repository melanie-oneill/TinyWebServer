package edu.cscc;

/**
 * TinyWS a simplistic Tiny Web Server
 * @author student name here
 */
public class TinyWS {

    //changed port from int to string to make constructor work
    private static String port;
    private static String defaultFolder;
    private static String defaultPage;
    private static Config config;

    public static void main(String[] args) {
        TinyWS webServer = new TinyWS();
        webServer.listen();
    }

    public TinyWS() {
        port = config.getProperty(port);
        defaultFolder = config.getProperty(defaultFolder);
        defaultPage = config.getProperty(defaultPage);
    }

    public void listen() {
       // TODO add code here
    }

    /**
     * Log web server requests
     * @param s - message to log
     */
    public static void log(String s) {
        System.out.println(s);
    }

    /**
     * Handle fatal error - print info and die
     */
    public static void fatalError(String s) {
        handleError(s, null, true);
    }

    /**
     * Handle fatal error - print info and die
     */
    public static void fatalError(Exception e) {
        handleError(null, e, true);
    }

    /**
     * Handle fatal / non-fatal errors
     */
    public static void handleError(String s, Exception e, boolean isFatal) {
        if (s != null) {
            System.out.println(s);
        }
        if (e != null) {
            e.printStackTrace();
        }
        if (isFatal) System.exit(-1);
    }

    /**
     * Get port configuration value
     * @return port number
     */
    public static int getPort() {
        return port;
    }

    /**
     * Get default HTML folder
     * @return folder
     */
    public static String getDefaultFolder() {
        return defaultFolder;
    }

    /**
     * Get name of default web page
     * @return default page
     */
    public static String getDefaultPage() {
        return defaultPage;
    }
}
