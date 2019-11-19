package edu.cscc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TinyWS a simplistic Tiny Web Server
 * @author student name here
 */
public class TinyWS {

    private static int port;
    private static String defaultFolder;
    private static String defaultPage;
    private static Config config = new Config();
    private static boolean systemRunning = true;

    public static void main(String[] args) {
        try {
            TinyWS webServer = new TinyWS();
            System.out.println("Server is listening on http://localhost:"+port);
            webServer.listen();
        }
        catch (IOException ioe){
            System.out.println("Something broke in the socket creation.");
            fatalError(ioe);
        }
        catch (Exception e){
            System.out.println("Something broke.");
            fatalError(e);
        }
    }

    public TinyWS() {
            port = Integer.parseInt(config.getProperty("port"));
            defaultFolder = config.getProperty("defaultFolder");
            defaultPage = config.getProperty("defaultPage");
            systemRunning = this.systemRunning;
    }

    public void listen() throws IOException {
        ServerSocket serverSocket = new ServerSocket(getPort());
        serverSocket.setSoTimeout(0);
        do {
            try {
                Socket s = serverSocket.accept();
                log(s.getInetAddress().getCanonicalHostName());
                RequestHandler requestHandler = new RequestHandler(s);
                requestHandler.processRequest();
                s.close();
            }
            catch (Exception e) {System.out.println("Socket closed.");}
        } while(systemRunning);
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
